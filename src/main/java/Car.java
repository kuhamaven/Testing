public class Car {
    private float fuel;
    private float km;
    private float kmPerLiter;

    public Car(float kmPerLiter) {
        fuel = 0;
        km = 0;
        this.kmPerLiter = kmPerLiter;
    }

    public void addFuel(float fuel){
        if(fuel<=0) throw new RuntimeException("Can't add negative fuel.");
        this.fuel += fuel;
    }

    public void consumeFuel(float fuel){
        km += kmPerLiter*fuel;
        this.fuel -= fuel;
    }

    public float getFuel() {
        return fuel;
    }

    public float getKm() {
        return km;
    }

}
