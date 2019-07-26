package com.revature.service;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.ReimbursementDAO;
import com.revature.daoimp.ReimbursementDAOImp;

public class MyReimbursementsService {

	static ObjectMapper om = new ObjectMapper();
	static ReimbursementDAO rdao = new ReimbursementDAOImp();
	
	public String getReimbursementsAsString(int employeeId) {
		String jsonString = "";
		try {
			jsonString = om.writeValueAsString(rdao.viewReimbursementsFor(employeeId));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	public String getManagedEmployeeReimbursements(int employeeId) {
		String jsonString = "";
		try {
			jsonString = om.writeValueAsString(rdao.getReimbursementList(employeeId));
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
	
	public String getCompletedReimbursements() {
		String jsonString = "";
		try {
			jsonString = om.writeValueAsString(rdao.viewAllCompletedReimbursement());
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return jsonString;
	}
}