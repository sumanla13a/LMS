package edu.mum.cs.cs401.controller;

import edu.mum.cs.cs401.dataaccess.DataAccess;
import edu.mum.cs.cs401.dataaccess.DataAccessImpl;

public class LoginController {
	private DataAccess<String, String> logInfoAccess = new DataAccessImpl<String, String>();

		public String addLoginInfo(String id, String password) {
			return logInfoAccess.add(password, id);
		}
		
		public String getLoginInfoPasswordById(String id) {
			return logInfoAccess.get(id);
		}
		
		public Boolean isUserLoginedById(String id) {
			return !(logInfoAccess.get(id) == null );
		}
		
		public Boolean checkPasswordById(String password, String id) {
			String localPass = logInfoAccess.get(id);
			if (localPass.equals(password)) {
				return true;
			}
			
			return false;
		}
}
