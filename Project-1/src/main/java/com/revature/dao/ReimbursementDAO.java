package com.revature.dao;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import com.revature.beans.Reimbursement;

public interface ReimbursementDAO {

	public abstract void createReimbursement(int emp_id, int manager_id, double amount, String status, String reason,
			Blob image) throws SQLException;

	public abstract List<Reimbursement> getReimbursementList(int manager_id) throws SQLException;

	public abstract List<Reimbursement> viewMyReimbursements(int emp_id) throws SQLException;

	public abstract void changeReimbursementStatus(int reimbursement_id, String update) throws SQLException;

	public abstract List<Reimbursement> viewAllCompletedReimbursement() throws SQLException;

	public abstract List<Reimbursement> viewReimbursementsFor(int emp_id) throws SQLException;
}
