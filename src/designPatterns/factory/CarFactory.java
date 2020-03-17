package designPatterns.factory;

public class CarFactory {

    public CarModel getCarModel(String carModel){
        if(carModel == null)
            return null;

        if(carModel.equalsIgnoreCase("Ferrari"))
            return new Ferrari();
        else if (carModel.equalsIgnoreCase("Tesla"))
            return new Tesla();

        return null;
    }
}
