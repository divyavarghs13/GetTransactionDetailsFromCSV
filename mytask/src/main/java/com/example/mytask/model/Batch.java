package com.example.mytask.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;

public class Batch implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int batchPK;
	private int batchNK;
	private String fileName;
	private int totalNumberOfRows;
	private int numberOfNewTrans;
	private Timestamp startDate;
	private Timestamp endDate;
	private Timestamp creationDate;
	
	
	

	public Batch() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Batch( String fileName, int totalNumberOfRows, int numberOfNewTrans,
			Timestamp startDate, Timestamp endDate, Timestamp creationDate) {
		super();
		this.batchPK = batchPK;
		this.batchNK = batchNK;
		this.fileName = fileName;
		this.totalNumberOfRows = totalNumberOfRows;
		this.numberOfNewTrans = numberOfNewTrans;
		this.startDate = startDate;
		this.endDate = endDate;
		this.creationDate = creationDate;
	}
	
	

	public int getBatchPK() {
		return batchPK;
	}
	
	public void setBatchPK(int batchPK) {
		this.batchPK = batchPK;
	}
	public int getBatchNK() {
		return batchNK;
	}
	public void setBatchNK(int batchNK) {
		this.batchNK = batchNK;
	}
	public String getFileName() {
		return fileName;
	}
	@Autowired
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public int getTotalNumberOfRows() {
		return totalNumberOfRows;
	}
	public void setTotalNumberOfRows(int totalNumberOfRows) {
		this.totalNumberOfRows = totalNumberOfRows;
	}
	public int getNumberOfNewTrans() {
		return numberOfNewTrans;
	}
	public void setNumberOfNewTrans(int numberOfNewTrans) {
		this.numberOfNewTrans = numberOfNewTrans;
	}
	public Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}
	public Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}
	public Timestamp getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Timestamp creationDate) {
		this.creationDate = creationDate;
	}
	@Override
	public String toString() {
		return "Batch [batchPK=" + batchPK + ", batchNK=" + batchNK + ", fileName=" + fileName + ", totalNumberOfRows="
				+ totalNumberOfRows + ", numberOfNewTrans=" + numberOfNewTrans + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", creationDate=" + creationDate + "]";
	}
	
}
