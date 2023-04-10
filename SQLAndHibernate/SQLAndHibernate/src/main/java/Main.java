import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/?user=root";
        String user = "root";
        String pass = "Une2-co-a_caa";

        try {
            Connection connection = DriverManager.getConnection(url, user, pass);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(course_name)/(MAX(MONTH(subscription_date)) - \n" +
                    "MIN(MONTH(subscription_date))) AS average_value\n" +
                    "FROM skillbox.purchaselist\n" +
                    "where subscription_date between\n" +
                    "'2018-01-01 00:00:00' and '2018-12-31 23:59:59'\n" +
                    "GROUP BY course_name");
            while (resultSet.next()) {
                        String courseName = resultSet.getString("course_name");
                        String averageValue = resultSet.getString("average_value");
                        System.out.println(courseName + ": среднее количество покупок в месяц - " + averageValue);
                    }
            resultSet.close();
            statement.close();
            connection.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
