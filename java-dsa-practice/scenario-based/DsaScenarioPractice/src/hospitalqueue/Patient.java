package hospitalqueue;

public class Patient {
	protected String name;
	protected int criticality;
	
	Patient(String name, int criticality){
		this.name = name;
		this.criticality= criticality;
	}

}
