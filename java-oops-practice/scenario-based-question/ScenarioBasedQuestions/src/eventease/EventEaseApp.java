package eventease;

public class EventEaseApp {
    public static void main(String[] args) {

        User user1 = new User("Samarjeet", "samarjeet@gmail.com");

        Event e1 = new BirthdayEvent("Riya's Birthday","Banquet Hall","10-Mar-2026",50,20000,user1);

        Event e2 = new ConferenceEvent("Tech Conference","Convention Center","25-Apr-2026",300,100000,40000, 10000, user1   );

        e1.schedule();
        e1.showDetails();

        e2.schedule();
        e2.showDetails();

        e2.reschedule("30-Apr-2026");
        e1.cancel();
    }
}
