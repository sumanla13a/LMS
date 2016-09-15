package edu.mum.cs.cs401.controller;

import java.util.*;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.CheckoutEntryRecord;
import edu.mum.cs.cs401.entity.CheckoutRecord;

public class CheckoutController {
	private static CheckoutController instance = new CheckoutController();
	private CheckoutRecordController checkoutRecordController = CheckoutRecordController.getInstance();
	private CheckoutController() {}
	
	public static CheckoutController getInstance() {
		return instance;
	}
	public CheckoutEntryRecord addRecord(CheckoutEntryRecord entry){
		if(checkoutRecordController.getCheckoutRecordByUserId(entry.getCurrentMemberId()) != null) {
			checkoutRecordController.getCheckoutRecordByUserId(entry.getCurrentMemberId()).getCheckoutEntryList().add(entry);
		} else {
			CheckoutRecord checkoutRecord = new CheckoutRecord();
			checkoutRecord.setCurrentMemberId(entry.getCurrentMemberId());
			List<CheckoutEntryRecord> initialList = new ArrayList<CheckoutEntryRecord>();
			initialList.add(entry);
			checkoutRecord.setCheckoutEntryList(initialList);
			checkoutRecordController.addCheckoutRecord(checkoutRecord);
		}

		return entry;
	}

}
