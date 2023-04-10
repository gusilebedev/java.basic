public class BoxCargo {
    private final Dimensions dimensions;
    private final double mass;
    private final String deliveryAddress;
    private final boolean verticalPosition;
    private final String barCode;
    private final boolean delicate;

    public BoxCargo(Dimensions dimensions, double mass, String deliveryAddress, boolean verticalPosition, String barCode, boolean delicate) {
        this.dimensions = dimensions;
        this.mass = mass;
        this.deliveryAddress = deliveryAddress;
        this.verticalPosition = verticalPosition;
        this.barCode = barCode;
        this.delicate = delicate;
    }
    public BoxCargo setDimensions(Dimensions dimensions) {
        return new BoxCargo(dimensions,mass,deliveryAddress,verticalPosition,barCode,delicate);
    }

    public BoxCargo setMass(double mass) {
        return new BoxCargo(dimensions,mass,deliveryAddress,verticalPosition,barCode,delicate);
    }

    public BoxCargo setDeliveryAddress(String deliveryAddress) {
        return new BoxCargo(dimensions,mass,deliveryAddress,verticalPosition,barCode,delicate);
    }
    public Dimensions getDimensions() {
        return dimensions;
    }
    public double getMass() {
        return mass;
    }
    public String getDeliveryAddress() {
        return deliveryAddress;
    }
    public boolean isVerticalPosition() {
        return verticalPosition;
    }
    public String getBarCode() {
        return barCode;
    }
    public boolean isDelicate() {
        return delicate;
    }
    public String toString() {
           return  dimensions + "\n"
                + "Вес груза: " + mass + "\n"
                + "Адрес доставки: " + deliveryAddress + "\n"
                + "Вертикальная перевозка: " + verticalPosition + "\n"
                + "Регистрационный номер: " + barCode + "\n"
                + "Хрупкий груз: " + delicate;
    }
}
