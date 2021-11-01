public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Указан некорректный возраст " + age);
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = null;
        if (name == null || surname == null) {
            throw new IllegalStateException("Имя или фамилия не указана");
        }
        /*if(age<0){
            throw new IllegalStateException("Указан некорректный возраст "+ age);
        }*/
        if (age != 0) person = new Person(this.name, this.surname, this.age);
        else person = new Person(this.name, this.surname);

        return person;
    }
}
