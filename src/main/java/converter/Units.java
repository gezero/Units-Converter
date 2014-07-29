package converter;

/**
 * @author Jiri
 */
public enum Units {
    Meter(1d),
    CentiMeter(100d),
    Foot(3.28084),
    Inch(39.3701),
    Yard(1.09361);

    private final double ratio;

    /**
     * @param ratio 1 meter is equal to ... Units
     */
    Units(double ratio) {
        this.ratio = ratio;
    }

    public static double calculateRatio(Units sourceUnit, Units targetUnit) {
        return targetUnit.getRatio() / sourceUnit.getRatio();
    }

    public double getRatio() {
        return ratio;
    }
}
