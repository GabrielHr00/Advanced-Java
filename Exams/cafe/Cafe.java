package cafe;

import java.util.*;

public class Cafe {
    private String name;
    private int capacity;
    private List<Employee> employees;

    public Cafe(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.employees = new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        if(capacity > employees.size()){
            employees.add(employee);
        }
    }

    public boolean removeEmployee(String name){
        return employees.removeIf(employee -> employee.getName().equals(name));
    }

    public Employee getOldestEmployee(){
        return this.employees.stream().max((e1,e2) -> Integer.compare(e1.getAge(), e2.getAge())).get();
    }

    public Employee getEmployee(String name){
        Employee emp = null;
        for (var i : employees) {
            if(i.getName().equals(name)){
                emp = i;
            }
        }
        return emp;
    }

    public int getCount(){
        return this.employees.size();
    }

    public String report() {
        StringBuilder s = new StringBuilder();
        s.append("Employees working at Cafe ").append(name).append(":").append(System.lineSeparator());
        for (var i :employees) {
            s.append(i.toString()).append(System.lineSeparator());
        }
        return s.toString().trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

}
