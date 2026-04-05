package homework10.Ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Elena Chinarina
 *
 **/

public class User implements Cloneable {

    private int id;
    private String username;
    private String email;
    private int age;
    private Address address;
    private List<String> roles;

    public User(int id, String username, String email, int age, Address address, List<String> roles) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.age = age;
        this.roles = roles != null ? new ArrayList<>(roles) : null;
        this.address = address;
    }

    public int getId() {return id;}
    public void setId(int id) {this.id = id;}

    public String getUsername() {return username;}
    public void setUsername(String username) {this.username = username;}

    public String getEmail() {return email;}
    public void setEmail(String email) {this.email = email;}

    public int getAge() {return age;}
    public void setAge(int age) {this.age = age;}

    public Address getAddress() {return address;}
    public void setAddress(Address address) {this.address = address;}

    public List<String> getRoles() {return roles;}
    public void setRoles(List<String> roles) {this.roles = roles;}

    @Override
    public User clone() throws CloneNotSupportedException {
        return (User) super.clone();
    }

    public User(User other) throws CloneNotSupportedException {
        this.id = other.id;
        this.username = other.username;
        this.email = other.email;
        this.age = other.age;
        this.roles = new ArrayList<>(other.roles);
        this.address = other.address != null ? other.address.clone() : null;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                ", address=" + address +
                ", roles=" + roles +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        User user = (User) o;
        return id == user.id &&
                age == user.age &&
                Objects.equals(username, user.username) &&
                Objects.equals(email, user.email) &&
                Objects.equals(address, user.address) &&
                Objects.equals(roles, user.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, age, address, roles);
    }
}
