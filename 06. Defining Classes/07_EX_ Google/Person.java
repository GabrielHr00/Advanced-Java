import java.util.*;

public class Person {
    private String name;
    private Company company;
    private Car car;
    private List<Parent> parentList;
    private ArrayList<Child> childList;
    private Set<Pokemon> pokemonList;

    public Person(String name, Company company, Car car, List<Parent> parentList, ArrayList<Child> childList, Set<Pokemon> pokemonList) {
        this.name = name;
        this.company = company;
        this.car = car;
        this.parentList = parentList;
        this.childList = childList;
        this.pokemonList = pokemonList;
    }

    public Person(String name, Company company) {
        this.name = name;
        this.company = company;
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = new LinkedHashSet<>();
    }

    public Person(String name, Car car) {
        this.name = name;
        this.car = car;
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = new LinkedHashSet<>();
    }

    public Person(String name, List<Parent> parentList) {
        this.name = name;
        this.parentList = parentList;
        this.childList = new ArrayList<>();
        this.pokemonList = new LinkedHashSet<>();
    }

    public Person(String name, Set<Pokemon> pokemonList) {
        this.name = name;
        this.parentList = new ArrayList<>();
        this.childList = new ArrayList<>();
        this.pokemonList = pokemonList;
    }

    public Person(String name, ArrayList<Child> childList) {
        this.name = name;
        this.parentList = new ArrayList<>();
        this.childList = childList;
        this.pokemonList = new LinkedHashSet<>();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public void setParentList(Parent parent) {
        this.parentList.add(parent);
    }

    public void setChildList(Child child) {
        this.childList.add(child);
    }

    public void setPokemonList(Pokemon pokemon) {
        this.pokemonList.add(pokemon);
    }

    @Override
    public String toString() {
        StringBuilder print = new StringBuilder();
        print.append(String.format(name + "%nCompany:%n"));
        if(company != null){
            print.append(String.format(company.getName() + " " + company.getDepartment() + " "));
            print.append(String.format("%.2f%n", company.getSalary()));
        }
        print.append(String.format("Car:%n"));
        if(car != null){
            print.append(String.format("%s %s%n", car.getModel(), car.getSpeed()));
        }
        print.append(String.format("Pokemon:%n"));
        if(pokemonList.size() != 0){
            for (var p : pokemonList) {
                print.append(String.format("%s %s%n", p.getName(), p.getType()));
            }
        }
        print.append(String.format("Parents:%n"));
        if(parentList.size() != 0){
            for (var p : parentList) {
                print.append(String.format("%s %s%n", p.getName(), p.getBirth()));
            }
        }
        print.append(String.format("Children:%n"));
        if(childList.size() != 0){
            for (var p : childList) {
                print.append(String.format("%s %s%n", p.getName(), p.getBirth()));
            }
        }
        return print.toString();
    }
}

