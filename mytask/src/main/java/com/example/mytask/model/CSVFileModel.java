package com.example.mytask.model;
import java.sql.Date;

public class CSVFileModel {
	
	private int rowIndex;
	private String ID;
	private java.util.Date date;
	private java.sql.Date transactiondate;
	private String description;
	private double amount;
	private int count;
	private int transactionID;
	private String fileName;
	
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * @return the transactiondate
	 */
	public Date getTransactiondate() {
		return transactiondate;
	}

	/**
	 * @param transactiondate the transactiondate to set
	 */
	public void setTransactiondate(Date transactiondate) {
		this.transactiondate = transactiondate;
	}

	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * @return the transactionID
	 */
	public int getTransactionID() {
		return transactionID;
	}

	/**
	 * @param transactionID the transactionID to set
	 */
	public void setTransactionID(int transactionID) {
		this.transactionID = transactionID;
	}

	/**
	 * @return the count
	 */
	public int getCount() {
		return count;
	}

	/**
	 * @param count the count to set
	 */
	public void setCount(int count) {
		this.count = count;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public int getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(int rowIndex) {
		this.rowIndex = rowIndex;
	}	

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "csvFileModel [rowIndex=" + rowIndex + ", ID=" + ID + ", dat=" + transactiondate + ", description=" + description
				+ ", amount=" + amount + "]";
	}

	public CSVFileModel(int rowIndex, Date transactiondate, String description, long amount, String fileName) {
		super();
		this.rowIndex = rowIndex;
		this.transactiondate=transactiondate;
		this.description = description;
		this.amount = amount;
		this.fileName=fileName;
	}

	public CSVFileModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
