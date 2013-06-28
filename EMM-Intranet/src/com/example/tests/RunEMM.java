package com.example.tests;

import java.io.File;
import org.openqa.selenium.firefox.internal.FileExtension;

import com.google.common.io.Files;

public class RunEMM {

	/**
	 * @param args
	 */
	/*public static void listFilesForFolder(final File folder) {
		for (final File fileEntry : folder.listFiles()) {
	        if (fileEntry.isDirectory()) {
	            listFilesForFolder(fileEntry);
	        } else {
	            System.out.println(fileEntry.getName());
	        }
	    }
	}*/
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		kalangosSelenium kalangos = new kalangosSelenium();
		
		File folder = new File("E:\\EMM_Projects\\Release_Works\\Test_documents\\Release7.2\\Messages2");
		//Files.getFileExtension("E:\\EMM_Projects\\Release_Works\\Test_documents\\Release7.2\\Messages2");
		//listFilesForFolder(folder);
		int i=0;
		String booleanValue="true";
		String WSDL = "http://192.168.1.6:7800/EasyMedAPI/ws/labResultNotification?wsdl";
		for (final File fileEntry : folder.listFiles()) {
	        
			if (fileEntry.isDirectory()) {
	        	System.out.println(fileEntry);
	        } else {
	        	if(Files.getFileExtension(fileEntry.getAbsoluteFile().getAbsolutePath()).equals("hl7")){
	        		if((i % 2) == 0){
	  				  booleanValue="true";
	  			  	}else{
	  				  booleanValue="false";
	  			  	}
	        		System.out.println(i+" Started===========> "+fileEntry.getAbsolutePath()+"\n");
	        		try{
	        			kalangos.setUp();
	        			kalangos.testkalangosSelenium(fileEntry.getAbsolutePath(),booleanValue,WSDL);
	        			kalangos.tearDown();
	        			System.out.println(i+" Finished===========> "+fileEntry.getAbsolutePath()+"\n");
	        			i=i+1;
	        		}catch (Exception e){
	        			e.printStackTrace();
	        		}
	        	}
	        }
	    }

		
		
		/*SignInPage sip = new SignInPage();
		try{
			sip.setUp();
			sip.testSignInPage();
			sip.tearDown();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		SignInPageFR sipFR = new SignInPageFR();
		try{
			sipFR.setUp();
			sipFR.testSignInPage();
			sipFR.tearDown();
		}catch (Exception e){
			e.printStackTrace();
		}
		
		SignInPageDE sipDE = new SignInPageDE();
		try{
			sipDE.setUp();
			sipDE.testSignInPage();
			sipDE.tearDown();
		}catch (Exception e){
			e.printStackTrace();
		}*/	
	}

}
