import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDummyDesign {
    DummyDesign dummyDesign = new DummyDesign();

    @Test
    public void testIntegrante1() { assertEquals(dummyDesign.integrante1(), 1);}

    @Test
    public void testIntegrante4() {
        assertEquals(dummyDesign.integrante4(), 4);
    }

    @Test
    public void testIntegrante5() { assertEquals(dummyDesign.integrante5(), 5);}
    
    @Test
    public void testIntegrante6() {
    	assertEquals(dummyDesign.integrante6(), 6);
    }


}
