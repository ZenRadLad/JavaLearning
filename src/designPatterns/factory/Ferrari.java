package designPatterns.factory;

public class Ferrari implements CarModel {
    @Override
    public void createEngine() {
        System.out.println("Ferrari engine created");
    }
}
