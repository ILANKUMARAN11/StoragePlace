package com.ilan.auto.deploy.service;

import java.io.File;

public class ReadResouce {
	
	
	private static ReadResouce single_instance = null; 
	private ClassLoader classLoader;
	
	private ReadResouce(){
		classLoader = getClass().getClassLoader();
	}
	
	
	public static ReadResouce getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new ReadResouce(); 
  
        return single_instance; 
    } 
	
	
	public String getFilePath(String fileRoot) {
		File file = new File(classLoader.getResource(fileRoot).getFile());
		return file.getPath();

	}

	public File getFile(String fileRoot) {
		File file = new File(classLoader.getResource(fileRoot).getFile());
		return file;
	}

}
