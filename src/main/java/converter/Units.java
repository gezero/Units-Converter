package converter;

/**
 * @author Jiri
 */
public enum Units {
    Meter(1d, "m"),
    Centimeter(100d, "cm"),
    Foot(3.28084, "ft"),
    Inch(39.3701, "in"),
    Yard(1.09361, "yd");

    private final double ratio;
    private String shortName;

    /**
     * @param ratio 1 meter is equal to ... Units
     */
    Units(double ratio, String shortName) {
        this.ratio = ratio;
        this.shortName = shortName;
    }


    public double calculateRatio( Units targetUnit) {
        return targetUnit.getRatio() / getRatio();
    }

    public double getRatio() {
        return ratio;
    }

    @Override
    public String toString() {
        return shortName;
    }

    public static Units translate(String shortName) {
        for (Units unit : Units.values()) {
            if (unit.toString().equals(shortName)) {
                return unit;
            }
        }
        throw new RuntimeException("Unit " + shortName + " was not found");
    }

    public double convert(double amount, Units targetUnit) {
        return amount*this.calculateRatio(targetUnit);
    }



}
