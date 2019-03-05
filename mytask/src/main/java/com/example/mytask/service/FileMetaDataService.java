package com.example.mytask.service;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FileMetaDataService {

	/** To get the current Time **/
	public Timestamp getCurrentTime()
    {      
		java.sql.Timestamp t = null;
       try{             	
    	   t=new Timestamp(System.currentTimeMillis());
    	   //System.out.println("formatted Time="+t);
       }
       catch(Exception e){ 
        e.printStackTrace(); 
       }
       return t; 
   }
	/** To get the file created time Time **/
	public Timestamp getCreationTime(File file)
	    {
		java.sql.Timestamp timeStampDate=null;
	       try{         
	        Path p = Paths.get(file.getAbsolutePath());
	        BasicFileAttributes view
	           = Files.getFileAttributeView(p, BasicFileAttributeView.class)
	                  .readAttributes();
	        FileTime fileTime=view.creationTime();	        	        
	       // convert to data type Timestamp
	         timeStampDate = new Timestamp(fileTime.toMillis());
	        
	        return (timeStampDate);
	       }
	       catch(IOException e){ 
	        e.printStackTrace(); 
	       }
	       return timeStampDate; 
	   }
	
	/** To get the filename of the csv file by passing the directory **/
	public String findcsvFile(String directory) {
		  List<String> csvFiles = new ArrayList<String>();	
		  String csvName =null;
		  File dir = new File(directory);
		  for (File file : dir.listFiles()) {
		    if (file.getName().endsWith((".csv"))) {
		    	csvFiles.add(file.getName());
		    }
		  
		  }
		  if(csvFiles.isEmpty()) {			  
			  csvFiles=null;
			  System.out.println("No more files to Process");
		  }
		  else {
			  csvName=csvFiles.get(0).toString();
		  }
		  return csvName;
		}
	
	/** Move the file from current folder to Processed folder **/
    public void moveFileToProcessed(String fileName)
    {	
    	try{
    		String directory = "C:\\processing\\";
    	   File currentfile =new File(directory+fileName);
    	  // System.out.println("Current"+currentfile);
    	   if(currentfile.renameTo(new File(directory +"history\\"+ currentfile.getName()))){
    		System.out.println("File is moved successful!");
    	   }else{
    		System.out.println("File is failed to move!");
    	   }
    	    
    	}catch(Exception e){
    		e.printStackTrace();
    	}
    }
}

