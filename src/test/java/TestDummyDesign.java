import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDummyDesign {
    DummyDesign dummyDesign = new DummyDesign();

    @Test
    public void testIntegrante4() {
        assertEquals(dummyDesign.integrante4(), 4);
    }


}
