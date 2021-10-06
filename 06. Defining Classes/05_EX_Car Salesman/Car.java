import java.util.Collection;

public class Car {
    private String model;
    private Engine engine;

    private int weight = 0;
    private String color;

    public Car(String model, Engine engine, int weight, String color) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = color;
    }

    public Car(String model, Engine engine, int weight) {
        this.model = model;
        this.engine = engine;
        this.weight = weight;
        this.color = "n/a";
    }

    public Car(String model, Engine engine, String color) {
        this.model = model;
        this.engine = engine;
        this.color = color;
    }

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.color = "n/a";
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getWeight() {
        return weight;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        StringBuilder print =  new StringBuilder(String.format(model + ": %n" +
                engine.getModel() + ": %n" +
                "Power: " + engine.getPower() + "%n"));
        if (engine.getDisplacement() == 0) {
            print.append(String.format("Displacement: n/a%n"));
        } else {
            print.append(String.format("Displacement: " + engine.getDisplacement() + '\n'));
        }
        print.append(String.format("Efficiency: " + engine.getEfficiency() + "%n"));
        if(weight == 0){
            print.append(String.format("Weight: n/a%nColor: " + color));
        }
        else{
            print.append(String.format("Weight: " + weight + "%nColor: " + color));
        }
        return print.toString();
    }
}
