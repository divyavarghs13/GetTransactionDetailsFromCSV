package com.example.mytask.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.supercsv.cellprocessor.ParseDate;
import org.supercsv.cellprocessor.ParseDouble;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

import com.example.mytask.dao.TaskDAO;
import com.example.mytask.model.Batch;
import com.example.mytask.model.CSVFileModel;
import com.example.mytask.model.Transaction;
import com.example.mytask.model.TransactionDescription;
import com.example.mytask.model.TransactionVO;

@Service
public class CSVProcessor {

	@Autowired
	TaskDAO taskDAOImpl;

	@Autowired
	FileMetaDataService fmdso;

	int count = 0;
	String directory = "D:/processing/";

	public boolean executeCSVProcessor() {

		List<CSVFileModel> tocsvFileModel = tocsvFileModel();
		if ((tocsvFileModel.isEmpty())) {
			return false;
		} else {

			for (CSVFileModel csv : tocsvFileModel) {
				Batch batchModel = getBatchModel(csv);
				int batchPk = taskDAOImpl.insertBatch(batchModel);

				TransactionDescription transactiondescriptionmodel = getTransactionDescriptionModel(csv);
				transactiondescriptionmodel.setBatchPK(batchPk);
				int transactiondescriptionPK = taskDAOImpl.insertTransDescription(transactiondescriptionmodel);

				Transaction transactionModel = getTransactionModel(csv);
				transactionModel.setTransactiondescriptionPK(transactiondescriptionPK);
				transactionModel.setBatchPK(batchPk);
				int transactionPk = taskDAOImpl.insertTask(transactionModel);
			}
			return true;
		}
	}

	public void moveFileFolder() {
		String myfileName = fmdso.findcsvFile(directory);
		fmdso.moveFileToProcessed(myfileName);
	}

	public List<TransactionVO> displayCSVProcessor() {
		List<TransactionVO> transactionlist = taskDAOImpl.getAllTask();
		//List<String> getrecord = new ArrayList<String>();
		for (TransactionVO list : transactionlist) {
			String record = (list.getTransactionID() + "    " + list.getTransactionDate() + "    " + list.getAmount()
					+ "    " + list.getDescription() + "              " + list.getStartDate() + "    "
					+ list.getEndDate() + "    " + list.getFileName()).toString();
			//getrecord.add(record);

			System.out.println(record);
			
		}
		return transactionlist;
	}

	public Batch getBatchModel(CSVFileModel csvBean) {
		return new Batch(csvBean.getFileName(), csvBean.getCount(), csvBean.getCount(),
				fmdso.getCreationTime(new File(csvBean.getFileName())), fmdso.getCurrentTime(), fmdso.getCurrentTime());
	}

	public TransactionDescription getTransactionDescriptionModel(CSVFileModel csvBean) {
		return new TransactionDescription(csvBean.getDescription(), fmdso.getCurrentTime());
	}

	public Transaction getTransactionModel(CSVFileModel csvBean) {
		return new Transaction(csvBean.getTransactionID(), csvBean.getTransactiondate(), csvBean.getAmount(),
				fmdso.getCurrentTime());
	}

	public List<CSVFileModel> tocsvFileModel() {

		String myFileName = fmdso.findcsvFile(directory);
		final String csvFileName = directory + myFileName;
		// System.out.println("final name"+csvFileName);
		CSVFileModel csvBean = null;
		ICsvBeanReader beanReader = null;
		List<CSVFileModel> CSVFileModeList = new ArrayList<CSVFileModel>();
		
		 if(myFileName != null && !myFileName.isEmpty()) {
			
		CellProcessor[] processors = new CellProcessor[] { new NotNull(), // ID
					new ParseDate("MM/dd/yyyy"), // date
					new NotNull(), // description
					new ParseDouble() // Amount
			};
			try {
				beanReader = new CsvBeanReader(new FileReader(csvFileName), CsvPreference.STANDARD_PREFERENCE);
				String[] header = beanReader.getHeader(true);

				while ((csvBean = beanReader.read(CSVFileModel.class, header, processors)) != null) {
					count++;
					// System.out.printf("%s %tD %-30s %-30s ", csvBean.getID(), csvBean.getDate(),
					// csvBean.getDescription(),
					// csvBean.getAmount());
					csvBean.setTransactionID((Integer.parseInt(csvBean.getID())));
					csvBean.setFileName(csvFileName);
					csvBean.setTransactiondate(new java.sql.Date(csvBean.getDate().getTime()));
					csvBean.setCount(count);
					// System.out.println("IN"+csvBean.toString());
					CSVFileModeList.add(csvBean);
				}
				// System.out.println("TotalNumberOfRows in the excel=" +
				// CSVFileModeList.size());

			} catch (FileNotFoundException ex) {
				System.err.println("Could not find the CSV file: " + ex);
			} catch (IOException ex) {
				System.err.println("Error reading the CSV file: " + ex);
			} finally {
				if (beanReader != null) {
					try {
						beanReader.close();
					} catch (IOException ex) {
						System.err.println("Error closing the reader: " + ex);
					}
				}

			}
		}
		else {
			CSVFileModeList = null;
		} 
		return CSVFileModeList;
	}
}
