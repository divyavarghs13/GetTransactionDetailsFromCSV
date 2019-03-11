package com.example.mytask.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.mytask.model.CSVFileModel;
import com.example.mytask.model.TransactionVO;
import com.example.mytask.service.CSVProcessor;

@RestController
public class WelcomeController {

	@Autowired
	CSVProcessor readService;
	@Scheduled(fixedRate = 500)
	@CrossOrigin
	@RequestMapping(value = "/welcome", method = RequestMethod.GET, produces = "application/json")
	 @ResponseBody
	public List<TransactionVO> readFile() {
		// Read Data from csv file
		List<CSVFileModel> csvmodel = readService.tocsvFileModel();

		if (csvmodel != null && !csvmodel.isEmpty()) {
			// Insert values to db
			readService.executeCSVProcessor();
			// Move the folder to Processed
			readService.moveFileFolder();
			// Display fields from db
			return readService.displayCSVProcessor();
			
		} else {
			return null;
		}

	}

}
