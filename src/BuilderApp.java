public class BuilderApp {
    public static void main(String[] args){
//        Caar caar = new CarBuilder()
//                .buildMake("Merc")
//                .buildTransmission(Transmission.AUTO)
//                .buildMaxSpeed(280)
//                .build();
//        System.out.println(caar);

        Director director = new Director();
        director.setBuilder(new SubaruBuilder());
        Caar caar = director.buildCar();
        System.out.println(caar);
    }
}

enum Transmission{
    MANUAL, AUTO
}

class Caar{
    String make;
    Transmission transmission;
    int maxSpeed;

    public void setMake(String make){
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public String toString(){
        return "Car [make = " + make +
                ", transmission = " + transmission +
                ", max speed = " + maxSpeed +
                "]";
    }
}

abstract class CarBuilder{
    Caar car;
    void createCar(){
        car = new Caar();
    }
    abstract void buildMake();
    abstract void buildTransmission();
    abstract void buildMaxSpeed();

    Caar getCar(){
        return car;
    }
}

class FordMondeoBuilder extends CarBuilder{
    void buildMake() {
        car.setMake("Ford Mondeo");
    }

    void buildTransmission() {
        car.setTransmission(Transmission.AUTO);
    }

    void buildMaxSpeed(){
        car.setMaxSpeed(260);
    }
}

class SubaruBuilder extends CarBuilder{
    void buildMake() {
        car.setMake("Subaru");
    }

    void buildTransmission() {
        car.setTransmission(Transmission.MANUAL);
    }

    void buildMaxSpeed(){
        car.setMaxSpeed(320);
    }
}

class Director{
    CarBuilder carBuilder;
    void setBuilder(CarBuilder carBuilder){
        this.carBuilder = carBuilder;
    }
    Caar buildCar(){
        carBuilder.createCar();
        carBuilder.buildMake();
        carBuilder.buildTransmission();
        carBuilder.buildMaxSpeed();
        Caar caar = carBuilder.getCar();
        return caar;
    }
}

//class CarBuilder{
//    String m = "Default";
//    Transmission t = Transmission.MANUAL;
//    int s = 120;
//
//    CarBuilder buildMake(String m) {
//        this.m = m;
//        return this;
//    }
//
//    CarBuilder buildTransmission(Transmission t) {
//        this.t = t;
//        return this;
//    }
//
//    CarBuilder buildMaxSpeed(int s){
//        this.s = s;
//        return this;
//    }
//
//    Caar build(){
//        Caar car = new Caar();
//        car.setMake(m);
//        car.setTransmission(t);
//        car.setMaxSpeed(s);
//        return car;
//    }
//}
