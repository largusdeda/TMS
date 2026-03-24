package homework7.ex3;

/**
 * @author Elena Chinarina
 *
 **/

public class Person implements Cloneable {
    private String name;
    private Address address;

    public Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Address getAddress() { return address; }
    public void setAddress(Address address) { this.address = address; }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person cloned = (Person) super.clone();
        cloned.address = new Address(this.address.getCity(), this.address.getStreet());
        return cloned;
    }

    @Override
    public String toString() {
        return "Имя: " + name + ", адрес: " + address;
    }
}
