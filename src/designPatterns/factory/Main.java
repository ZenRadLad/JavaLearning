package designPatterns.factory;

public class Main {

    public static void main(String[] args) {
        //Instantiate the Factory
        CarFactory carFactory = new CarFactory();

        //Create new cars from the car factory
        CarModel laferrari = carFactory.getCarModel("Ferrari");
        CarModel F455 = carFactory.getCarModel("Ferrari");

        laferrari.createEngine();
        F455.createEngine();

        CarModel modelX = carFactory.getCarModel("Tesla");
        CarModel model3 = carFactory.getCarModel("Tesla");

        modelX.createEngine();
        model3.createEngine();
    }
}
