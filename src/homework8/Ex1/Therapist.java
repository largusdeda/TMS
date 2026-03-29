package homework8.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Therapist extends Doctor {
    @Override
    public void treat() {
        System.out.println("Терапевт назначает лечение и выписывает лекарства");
    }

    public void assignDoctor(Patient patient) {
        switch (patient.getTreatmentPlan()) {
            case 1:
                patient.setDoctor(new Surgeon());
                break;
            case 2:
                patient.setDoctor(new Dentist());
                break;
            default:
                patient.setDoctor(this);
                break;
        }
    }

    @Override
    public String toString() {
        return "Терапевт";
    }
}
