package edu.mum.cs.cs401.controller;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;
import edu.mum.cs.cs401.entity.CheckoutEntryRecord;
import edu.mum.cs.cs401.entity.Member;

public class CheckoutController {
	private static CheckoutController instance = new CheckoutController();
	private DataAccess<String, CheckoutEntryRecord> dataAccess = new DataAccessImpl<String, CheckoutEntryRecord>();
	private CheckoutController() {
		
	}
	
	public static CheckoutController getInstance() {
		return instance;
	}

}
