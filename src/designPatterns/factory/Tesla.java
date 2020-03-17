package designPatterns.factory;

public class Tesla implements CarModel {
    @Override
    public void createEngine() {
        System.out.println("Tesla engine created");
    }
}
