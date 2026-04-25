package homework15.Ex3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();

        students.add(new Student("Student1", "Group A", 1, Arrays.asList(4, 5, 4, 5, 3)));
        students.add(new Student("Student2", "Group B", 2, Arrays.asList(2, 3, 2, 4, 2))); // <3
        students.add(new Student("Student3", "Group A", 1, Arrays.asList(5, 5, 5, 4, 5)));
        students.add(new Student("Student4", "Group C", 3, Arrays.asList(3, 3, 3, 4, 3))); // =3.2
        students.add(new Student("Student5", "Group B", 2, Arrays.asList(2, 2, 2, 2, 2))); // <3
        students.add(new Student("Student4", "Group C", 3, Arrays.asList(3, 3, 3, 3, 3))); // =3

        System.out.println("=== Исходное состояние коллекции: ===");
        StudentManagement.printAllStudents(students);

        System.out.println("\n=== Обработка коллекции ===");
        StudentManagement.proccessStudents(students);

        System.out.println("\n=== После обработки коллекции ===");
        StudentManagement.printAllStudents(students);

        System.out.println("\n=== Поиск студентов по курсу ===");
        StudentManagement.printStudents(students, 2);
        StudentManagement.printStudents(students, 3);
        StudentManagement.printStudents(students, 4);
    }
}
