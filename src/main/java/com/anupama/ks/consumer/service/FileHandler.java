package com.anupama.ks.consumer.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * Due to time concern instead of implementing kafka pipeline structure, data is
 * reading and writing from file.
 * 
 * I have been implemented the code for single data point
 * 
 * TO DO: Implement kafka pipline
 * @author akhangar
 *
 */

public class FileHandler {

	Logger logger = Logger.getLogger(FileHandler.class.getName());
	String registerMac = "00:0a:95:9d:68:16";

	public void writeData(String dataPoint) {
		String filePath = createFile();

		try{    
			FileWriter fw =new FileWriter(filePath);    
			fw.write(dataPoint);
			fw.close();    
		}catch(Exception e){
			System.out.println(e);
		}    
		logger.info("Data written successfully");   
	} 


	public boolean isAuthentic(String macAddress) {
		boolean auth = false;
		if(registerMac.equals(macAddress))
			auth =  true;
		return auth;
	}
	
	private String createFile() {
		String folderPath = "/var/" +  File.separator + "dataPoint";
		File theDir = new File(folderPath);
		String filePath =  "/var/" +  File.separator + "dataPoint" + File.separator + "geoPoints.txt";
		File file = new File(filePath);

		if (!theDir.exists()) {
			logger.info("creating directory: " + theDir.getName());
			boolean result = false;

			try {
				theDir.mkdirs();
				result = true;
			} catch (SecurityException se) {
				logger.info(se.getMessage());
			}
			if (result) {
				logger.info("Folder created");
			}
		} else if (theDir.exists()) {
			logger.info("Folder exist");
		}

		try {
			if (file.createNewFile())
			{
				logger.info("File is created!");
			} else {
				logger.info("File already exists.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filePath;
	}

}
