package ambulanceroute;

class AmbulanceRoute {
    private HospitalUnit head;

    // Add unit to circular list
    public void addUnit(String name, boolean available) {
        HospitalUnit newUnit = new HospitalUnit(name, available);

        if (head == null) {
            head = newUnit;
            head.next = head; 
            return;
        }
        
        HospitalUnit temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }
        temp.next = newUnit;
        newUnit.next = head; 
    }    
    public void findNearestAvailableUnit() {
        if (head == null) {
            System.out.println("No hospital units available!");
            return;
        }

        HospitalUnit current = head;
        do {
            System.out.println("Checking: " + current.name);

            if (current.available) {
                System.out.println("Patient redirected to: " + current.name);
                return;
            }

            current = current.next;

        } while (current != head);

        System.out.println("⚠️ No unit available at the moment!");
    }

    
    public void removeUnit(String name) {
        if (head == null) return;

        HospitalUnit current = head;
        HospitalUnit prev = null;

        do {
            if (current.name.equals(name)) {
                if (current == head) {
                    
                    HospitalUnit temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                } else {
                    prev.next = current.next;
                }

                System.out.println("Removed unit under maintenance:" + name);
                return;
            }

            prev = current;
            current = current.next;

        } while (current != head);

        System.out.println("Unit not found:" + name);
    }

    public void displayRoute() {
        if (head == null) {
            System.out.println("No units in route.");
            return;
        }

        HospitalUnit temp = head;
        do {
            System.out.print(temp.name + "  ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to start)");
    }
}
