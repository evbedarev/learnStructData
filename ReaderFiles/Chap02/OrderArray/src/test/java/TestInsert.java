import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class TestInsert {
    int maxSize = 100;
    OrdArray arr, arr2;                  // reference to array

    @Before
    public void before() {
        arr = new OrdArray(maxSize);   // create the array
        arr.insert(77);                // insert 10 items
        arr.insert(99);
        arr.insert(44);
        arr.insert(55);
        arr.insert(22);
        arr.insert(88);
        arr.insert(11);
        arr.insert(00);
        arr.insert(66);
        arr.insert(33);
    }

    @Test
    public void testInsert() {
        String array = "";
        for (int i=0; i < arr.size(); i++) {
            array =array + arr.getArray()[i];
        }
        Assert.assertTrue(array.equals("0112233445566778899"));
    }

    @Test
    public void testDelete() {
        String array = "";
        arr.delete(00);                // delete 3 items
        arr.delete(55);
        arr.delete(99);

        for (int i=0; i < arr.size(); i++) {
            array =array + arr.getArray()[i];
        }

        Assert.assertTrue(array.equals("11223344667788"));
    }

}
