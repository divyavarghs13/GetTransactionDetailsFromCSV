/**
 * 
 */
package com.example.mytask.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.h2.message.DbException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.example.mytask.model.Batch;
import com.example.mytask.model.Transaction;
import com.example.mytask.model.TransactionDescription;
import com.example.mytask.model.TransactionVO;
import com.example.mytask.model.CSVFileModel;
import com.example.mytask.service.CSVProcessor;
import com.example.mytask.dao.TaskDAO;

/**
 * @author Divya
 *
 */
@Repository
public class TaskDAOImpl implements TaskDAO {
	
	@Autowired
	JdbcTemplate jdbcTemplate;	

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	/* (non-Javadoc)
	 * @see com.example.mytask.dao.TaskDAO#insertTask(com.example.mytask.model.Transaction)
	 */
	
	@Override
	public int insertTask(Transaction transaction) {
		final String sql =getinsertTaskSQL();
		//logger.info(" :: insert sql {}", sql);
		final KeyHolder k = new GeneratedKeyHolder();
		try {
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);					
					ps.setInt(1, transaction.getTransactionID());
					ps.setDate(2, transaction.getTransactionDate());
					ps.setLong(3, transaction.getAmount());
					ps.setTimestamp(4, transaction.getCreationDate());
					ps.setInt(5, transaction.getTransactiondescriptionPK());
					ps.setInt(6, transaction.getBatchPK());
					return ps;
				}
			}, k);
//System.out.println("postvalues sql="+sql);
		} catch (Exception ex) {
			logger.info(" error while inserting transaction {}", ex.getMessage());
			//throw DataBaseException(" Creating entity failed. See my logs for more detials ");
		}
		int pk=Integer.parseInt(k.getKeys().get("TRANSACTIONPK").toString());				
		return pk;
	}

	/* (non-Javadoc)
	 * @see com.example.mytask.dao.TaskDAO#getAllTask()
	 */
	@Override
	public List<TransactionVO> getAllTask() {
		final String sql =getAllTaskSQL();
		List<TransactionVO> result = new ArrayList<>();
		
		logger.info(" :: select sql {}", sql);		
		try {
					List<TransactionVO> transactionvo  = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TransactionVO.class));		
					return transactionvo;										
		} catch (Exception ex) {
			logger.info(" error while getting transaction {}", ex.getMessage());
		}
		return null;
	}

	/* (non-Javadoc)
	 * @see com.example.mytask.dao.TaskDAO#insertTransDescription(com.example.mytask.model.TransactionDescription)
	 */
	@Override
	public int insertTransDescription(TransactionDescription transactionDescription) {
		
		final String sql =geInsertTransDescriptSQL();
		//logger.info(" :: insert sql {}", sql);
		final KeyHolder k = new GeneratedKeyHolder();
		try {
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);			
					ps.setString(1, transactionDescription.getDescription());
					ps.setTimestamp(2, transactionDescription.getCreationDate());
					ps.setInt(3, transactionDescription.getBatchPK());
					return ps;
				}
			}, k);

//System.out.println("postvalues sql="+sql);
		} catch (Exception ex) {
			logger.info(" error while inserting transaction {}", ex.getMessage());
			//throw DataBaseException(" Creating entity failed. See my logs for more detials ");
		}
		int pk=Integer.parseInt(k.getKeys().get("transactiondescriptionPK").toString());		
		
		return pk;
	}


	/* (non-Javadoc)
	 * @see com.example.mytask.dao.TaskDAO#insertBatch(com.example.mytask.model.Batch)
	 */
		
	@Override
	public int insertBatch(Batch tobatchModel) {	
		final String sql =getInsertBatchSQL();
		//logger.info(" :: insert sql {}", sql);
		final KeyHolder k = new GeneratedKeyHolder();
		
		try {
			jdbcTemplate.update(new PreparedStatementCreator() {
				@Override
				public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
					PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);							
					ps.setString(1, tobatchModel.getFileName());					
					ps.setInt(2, tobatchModel.getTotalNumberOfRows());
					ps.setInt(3,tobatchModel.getNumberOfNewTrans());
					ps.setTimestamp(4, tobatchModel.getStartDate());
					ps.setTimestamp(5, tobatchModel.getEndDate());
					ps.setTimestamp(6, tobatchModel.getCreationDate());
					return ps;
				}
			}, k);
			//System.out.println("postvalues sql="+sql);
			
		} catch (Exception ex) {
			logger.info(" error while inserting transaction {}", ex.getMessage());
			//throw DataBaseException(" Creating entity failed. See my logs for more detials ");
		}
		int pk=Integer.parseInt(k.getKeys().get("batchpk").toString());		
		
		return pk;
	}
	
}
