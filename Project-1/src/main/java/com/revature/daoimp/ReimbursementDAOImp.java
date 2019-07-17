package com.revature.daoimp;

import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.beans.Reimbursement;
import com.revature.connections.ConnFactory;
import com.revature.dao.ReimbursementDAO;

public class ReimbursementDAOImp implements ReimbursementDAO {

	public static ConnFactory cf = ConnFactory.getInstance();
	public static ReimbursementDAOImp rdao = new ReimbursementDAOImp();

	@Override
	public List<Reimbursement> getReimbursementList(int manager_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE MANAGER_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, manager_id);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		List<Reimbursement> reimburseList = new ArrayList<>();
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5),
					rs.getString(6), rs.getBlob(7));
			reimburseList.add(r);
		}
		return reimburseList;
	}

	@Override
	public List<Reimbursement> viewMyReimbursements(int emp_id) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE EMP_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp_id);
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		List<Reimbursement> reimburseList = new ArrayList<>();
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5),
					rs.getString(6), rs.getBlob(7));
			reimburseList.add(r);
		}
		return reimburseList;
	}

	@Override
	public void changeReimbursementStatus(int reimbursement_id, String update) throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "UPDATE REIMBURSEMENTS SET REIMBURSEMENT_STS = ? WHERE REIMBURSEMENT_ID = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, update);
		ps.setInt(2, reimbursement_id);
		ps.executeUpdate();

	}

	@Override
	public List<Reimbursement> viewAllCompletedReimbursement() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM REIMBURSEMENTS WHERE REIMBURSEMENT_STS = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "PAID");
		ResultSet rs = ps.executeQuery();
		Reimbursement r = null;
		List<Reimbursement> reimburseList = new ArrayList<>();
		while (rs.next()) {
			r = new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getDouble(4), rs.getString(5),
					rs.getString(6), rs.getBlob(7));
			reimburseList.add(r);
		}
		return reimburseList;
	}

	@Override
	public List<Reimbursement> viewReimbursementsFor(int emp_id) throws SQLException {
		return viewMyReimbursements(emp_id);
	}

	@Override
	public void createReimbursement(int emp_id, int manager_id, double amount, String status, String reason, Blob image)
			throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "INSERT INTO REIMBURSEMENTS VALUES(SQ_REIMBURSEMENT_ID.NEXTVAL, ?, ?, ?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, emp_id);
		ps.setInt(2, manager_id);
		ps.setDouble(3, amount);
		ps.setString(4, status);
		ps.setString(5, reason);
		ps.setBlob(6, image);
		ps.executeUpdate();
	}

}

