package converter;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class LengthUnitsConverterTest {

    @Test
    public void basicTest(){
        LengthUnitsConverter converter = new LengthUnitsConverter();

        assertThat(converter.convert(10d,Units.Meters,Units.Feet),is(10d));


    }

}