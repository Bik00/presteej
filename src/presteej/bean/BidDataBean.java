package presteej.bean;

import java.sql.Timestamp;

public class BidDataBean {
	
	private int itemId;
	private String userName;
	private int bidPrice;
	private Timestamp db;
	private String itemName;
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public int getBidPrice() {
		return bidPrice;
	}
	public void setBidPrice(int bidPrice) {
		this.bidPrice = bidPrice;
	}
	public Timestamp getDb() {
		return db;
	}
	public void setDb(Timestamp timestamp) {
		this.db = timestamp;
	}

}
