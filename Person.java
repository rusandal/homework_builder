import java.io.StringBufferInputStream;
import java.util.List;
import java.util.Objects;
import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = age;
    }
    public boolean hasAge() {
        return this.getAge().isPresent();
    }
    public boolean hasAddress() {
        return !this.getAddress().isBlank();
    }

    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public void happyBirthday() {
        this.age = age + 1;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, address);
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder myChildren = new PersonBuilder();
        myChildren.setSurname(this.surname);
        myChildren.setAddress(this.address);
        myChildren.setAge(this.age);
        return myChildren;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
