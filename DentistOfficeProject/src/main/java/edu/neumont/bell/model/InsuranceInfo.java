package edu.neumont.bell.model;

public class InsuranceInfo {

	private String companyName;
	private String groupId;
	private String memberID;
	
	public InsuranceInfo() {}
	
	public InsuranceInfo(String name, String groupID2, String memberID2) {
		this.setCompanyName(name);
		this.setGroupId(groupID2);
		this.setMemberID(memberID2);
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getGroupId() {
		return groupId;
	}
	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}
	public String getMemberID() {
		return memberID;
	}
	public void setMemberID(String memberID) {
		this.memberID = memberID;
	}
}
