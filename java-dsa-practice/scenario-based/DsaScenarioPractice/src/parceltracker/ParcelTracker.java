package parceltracker;

class ParcelTracker{

    private Stage head;   
    public void addInitialStage(String stageName){
        head=new Stage(stageName);
        System.out.println("Initial Stage Added" + stageName);
    }
    public void addStage(String stageName) {
        Stage newStage=new Stage(stageName);
        if (head==null) {
            head=newStage;
            return;
        }
        Stage temp=head;
        while (temp.next!=null) {
            temp=temp.next;
        }
        temp.next=newStage;
        System.out.println("Stage Added" + stageName);
    }
    public void addCheckpointAfter(String existingStage, String checkpointName) {
        Stage temp = head;
        while (temp!=null &&!temp.name.equals(existingStage)) {
            temp=temp.next;
        }
        if (temp==null) {
            System.out.println("Stage'" + existingStage + "'not found");
            return;
        }
        Stage checkpoint=new Stage(checkpointName);
        checkpoint.next=temp.next;
        temp.next=checkpoint;
        System.out.println("Checkpoint Added" + checkpointName + " after" + existingStage);
    }
    public void track(){
        System.out.println("Tracking Parcel");
        Stage temp=head;
        while (temp!=null) {
            System.out.println("Stage: " + temp.name);
            if (temp.next==null&&!temp.name.equals("Delivered")){
                System.out.println("Parcel might be lost");
                break;
            }
            temp=temp.next;
    }
   }
}