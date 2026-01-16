package browserbuddy;

public class BrowserBuddyMain {
	public static void main(String[] args) {
		
		TabHistory tab = new TabHistory("gooogle.com");
		ClosedTabsManager manager = new ClosedTabsManager();
		
		System.out.println("current homepage:"+ tab.getCurrentPage());
		
		tab.visit("youtube.com");
		System.out.println("visited"+ tab.getCurrentPage());
		
		tab.visit("github.com");
        System.out.println("Visited: " + tab.getCurrentPage());


        tab.goBack();  
        tab.goBack();  

        //Go Forward
        tab.goForward(); 

        //Close tab
        manager.closedTab(tab);

        //Reopen last closed tab
        TabHistory reopenedTab = manager.reopenTab();

        if (reopenedTab != null) {
            System.out.println("Reopened tab on: " + reopenedTab.getCurrentPage());
        }
    }
}