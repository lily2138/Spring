package park.vo;

public class UseList {
	private int useNo;
	private int custNo;
	private int attrNo;
	private String useDate;
	private int status;
	
	public UseList(int useNo, int custNo, int attrNo, String useDate, int status) {
		super();
		this.useNo = useNo;
		this.custNo = custNo;
		this.attrNo = attrNo;
		this.useDate = useDate;
		this.status = status;
	}
	
	public int getUseNo() {
		return useNo;
	}
	public void setUseNo(int useNo) {
		this.useNo = useNo;
	}
	public int getCustNo() {
		return custNo;
	}
	public void setCustNo(int custNo) {
		this.custNo = custNo;
	}
	public int getAttrNo() {
		return attrNo;
	}
	public void setAttrNo(int attrNo) {
		this.attrNo = attrNo;
	}
	public String getUseDate() {
		return useDate;
	}
	public void setUseDate(String useDate) {
		this.useDate = useDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UseList [useNo=" + useNo + ", custNo=" + custNo + ", attrNo=" + attrNo + ", useDate=" + useDate
				+ ", status=" + status + "]";
	}

	
}
