package com.example.mytask.model;

import java.io.Serializable;
import java.sql.Date;

public class TransactionVO implements Serializable{
	
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int transactionID;
private Date transactionDate;
private long amount;
private String description;
private Date startDate;
private Date endDate;
private String fileName;
public int getTransactionID() {
	return transactionID;
}
public void setTransactionID(int transactionID) {
	this.transactionID = transactionID;
}
public Date getTransactionDate() {
	return transactionDate;
}
public void setTransactionDate(Date transactionDate) {
	this.transactionDate = transactionDate;
}
public long getAmount() {
	return amount;
}
public void setAmount(long amount) {
	this.amount = amount;
}
public String getDescription() {
	return description;
}
public void setDescription(String description) {
	this.description = description;
}
public Date getStartDate() {
	return startDate;
}
public void setStartDate(Date startDate) {
	this.startDate = startDate;
}
public Date getEndDate() {
	return endDate;
}
public void setEndDate(Date endDate) {
	this.endDate = endDate;
}
public String getFileName() {
	return fileName;
}
public void setFileName(String fileName) {
	this.fileName = fileName;
}

}
