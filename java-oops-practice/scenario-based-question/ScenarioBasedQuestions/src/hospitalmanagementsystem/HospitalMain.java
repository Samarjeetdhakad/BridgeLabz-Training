package hospitalmanagementsystem;

public class HospitalMain {
	public static void main(String[] args) {

        Patient p1=new InPatient("Rohan", 30, 5);
        Patient p2=new OutPatient("Anita", 25, "15-Sept-2025");

        Doctor d1=new Doctor("Dr. Sharma", "Cardiology");

        Bill bill=new Bill(500, 1500);

        p1.displayInfo();
        p2.displayInfo();
        d1.displayInfo();

        System.out.println("Total Bill Amount: "+ bill.calculatePayment());
    }
}