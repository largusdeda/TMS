package homework7.ex3;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        try {
            Address address = new Address("Город N", "улица Пушкина");
            Person person = new Person("Абырвалг", address);
            System.out.println("Оригинал: " + person);

            Person clonedPerson = (Person) person.clone();
            System.out.println("Клон: " + clonedPerson);

            person.getAddress().setCity("Санкт-Петербург");
            person.getAddress().setStreet("Невский проспект");

            System.out.println("-- После изменения --");
            System.out.println("Оригинал: " + person);
            System.out.println("Клон: " + clonedPerson);
        } catch (CloneNotSupportedException e) {
            System.out.println("Клонирование не поддерживается");
        }
    }
}
