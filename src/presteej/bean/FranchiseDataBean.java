package presteej.bean;

import java.sql.Timestamp;

public class FranchiseDataBean {
	
	private int franId;
	private String franName;
	private int franPrice;
	private String franImgUrl;
	private int franRegNo;
	private int franValue;
	private Timestamp franStartDate;
	private Timestamp franEndDate;
	private Timestamp createdDate;

	public int getFranId() {
		return franId;
	}
	public void setFranId(int franId) {
		this.franId = franId;
	}
	public String getFranName() {
		return franName;
	}
	public void setFranName(String franName) {
		this.franName = franName;
	}
	public int getFranPrice() {
		return franPrice;
	}
	public void setFranPrice(int franPrice) {
		this.franPrice = franPrice;
	}
	public String getFranImgUrl() {
		return franImgUrl;
	}
	public void setFranImgUrl(String franImgUrl) {
		this.franImgUrl = franImgUrl;
	}
	public int getFranRegNo() {
		return franRegNo;
	}
	public void setFranRegNo(int franRegNo) {
		this.franRegNo = franRegNo;
	}
	public int getFranValue() {
		return franValue;
	}
	public void setFranValue(int franValue) {
		this.franValue = franValue;
	}
	public Timestamp getFranStartDate() {
		return franStartDate;
	}
	public void setFranStartDate(Timestamp franStartDate) {
		this.franStartDate = franStartDate;
	}
	public Timestamp getFranEndDate() {
		return franEndDate;
	}
	public void setFranEndDate(Timestamp franEndDate) {
		this.franEndDate = franEndDate;
	}
	public Timestamp getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}
	public String getFranDetail() {
		return franDetail;
	}
	public void setFranDetail(String franDetail) {
		this.franDetail = franDetail;
	}
	private String franDetail;
}