package homework8.Ex1;

import java.util.Scanner;

/**
 * @author Elena Chinarina
 *
 **/

public class Main {
    public static void main(String[] args) {
        Patient patient = new Patient();
        Therapist therapist = new Therapist();

        Scanner in = new Scanner(System.in);

        System.out.println("Введите код лечения (1 - хирург, 2 - дантист, другое - терапевт):");
        int treatmentCode = in.nextInt();
        in.close();

        patient.setTreatmentPlan(treatmentCode);
        therapist.assignDoctor(patient);

        System.out.println("Пациенту назначен врач: " + patient.getDoctor());

        patient.receiveTreatment();
    }
}
