package com.example.mytask.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.h2.mvstore.type.DataType;


public class Transaction implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4408726749444441077L;
	private int transactionPK;	
	private int transactionNK;
	private int transactionID;	
	private java.sql.Date transactionDate;
	private long amount;
	private int transactiondescriptionPK;
	private Timestamp creationDate;
	private int batchPK;
	/**
	 * @param transactionID
	 * @param date
	 * @param amount
	 * @param creationDate
	 */
	public Transaction(int transactionID, java.sql.Date transactiondate, double amount, Timestamp creationDate) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactiondate;
		this.amount = (long) amount;
		this.creationDate = creationDate;
	}
	
	

	/**
	 * @return the batchPK
	 */
	public int getBatchPK() {
		return batchPK;
	}

	/**
	 * @param batchPK the batchPK to set
	 */
	public void setBatchPK(int batchPK) {
		this.batchPK = batchPK;
	}

	public int getTransactionPK() {
		return transactionPK;
	}
	public void setTransactionPK(int transactionPK) {
		this.transactionPK = transactionPK;
	}
	public int getTransactionNK() {
		return transactionNK;
	}
	public void setTransactionNK(int transactionNK) {
		this.transactionNK = transactionNK;
	}
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
	public int getTransactiondescriptionPK() {
		return transactiondescriptionPK;
	}
	public void setTransactiondescriptionPK(int transactiondescriptionPK) {
		this.transactiondescriptionPK = transactiondescriptionPK;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Transaction [transactionPK=" + transactionPK + ", transactionNK=" + transactionNK + ", transactionID="
				+ transactionID + ", transactionDate=" + transactionDate + ", amount=" + amount
				+ ", transactiondescriptionPK=" + transactiondescriptionPK + ", creationDate=" + creationDate + "]";
	}



	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Transaction(int transactionID, Date transactionDate, long amount) {
		super();
		this.transactionID = transactionID;
		this.transactionDate = transactionDate;
		this.amount = amount;
	}





	
	
	
}
