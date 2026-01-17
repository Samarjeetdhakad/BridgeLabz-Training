package callcenter;

public class Customer {
	private String id;
	private String name;
	private boolean isVip;
	Customer(String id,String name,boolean isVip){
		this.id=id;
		this.name=name;
		this.isVip=isVip;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public boolean getVip() {
		return isVip;
	}
	public String toString() {
		return name+( "VIP=" + isVip);
	}

}