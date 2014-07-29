package converter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class LengthUnitsConverterTest {

    LengthUnitsConverter converter = new LengthUnitsConverter();
    double error = 0.00001;

    @Test
    public void testMeterToOthers() {
        double[] coefficients = {1, 0.5d, 2d, 100d, 1000d, 1234.567d};
        for (Units value : Units.values()) {
            for (double coefficient : coefficients) {
                assertThat(converter.convert(coefficient, Units.Meter, value), is(closeToPerc(value.getRatio() * coefficient, error)));
            }
        }
    }

    @Test
    public void feetToOthers() {
        double[] coefficients = {1, 0.5d, 2d, 100d, 1000d, 1234.567d};

        for (double coefficient : coefficients) {
            assertThat(converter.convert(coefficient, Units.Foot, Units.Inch), is(closeToPerc(coefficient * 12, error)));
            assertThat(converter.convert(coefficient, Units.Foot, Units.Yard), is(closeToPerc(coefficient / 3, error)));
            assertThat(converter.convert(coefficient, Units.Foot, Units.Meter), is(closeToPerc(coefficient *0.3048, error)));
            assertThat(converter.convert(coefficient, Units.Foot, Units.CentiMeter), is(closeToPerc(coefficient *30.48, error)));
        }
    }

    private org.hamcrest.Matcher<Double> closeToPerc(double v, double error) {
        return closeTo(v,v*error);
    }

}