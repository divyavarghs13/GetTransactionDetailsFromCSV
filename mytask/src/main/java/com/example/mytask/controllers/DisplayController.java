package com.example.mytask.controllers;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.mytask.model.TransactionVO;

@Controller
public class DisplayController {
	@RequestMapping(value = "/display")
	@Scheduled(fixedRate = 500)
	public String display() {
		return "welcome.html";
	}
}
