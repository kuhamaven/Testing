import org.junit.Assert;
import org.junit.Test;

import java.util.Iterator;

public class BoxTests {

    @Test
    public void test001(){
        Box<Car> box = new Box<>();

        Car car1 = new Car(10);
        car1.addFuel(10);
        Car car2 = new Car(15);

        box.addToBox(car1);
        box.addToBox(car2);

        Iterator<Car> iterator = box.iterator();

        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(car1,iterator.next());
        Assert.assertEquals(car2,iterator.next());
        Assert.assertNull(iterator.next());

    }

}
