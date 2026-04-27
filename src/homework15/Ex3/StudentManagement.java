package homework15.Ex3;

import java.util.Iterator;
import java.util.List;

/**
 * @author Elena Chinarina
 *
 **/

public class StudentManagement {
    public static void proccessStudents(List<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            double avgGrade = student.getAverageGrade();

            if (avgGrade < 3.0) {
                iterator.remove();
                System.out.println("Студент " + student.getName() + " отчислен. Средний балл: " + avgGrade);
            } else {
                student.setCourse(student.getCourse() + 1);
                System.out.printf("Студент %s переведен на %d курс. Средний балл: %.2f\n",
                        student.getName(), student.getCourse(), avgGrade);
            }
        }
    }

    public static void printStudents(List<Student> students, int course) {
        System.out.println("Студенты, обучающиеся на " + course + " курсе:");

        boolean found = false;

        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.printf("\t- %s (Группа: %s)\n", student.getName(), student.getGroup());
                found = true;
            }
        }

        if (!found)
            System.out.println("\t- Студенты на данном курсе не найдены");
    }

    public static void printAllStudents(List<Student> students) {
        System.out.println("Все студенты в коллекции:");
        if (students.isEmpty()) {
            System.out.println("\t- ");
        } else {
            for (Student student : students) {
                System.out.println("\t-" + student);
            }
        }
    }
}
