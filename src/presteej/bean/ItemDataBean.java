package presteej.bean;

import java.sql.Timestamp;

public class ItemDataBean {

	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemImgUrl;
	private int itemRegNo;
	private Timestamp itemStartDate;
	private Timestamp itemEndDate;
	private String itemDetail;
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemImgUrl() {
		return itemImgUrl;
	}
	public void setItemImgUrl(String itemImgUrl) {
		this.itemImgUrl = itemImgUrl;
	}
	public int getItemRegNo() {
		return itemRegNo;
	}
	public void setItemRegNo(int itemRegNo) {
		this.itemRegNo = itemRegNo;
	}
	public Timestamp getItemStartDate() {
		return itemStartDate;
	}
	public void setItemStartDate(Timestamp itemStartDate) {
		this.itemStartDate = itemStartDate;
	}
	public Timestamp getItemEndDate() {
		return itemEndDate;
	}
	public void setItemEndDate(Timestamp itemEndDate) {
		this.itemEndDate = itemEndDate;
	}
	public String getItemDetail() {
		return itemDetail;
	}
	public void setItemDetail(String itemDetail) {
		this.itemDetail = itemDetail;
	}
	
}