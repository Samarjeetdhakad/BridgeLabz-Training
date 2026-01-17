package traincompanion;

public class TrainCompartment {
	private Compartment head;
	private Compartment tail;
	
	
	public void addCompartment(String name) {
	Compartment newNode=new Compartment(name);
		if(head==null) {
			head=tail=newNode;
		}
		else {
			tail.next=newNode;
			newNode.prev=tail;
			tail=newNode;
		}
	}
	

	public void remove(String name) {
		Compartment temp=head;
	     while (temp != null) {
	            if (temp.name.equalsIgnoreCase(name)) {

	                if (temp == head) {
	                    head = temp.next;
	                    if (head != null) head.prev = null;
	                } 
	                else if (temp == tail) {
	                    tail = tail.prev;
	                    if (tail != null) tail.next = null;
	                } 
	                else {
	                    temp.prev.next=temp.next;
	                    temp.next.prev=temp.prev;
	                }

	                System.out.println("Removed: " + name);
	                return;
	            }
	            temp = temp.next;
	        }
	        System.out.println("Compartment not found:" + name);
	    }
	public void moveForward() {
		System.out.println("moving forward");
		 Compartment temp=head;
		 while(temp!=null) {
			 System.out.println("name" + temp.name);
			 temp=temp.next;
		 }
	
	}
	public void moveBackward() {
		System.out.println("moving backward");
		Compartment temp=head;
		while(temp!=null) {
			 System.out.println("name" + temp.name);
			 temp=temp.prev;
		 }
		}
	 public void showAdjacent(String name) {
	        Compartment temp=head;
	        while (temp!=null) {
	            if (temp.name.equalsIgnoreCase(name)) {
	                System.out.println("Adjacent compartments for" + name);
	                System.out.println("Previous" + (temp.prev != null ? temp.prev.name : "None"));
	                System.out.println("Next" + (temp.next != null ? temp.next.name : "None"));
	                return;
	            }
	            temp=temp.next;
	        }
	        System.out.println("Compartment not found: " + name);
	    }
	}