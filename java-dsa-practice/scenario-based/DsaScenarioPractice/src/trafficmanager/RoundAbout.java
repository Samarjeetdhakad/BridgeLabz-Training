package trafficmanager;

public class RoundAbout {

    private Vehicle tail;
    private int size;
    private int capacity;

    RoundAbout(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.tail = null;
    }

    
    public boolean addVehicle(String number) {
        if (size == capacity) {
            System.out.println("Roundabout is full.");
            return false;
        }

        Vehicle newVehicle = new Vehicle(number);

        if (tail == null) {
            tail = newVehicle;
            tail.next = tail;
        } else {
            newVehicle.next = tail.next;
            tail.next = newVehicle;
            tail = newVehicle;
        }

        size++;
        System.out.println("Entered roundabout: " + number);
        return true;
    }

    
    public void removeVehicle() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle head = tail.next;

        if (head == tail) {
            System.out.println("Exited: " + head.number);
            tail = null;
        } else {
            System.out.println("Exited: " + head.number);
            tail.next = head.next;
        }

        size--;
    }

   
    public void printState() {
        if (tail == null) {
            System.out.println("Roundabout is empty.");
            return;
        }

        Vehicle current = tail.next;
        System.out.print("Roundabout: ");

        do {
            System.out.print(current.number + " → ");
            current = current.next;
        } while (current != tail.next);

        System.out.println("(Back to start)");
    }

    public boolean hasSpace() {
        return size < capacity;
    }
}