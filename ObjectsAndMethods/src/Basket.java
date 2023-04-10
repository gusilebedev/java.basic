public class Basket {

    private static int count = 0;
    private String items = "";
    private int limit;

    private static double averagePrice;
    private static double averagePriceBasket;

    private int basketPrice;
    private double totalWeight = 0;
    private static int totalPrice = 0;
    private static int totalCount = 0;

    public Basket() {
        increaseCount(1);
        items = "Список товаров:";
        this.limit = 1000000;
    }

    public Basket(int limit) {
        this();
        this.limit = limit;
    }

    public Basket(String items, int totalPrice) {
        this();
        this.items = this.items + items;
        this.totalPrice = totalPrice;
    }

    public int getBasketPrice() {
        return basketPrice;
    }

    public static int getCount() {
        return count;
    }

    public static void increaseCount(int count) {
        Basket.count = Basket.count + count;
    }

    public static int getTotalPrice() {
        return totalPrice;
    }

    public static int getTotalCount() {
        return totalCount;
    }
    public static double getAveragePrice() {
        averagePrice = totalPrice / totalCount;
        return averagePrice;
    }
    public static double getAveragePriceBasket() {
        averagePriceBasket = totalPrice / count;
        return averagePriceBasket;
    }

    public void add(String name, int price) {
        add(name, price, 1);
    }

    public void add(String name, int price, int count) {
        add(name, price, count, 0);
    }

    public void add(String name, int price, int count, double weight) {
        boolean error = false;
        if (contains(name)) {
            error = true;
        }
        if (totalPrice + count * price >= limit) {
            error = true;
        }
        if (error) {
            System.out.println("Error occured :(");
            return;
        }
        items = items + "\n" + name + " - " + count + " шт. " + weight + " кг. - " + price + " руб.";
        basketPrice = basketPrice + count * price;
        totalWeight = totalWeight + weight * count;
        totalPrice = totalPrice + count * price;
        totalCount = totalCount + count;
    }
    public void clear() {
        items = "";
        totalPrice = 0;
        totalWeight = 0;
    }
    public double getTotalWeight() {
        return totalWeight;
    }

    public boolean contains(String name) {
        return items.contains(name);
    }

    public void print(String title) {
        System.out.println(title);
        if (items.isEmpty()) {
            System.out.println("Корзина пуста");
        } else {
            System.out.println(items);
            System.out.println("Стоимоть корзины: " + basketPrice + " руб.");
            System.out.println("Вес корзины: " + totalWeight + " руб.");
            System.out.println();
        }
    }
}
