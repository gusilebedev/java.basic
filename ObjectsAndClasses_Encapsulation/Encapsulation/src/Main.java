import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Dimensions dimensions = new Dimensions(2,3,1.4);
        Dimensions copyDimension = new Dimensions(dimensions.getWidth(), dimensions.getHeight(), dimensions.getLength());
        dimensions.setWidth(4);

        System.out.println(dimensions);
        System.out.println();

        BoxCargo wardrobe = new BoxCargo(dimensions,90, "Russia, Kostroma", false,"E893U89",false);
        BoxCargo copyWardrobe = new BoxCargo(dimensions,
                wardrobe.getMass(),
                wardrobe.getDeliveryAddress(),
                wardrobe.isVerticalPosition(),
                wardrobe.getBarCode(),
                wardrobe.isDelicate());
        wardrobe.setDeliveryAddress("Russia, Yaroslavl'");

        System.out.println(wardrobe);


    }
}
