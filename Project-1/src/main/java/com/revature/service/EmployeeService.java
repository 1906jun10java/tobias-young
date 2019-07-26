package com.revature.service;

import java.sql.SQLException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.dao.EmployeeDAO;
import com.revature.daoimp.EmployeeDAOImp;

public class EmployeeService {

	public String employeeListString() {
		EmployeeDAO edao = new EmployeeDAOImp();
		ObjectMapper om = new ObjectMapper();
		String jsonString = "";
		try {
			jsonString = om.writeValueAsString(edao.getEmployeeList());
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


