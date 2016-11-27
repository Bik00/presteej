package presteej.bean;

import java.sql.Timestamp;

public class IdeaDataBean {

			private int ideaId;
			private String ideaName;
			private int ideaPrice;
			private String ideaImgUrl;
			private int ideaRegNo;
			private Timestamp ideaStartDate;
			private Timestamp ideaEndDate;
			private String ideaDetail;

			public int getIdeaId() {
				return ideaId;
			}
			public void setIdeaId(int ideaId) {
				this.ideaId = ideaId;
			}
			public String getIdeaName() {
				return ideaName;
			}
			public void setIdeaName(String ideaName) {
				this.ideaName = ideaName;
			}
			public int getIdeaPrice() {
				return ideaPrice;
			}
			public void setIdeaPrice(int ideaPrice) {
				this.ideaPrice = ideaPrice;
			}
			public String getIdeaImgUrl() {
				return ideaImgUrl;
			}
			public void setIdeaImgUrl(String ideaImgUrl) {
				this.ideaImgUrl = ideaImgUrl;
			}
			public int getIdeaRegNo() {
				return ideaRegNo;
			}
			public void setIdeaRegNo(int ideaRegNo) {
				this.ideaRegNo = ideaRegNo;
			}
			public Timestamp getIdeaStartDate() {
				return ideaStartDate;
			}
			public void setIdeaStartDate(Timestamp ideaStartDate) {
				this.ideaStartDate = ideaStartDate;
			}
			public Timestamp getIdeaEndDate() {
				return ideaEndDate;
			}
			public void setIdeaEndDate(Timestamp ideaEndDate) {
				this.ideaEndDate = ideaEndDate;
			}
			public String getIdeaDetail() {
				return ideaDetail;
			}
			public void setIdeaDetail(String ideaDetail) {
				this.ideaDetail = ideaDetail;
			}			
}