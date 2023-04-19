import org.redisson.Redisson;
import org.redisson.api.RKeys;
import org.redisson.api.RScoredSortedSet;
import org.redisson.api.RedissonClient;
import org.redisson.client.RedisConnectionException;
import org.redisson.config.Config;
import java.util.Date;
import java.util.Random;

import static java.lang.System.out;

public class RedisStorage {
    private RedissonClient redisson;
    private RKeys rKeys;
    private RScoredSortedSet<String> onlineUsers;

    private final static String KEY = "USERS";

    private double getTime() {
        return new Date().getTime();
    }
    public void listValues() throws InterruptedException {
        while (true) {
            Random random = new Random();
            String user = onlineUsers.first();
            out.println("На главной странице показываем пользователя №" + user);
            onlineUsers.remove(user);
            onlineUsers.add(getTime(),user);
            if (random.nextInt(10) == 0) {
                int index = random.nextInt(onlineUsers.size());
                String randomUser = onlineUsers.valueRange(index, index).iterator().next();
                out.println("Пользователь №" + randomUser + " оплатил платную услугу\n" +
                        "На главной странице показываем пользователя №" + randomUser);
                onlineUsers.remove(randomUser);
                onlineUsers.add(getTime(),randomUser);
            }
            Thread.sleep(1000);
        }
    }
    void init() throws InterruptedException {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379");
        try {
            redisson = Redisson.create(config);
        } catch (RedisConnectionException Exc) {
            out.println("Не удалось подключиться к Redis");
            out.println(Exc.getMessage());
        }
        rKeys = redisson.getKeys();
        onlineUsers = redisson.getScoredSortedSet(KEY);
        rKeys.delete(KEY);
    }
    void newUsers() throws InterruptedException {
        for(int i = 1; i <= 20; i++) {
            onlineUsers.add(getTime(), String.valueOf(i));
            Thread.sleep(10);
        }
    }
}
