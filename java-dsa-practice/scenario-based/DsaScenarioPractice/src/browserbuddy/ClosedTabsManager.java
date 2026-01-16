package browserbuddy;
import java.util.Stack;
public class ClosedTabsManager {
	
	private Stack<TabHistory> closedTabs = new Stack<>();
	 public void closedTab(TabHistory tab) {
		 closedTabs.push(tab);
		 System.out.println("tab closed and saved");
	 }
	 
	 public TabHistory reopenTab() {
		 if (!closedTabs.isEmpty()) {
	            System.out.println("Reopening last closed tab");
	            return closedTabs.pop();
	        } else {
	            System.out.println("No closed tabs");
	            return null;
	        }
	 }

}
