package hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Hotel {
    private String name;
    private int capacity;
    List<Person> roster;

    public Hotel(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public void add(Person person){
        if(capacity > roster.size()){
            roster.add(person);
        }
    }

    public boolean remove(String name){
        return roster.removeIf(e -> e.getName() == name);
    }

    // people
    public Person getPerson(String name, String hometown){
        try{
            Person p = this.roster.stream().filter(e -> e.getName().equals(name) && e.getHometown().equals(hometown))
                    .collect(Collectors.toList()).get(0);
            return p;
        }
        catch(IndexOutOfBoundsException e){
            return null;
        }
    }

    public int getCount(){
        return this.roster.size();
    }

    public String getStatistics(){
        StringBuilder sb = new StringBuilder();
        sb.append("The people in the hotel ").append(name).append(" are:").append(System.lineSeparator());
        for (var i : roster) {
            sb.append(i.toString()).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }
}
