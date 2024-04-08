import org.junit.Assert;
import org.junit.Test;

public class CarTests {

    @Test
    public void test001_addingFuelShouldModifyFuelValue(){
        Car car = new Car(10);
        car.addFuel(10);
        Assert.assertEquals(10,car.getFuel(),0);
        car.addFuel(20);
        Assert.assertEquals(30,car.getFuel(),0);
    }

    @Test
    public void test002_consumingFuelShouldIncreaseKmCount(){
        Car car = new Car(10);
        car.addFuel(10);
        car.consumeFuel(10);
        Assert.assertEquals(100,car.getKm(),0);
    }

    @Test (expected = RuntimeException.class)
    public void test003_addingNegativeFuelShouldntModifyFuelValue(){
        Car car = new Car(10);
        car.addFuel(-10);
    }

}
