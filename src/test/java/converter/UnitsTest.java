package converter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.closeTo;
import static org.junit.Assert.assertThat;

public class UnitsTest {

    public static final double ERROR = 0.00001;

    @Test
    public void testToString() throws Exception {
        assertThat(Units.Meter.toString(), is("m"));
        assertThat(Units.Centimeter.toString(), is("cm"));
        assertThat(Units.Yard.toString(), is("yd"));
        assertThat(Units.Foot.toString(), is("ft"));
        assertThat(Units.Inch.toString(), is("in"));

    }

    @Test
    public void testTranslate() throws Exception {

        assertThat(Units.translate("m"), is(Units.Meter));
        assertThat(Units.translate("cm"), is(Units.Centimeter));
        assertThat(Units.translate("yd"), is(Units.Yard));
        assertThat(Units.translate("ft"), is(Units.Foot));
        assertThat(Units.translate("in"), is(Units.Inch));

    }


    @Test
    public void testMeterToOthers() {
        double[] coefficients = {1, 0.5d, 2d, 100d, 1000d, 1234.567d};
        for (Units value : Units.values()) {
            for (double coefficient : coefficients) {
                assertThat(Units.Meter.convert(coefficient, value), is(closeToPerc(value.getRatio() * coefficient, ERROR)));
            }
        }
    }

    @Test
    public void feetToOthers() {
        double[] coefficients = {1, 0.5d, 2d, 100d, 1000d, 1234.567d};

        for (double coefficient : coefficients) {
            assertThat(Units.Foot.convert(coefficient, Units.Inch), is(closeToPerc(coefficient * 12, ERROR)));
            assertThat(Units.Foot.convert(coefficient, Units.Yard), is(closeToPerc(coefficient / 3, ERROR)));
            assertThat(Units.Foot.convert(coefficient, Units.Meter), is(closeToPerc(coefficient * 0.3048, ERROR)));
            assertThat(Units.Foot.convert(coefficient, Units.Centimeter), is(closeToPerc(coefficient * 30.48, ERROR)));
        }
    }

    private org.hamcrest.Matcher<Double> closeToPerc(double v, double error) {
        return closeTo(v, v * error);
    }

}