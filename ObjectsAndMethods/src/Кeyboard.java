public class  eyboard {
    private final KeyboardType keyboardType;
    private final LightType light;
    private final int keyboardMass;

    public  eyboard(KeyboardType keyboardType, LightType light, int keyboardMass) {
        this.keyboardType = keyboardType;
        this.light = light;
        this.keyboardMass = keyboardMass;
    }

    public KeyboardType getKeyboardType() {
        return keyboardType;
    }

    public LightType getLight() {
        return light;
    }

    public int getKeyboardMass() {
        return keyboardMass;
    }
    public String toString() {
        return keyboardType + " " + "ÔÓ‰Ò‚ÂÚÍ‡: " + light;
    }
}
