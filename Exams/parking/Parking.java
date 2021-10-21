package parking;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Parking {
    private String type;
    private int capacity;
    private List<Car> data;

    public Parking(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public void add(Car car){
        if(capacity > data.size()){
            data.add(car);
        }
    }

    public boolean remove(String manufacturer, String model){
        return data.removeIf(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model));
    }

    public Car getLatestCar(){
        Car c = null;
        c = data.stream().max((e1,e2) -> Integer.compare(e1.getYear(), e2.getYear())).get();
        return c;
    }

    public Car getCar(String manufacturer, String model){
        try{
            Car c = data.stream().filter(e -> e.getManufacturer().equals(manufacturer) && e.getModel().equals(model)).collect(Collectors.toList()).get(0);
            return c;
        }catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public int getCount(){
        return data.size();
    }

    public String getStatistics(){
        StringBuilder s = new StringBuilder();
        s.append("The cars are parked in ").append(type).append(":").append(System.lineSeparator());
        for (var i : data) {
            s.append(i.toString()).append(System.lineSeparator());
        }
        return s.toString();
    }
}
