/**
 * 
 */
package com.example.mytask.dao;

import java.util.List;

import com.example.mytask.model.Batch;
import com.example.mytask.model.Transaction;
import com.example.mytask.model.TransactionDescription;
import com.example.mytask.model.TransactionVO;
import com.example.mytask.model.CSVFileModel;
import com.example.mytask.service.CSVProcessor;

/**
 * @author Divya
 *
 */
public interface TaskDAO {
		
public int insertTask(Transaction transaction);
public int insertTransDescription(TransactionDescription totransactionDescriptionmodel);
public int insertBatch(Batch tobatchModel);
public List<TransactionVO> getAllTask();


default String getinsertTaskSQL() {
return new StringBuilder().append(" insert into transaction ").append(" (transactionID, transactionDate, amount, creationDate, transactiondescriptionPK, batchPK)")
	.append(" values")
	.append(" (?,?,?,?,?,?) ").toString();
}

default String getAllTaskSQL() {
return new StringBuilder().append(
		"SELECT").append( 
				" transaction.transactionID, transaction.transactiondate, transaction.amount, transactiondescription.description,batch.startdate,batch.enddate,batch.filename")
		.append(" FROM transaction ")
		.append(" INNER JOIN").append(" transactiondescription ON transaction.transactiondescriptionpk=transactiondescription.transactiondescriptionpk")
		.append(" INNER JOIN").append(" Batch ON transactiondescription.batchpk = batch.batchpk")
		.toString();
}

default String geInsertTransDescriptSQL() {
return new StringBuilder().append(" insert into transactiondescription ").append(" (description, creationDate, batchPK)")
	.append(" values")
	.append(" (?,?,?) ").toString();
}

default String getInsertBatchSQL() {
return new StringBuilder().append(" insert into batch").append(" (fileName, totalNumberOfRows, numberOfNewTrans, startDate, endDate, creationDate)")
	.append(" values")
	.append(" (?,?,?,?,?,?) ").toString();
}

}