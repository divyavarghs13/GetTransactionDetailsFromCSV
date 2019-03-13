package com.example.mytask.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.mytask.model.CSVFileModel;
import com.example.mytask.model.TransactionVO;
import com.example.mytask.service.CSVProcessor;

@RestController
public class WelcomeController {

	@Autowired
	CSVProcessor readService;

	@CrossOrigin
	@RequestMapping(value = "/read")
	@Scheduled(fixedRate = 5000)
	public String readFile() {
		// Read Data from csv file
		List<CSVFileModel> csvmodel = readService.tocsvFileModel();

		if (csvmodel != null && !csvmodel.isEmpty()) {
			// Insert values to db
			readService.executeCSVProcessor();
			
			// Move the folder to Processed
			readService.moveFileFolder();			
			return "File is inserted to database";
			
		} else {
			return "No more new files";
		}

	}
	@CrossOrigin
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	public List<TransactionVO> displayFile() {
			// Display fields from db
			List<TransactionVO> list=readService.displayCSVProcessor();						
			return list;		
	}


}
