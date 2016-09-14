package edu.mum.cs.cs401.controller;
import edu.mum.cs.cs401.dataaccess.*;
import edu.mum.cs.cs401.entity.CheckoutRecord;
public class CheckoutRecordController {
	private static CheckoutRecordController instance = new CheckoutRecordController();
	private DataAccess<String, CheckoutRecord> dataaccess = new DataAccessImpl<String, CheckoutRecord>();
	private CheckoutRecordController() {}
	
	public static CheckoutRecordController getInstance() {
		return instance;
	}
	
	public CheckoutRecord addCheckoutRecord(CheckoutRecord record) {
		return dataaccess.add(record.getCurrentMemberId(), record);
	}
	
	public CheckoutRecord getCheckoutRecordByUserId(String userId) {
		return dataaccess.get(userId);
	}
}
