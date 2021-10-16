public class Person implements Comparable<Person>{
    private String name;
    private int age;
    private String town;

    public Person(String name, int age, String town) {
        this.name = name;
        this.age = age;
        this.town = town;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person o) {
        if(this.getName().compareTo(o.getName()) == 0){
            if(this.getAge() == o.getAge()){
                this.getTown().compareTo(o.getTown());
            }
            return Integer.compare(this.getAge(), o.getAge());
        }
        return this.getName().compareTo(o.getName());
    }
}
