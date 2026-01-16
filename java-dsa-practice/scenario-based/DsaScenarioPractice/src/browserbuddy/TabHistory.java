package browserbuddy;

public class TabHistory {
	private HistoryNode current;
	
    TabHistory(String homepage){
    	current = new HistoryNode(homepage);
    }
    
    public void visit(String url) {
        HistoryNode newPage = new HistoryNode(url);
        current.next = newPage;
        newPage.prev = current;
        current = newPage;
    }

    // Back button
    public void goBack() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Back to: " + current.url);
        } else {
            System.out.println("No previous page!");
        }
    }

    // Forward button
    public void goForward() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Forward to: " + current.url);
        } else {
            System.out.println("No forward page!");
        }
    }

    public String getCurrentPage() {
        return current.url;
    }
}
