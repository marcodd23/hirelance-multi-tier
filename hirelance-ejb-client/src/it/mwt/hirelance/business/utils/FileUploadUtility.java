package it.mwt.hirelance.business.utils;

import java.io.File;
import java.io.IOException;

public class FileUploadUtility {

	
	public static void deleteProfileFiles(File file) throws IOException{
		 
    	if(file.isDirectory()){
    		//System.out.println("Il file è una folder ");
    		if(file.list().length==0){
    			//System.out.println("vuota. La cancello");
    		   file.delete();
    		}
    		else{
	    		//System.out.println("Il file è una folder piena:");
        	   String files[] = file.list();
        	   for (String temp : files) {
   	    		//System.out.println("Cancello "+temp);
        	      //construct the file structure
        	      File fileDelete = new File(file, temp);
        	      //recursive delete
        	      deleteProfileFiles(fileDelete);
        	   }
        	   //check the directory again, if empty then delete it
        	   if(file.list().length==0){
           	     file.delete();
        	   }
    		}
 
    	}else{
    		//System.out.println("Il file è un file");
    		//if file, then delete it
    		file.delete();
    	}
    }
}
