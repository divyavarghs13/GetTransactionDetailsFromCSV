package com.example.mytask.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.sql.Date;


import javax.persistence.Entity;
import javax.persistence.Table;

public class TransactionDescription implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5475741985729582733L;
	private int transactiondescriptionPK;
	private int transactiondescriptionNK;
	private String description;
	private Timestamp creationDate;
	private int batchPK;
	
	
	
	/**
	 * @param description
	 * @param creationDate
	 */
	public TransactionDescription(String description, Timestamp creationDate) {
		super();
		this.description = description;
		this.creationDate = creationDate;
	}
	
	public int getTransactiondescriptionPK() {
		return transactiondescriptionPK;
	}
	public void setTransactiondescriptionPK(int transactiondescriptionPK) {
		this.transactiondescriptionPK = transactiondescriptionPK;
	}
	public int getTransactiondescriptionNK() {
		return transactiondescriptionNK;
	}
	public void setTransactiondescriptionNK(int transactiondescriptionNK) {
		this.transactiondescriptionNK = transactiondescriptionNK;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	public int getBatchPK() {
		return batchPK;
	}
	public void setBatchPK(int batchPK) {
		this.batchPK = batchPK;
	}
	@Override
	public String toString() {
		return "TransactionDescription [transactiondescriptionPK=" + transactiondescriptionPK
				+ ", transactiondescriptionNK=" + transactiondescriptionNK + ", description=" + description
				+ ", creationDate=" + creationDate + ", batchPK=" + batchPK + "]";
	}
	
	
}
