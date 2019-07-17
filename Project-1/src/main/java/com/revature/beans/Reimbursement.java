package com.revature.beans;

import java.sql.Blob;

public class Reimbursement {

	public Reimbursement(int reimbursementID, int emp_id, int manager_id, double reimbursementAmt,
			String status, String reason, Blob image) {
		super();
		this.reimbursementID = reimbursementID;
		this.emp_id = emp_id;
		this.manager_id = manager_id;
		this.reimbursementAmt = reimbursementAmt;
		this.status = status;
		this.reason = reason;
		this.image = image;
	}

	public Reimbursement() {
		super();
	}

	public Reimbursement(int reimbursementID, int emp_id, int manager_id, double reimbursementAmt,
			String status) {
		super();
		this.reimbursementID = reimbursementID;
		this.emp_id = emp_id;
		this.manager_id = manager_id;
		this.reimbursementAmt = reimbursementAmt;
		this.status = status;
	}

	private int reimbursementID;
	private int emp_id;
	private int manager_id;
	private double reimbursementAmt;
	private String status;
	private String reason;
	private Blob image;

	public int getReimbursementID() {
		return reimbursementID;
	}

	public void setReimbursementID(int reimbursementID) {
		this.reimbursementID = reimbursementID;
	}

	public int getEmp_id() {
		return emp_id;
	}

	public void setEmp_id(int emp_id) {
		this.emp_id = emp_id;
	}

	public int getManager_id() {
		return manager_id;
	}

	public void setManager_id(int manager_id) {
		this.manager_id = manager_id;
	}

	public double getReimbursementAmt() {
		return reimbursementAmt;
	}

	public void setReimbursementAmt(double reimbursementAmt) {
		this.reimbursementAmt = reimbursementAmt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Reimbursement [reimbursementID=" + reimbursementID + ", emp_id=" + emp_id + ", manager_id=" + manager_id
				+ ", reimbursementAmt=" + reimbursementAmt + ", status=" + status + ", reason=" + reason + ", image="
				+ image + "]";
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Blob getImage() {
		return image;
	}

	public void setImage(Blob image) {
		this.image = image;
	}
}

