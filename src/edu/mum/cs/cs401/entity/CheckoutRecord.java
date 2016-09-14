package edu.mum.cs.cs401.entity;
import java.util.List;
public class CheckoutRecord {
	private List<CheckoutEntryRecord> checkoutEntryList;
	private String currentMemberId;
	public void add(CheckoutEntryRecord record) {
		checkoutEntryList.add(record);
	}
	public List<CheckoutEntryRecord> getCheckoutEntryList() {
		return checkoutEntryList;
	}
	public void setCheckoutEntryList(List<CheckoutEntryRecord> checkoutEntryList) {
		this.checkoutEntryList = checkoutEntryList;
	}
	public String getCurrentMemberId() {
		return currentMemberId;
	}
	public void setCurrentMemberId(String currentMemberId) {
		this.currentMemberId = currentMemberId;
	}
	@Override
	public String toString() {
		return "CheckoutRecord [checkoutEntryList=" + checkoutEntryList + ", currentMemberId=" + currentMemberId + "]";
	}
}
