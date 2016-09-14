package edu.mum.cs.cs401.entity;
import java.util.List;
public class CheckoutRecord {
	private List<CheckoutEntryRecord> checkoutEntryList;
	public void add(CheckoutEntryRecord record) {
		checkoutEntryList.add(record);
	}
}
