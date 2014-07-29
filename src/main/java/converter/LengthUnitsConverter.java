package converter;

/**
 * @author Jiri
 */
public class LengthUnitsConverter {
    public double convert(double amount, Units sourceUnit, Units targetUnit) {
        return amount*Units.calculateRatio(sourceUnit,targetUnit);
    }
}
