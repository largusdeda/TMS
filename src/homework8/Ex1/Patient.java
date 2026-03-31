package homework8.Ex1;

/**
 * @author Elena Chinarina
 *
 **/

public class Patient {
    private int treatmentPlan;
    private Doctor doctor;


    public Doctor getDoctor() {
        return doctor;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public int getTreatmentPlan() {
        return treatmentPlan;
    }

    public void setTreatmentPlan(int treatmentPlan) {
        this.treatmentPlan = treatmentPlan;
    }

    public void receiveTreatment() {
        if (doctor != null) {
            doctor.treat();
        } else {
            System.out.println("Пациенту еще не назначен врач для лечения");
        }
    }
}
