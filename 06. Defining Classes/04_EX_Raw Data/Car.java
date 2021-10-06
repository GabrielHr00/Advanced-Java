import java.util.Collection;

public class Car {
    private String model;
    Engine engine;
    Cargo cargo;
    Collection<Tire> tires;

    public Car(String model, Engine engine, Cargo cargo, Collection<Tire> tires) {
        this.model = model;
        this.engine = engine;
        this.cargo = cargo;
        this.tires = tires;
    }

    public String getModel() {
        return model;
    }

    public Engine getEngine() {
        return engine;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public Collection<Tire> getTires() {
        return tires;
    }
}
