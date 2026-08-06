package com.bridgelabz.jdbcpractice.main;

import java.util.Scanner;

import com.bridgelabz.jdbcpractice.dao.AppointmentDAO;
import com.bridgelabz.jdbcpractice.dao.BillDAO;
import com.bridgelabz.jdbcpractice.dao.DepartmentDAO;
import com.bridgelabz.jdbcpractice.dao.DoctorDAO;
import com.bridgelabz.jdbcpractice.dao.PatientDAO;
import com.bridgelabz.jdbcpractice.model.Appointment;
import com.bridgelabz.jdbcpractice.model.Department;
import com.bridgelabz.jdbcpractice.model.Doctor;
import com.bridgelabz.jdbcpractice.model.Patient;

public class Main {
	public static void main(String []args) {
		
		Scanner sc = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();
        DepartmentDAO departmentDao = new DepartmentDAO();
        DoctorDAO drDao = new DoctorDAO();
        AppointmentDAO appointmentDao = new AppointmentDAO();
        BillDAO billDAO = new BillDAO();
		
		while (true) {

		    System.out.println("\n===== Health Clinic =====");
		    System.out.println("1. Add Patient");
		    System.out.println("2. View Patients");
		    System.out.println("3. search Patient");
		    System.out.println("4. Update Patient");
		    System.out.println("5. Delete Patient");
		    System.out.println("6. Add Doctor");
		    System.out.println("7. view doctors");
		    System.out.println("8. Add Department");
		    System.out.println("9. View Departments");
		    System.out.println("10. Schedule Appointment");
		    System.out.println("11 View Appointments");
		    System.out.println("12. Cancel Appointment");
		    System.out.println("13. Generate bill");
		    System.out.println("14. Exit");

		    System.out.print("Enter Choice: ");
		    int choice = sc.nextInt();
		    sc.nextLine();

		    switch (choice) {
		    case 1:

		        Patient patient = new Patient();

		        System.out.print("Enter Name: ");
		        patient.setName(sc.nextLine());

		        System.out.print("Enter Phone: ");
		        patient.setPhone(sc.nextLine());

		        System.out.print("Enter DOB (yyyy-mm-dd): ");
		        patient.setDob(sc.nextLine());

		        dao.addPatient(patient);
		        break;

		    case 2:

		        dao.viewPatients();
		        break;

		    case 3:
		    	
		    	Patient searchPatient = new Patient();
		    	
		    	System.out.println("enter the id");
		    	searchPatient.setPatientId(sc.nextInt());
		    	
		    	dao.searchPatient(searchPatient);
		    	break;
		    	
		    case 4:
		        Patient updatePatient = new Patient();

		        System.out.print("Enter Patient ID: ");
		        updatePatient.setPatientId(sc.nextInt());
		        sc.nextLine();

		        System.out.print("Enter New Name: ");
		        updatePatient.setName(sc.nextLine());

		        System.out.print("Enter New Phone: ");
		        updatePatient.setPhone(sc.nextLine());

		        System.out.print("Enter New DOB: ");
		        updatePatient.setDob(sc.nextLine());

		        dao.updatePatient(updatePatient);
		        break;

		    		    		    	 
		    case 5:
		   		    	
		        System.out.print("Enter Patient ID: ");
		        int id = sc.nextInt();

		        dao.deletePatient(id);
		        break;
		        		        		        
		    case 6:
		    	Doctor addDoctor = new Doctor();
		    	
		    	System.out.println("Enter Doctor Name");
		    	addDoctor.setName(sc.nextLine());

		    	System.out.println("Enter Specialty");
		    	addDoctor.setSpecialty(sc.nextLine());

		    	System.out.println("Enter Doctor Fee");
		    	addDoctor.setDoctorFee(sc.nextDouble());

		    	System.out.println("Enter Department ID");
		    	addDoctor.setDepartmentId(sc.nextInt());

		    	sc.nextLine(); 		    	
		    	drDao.addDoctor(addDoctor);
		    	
		    	break;
		    	
		    	
		    case 7:		    	
		    	drDao.viewDoctors();
		    	break;
		    	
		    case 8:		    	
		        Department department = new Department();
		        System.out.println("Enter Department Name:");
		        department.setDepartmentName(sc.nextLine());
		        departmentDao.addDepartment(department);
		        break;

		    case 9:
		        departmentDao.viewDepartments();
		        break;
		        
		    case 10:
		        Appointment appointment = new Appointment();

		        System.out.println("Enter Patient ID");
		        appointment.setPatientId(sc.nextInt());
		        sc.nextLine();

		        System.out.println("Enter Doctor ID");
		        appointment.setDoctorId(sc.nextInt());
		        sc.nextLine();

		        System.out.println("Enter Appointment Date (yyyy-MM-dd HH:mm:ss):");
		        appointment.setAppointmentDate(sc.nextLine());		     
		        appointment.setStatus("Scheduled");
		        appointmentDao.ScheduleAppointment(appointment);

		        break;
		        
		    case 11:
		        appointmentDao.ViewAppointment();
		        break;
		        
		    case 12:
		        System.out.println("Enter Appointment ID:");
		        int appointmentId = sc.nextInt();
		        appointmentDao.CancelAppointment(appointmentId);

		        break;

		    case 13:
		    	
		    	System.out.print("Enter Appointment ID : ");
		    	int appointmentID = sc.nextInt();

		    	System.out.print("Enter Medicine Charges : ");
		    	double medicineCharges = sc.nextDouble();

		    	billDAO.generateBill(
		    	        appointmentID,
		    	        medicineCharges
		    	);
		        
		    case 14:
		        System.out.println("Thank You!");		      
		        System.exit(0);

		        
		    default:
		        System.out.println("Invalid Choice");
		    }
		}
		
	}

}
