package hospitalqueue;

public class HospitalQueue {
	
	public static void criticalitySort(Patient[] patient, int n) {
		
	    for (int i=0; i<n-1; i++) {
	    	boolean swapp = false;
	    	
	    	for(int j=0; j<n-1; j++) {
	    		 
	    		if(patient[j].criticality < patient[j + 1].criticality)  {
	    			
	    			Patient temp = patient[j];
					patient[j] = patient[j+1];
					patient[j + 1] = temp;
	    			}	    			    		
	    	}
	    	
	    }
	    
		
	}
public static void printPatients(Patient[] patients, int n) {
		
		for(int i=0; i<n; i++) {
			 System.out.println(
		                patients[i].name + " and Criticality: " + patients[i].criticality
		     );
		}
	}

}


