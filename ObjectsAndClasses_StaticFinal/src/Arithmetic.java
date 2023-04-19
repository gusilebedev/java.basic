public class Arithmetic {
    private static int addition = 0;
    private static int multiplication = 0;
    private static int max = 0;
    private static int min = 0;

    public static void main(String[] args) {
        additionNumber(7, 6);
        System.out.println("Cумма чисел = " + addition);
        System.out.println();
        multiplicationNumber(7, 6);
        System.out.println("Произведение чисел = " + multiplication);
        System.out.println();
        maxNumber(6, 7);
        System.out.println("Максимальное из двух чисел = " + max);
        System.out.println();
        minNumber(7,6);
        System.out.println("Минимальное из двух чисел = " + min);

    }

    public static int additionNumber(int a, int b) {
        addition = a + b;
        return addition;
    }

    public static int multiplicationNumber(int a, int b) {
        multiplication = a * b;
        return multiplication;
    }

    public static int maxNumber(int a, int b) {
        if (a >= b) {
            max = a;
        } else {
            max = b;
        }
        return max;
    }

    public static int minNumber(int a, int b) {
        if (a <= b) {
            min = a;
        } else {
            min = b;
        }
        return min;
    }
}
