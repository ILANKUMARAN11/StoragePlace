package com.ilan.auto.deploy.service;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RootPath {
	
	String rootPath;
	private static RootPath single_instance = null; 
	
	private RootPath(){
		Path currentRelativePath = Paths.get("");
    	this.rootPath = currentRelativePath.toAbsolutePath().toString();
	}
	
	
	public static RootPath getInstance() 
    { 
        if (single_instance == null) 
            single_instance = new RootPath(); 
  
        return single_instance; 
    } 
	
	
	public String getRootPath() {
		return rootPath;

	}
	
	public String getFilePath(String fileRoot) {
		return rootPath+"/"+fileRoot;

	}

	public File getFile(String fileRoot) {
		File file = new File(rootPath+"/"+fileRoot);
		return file;
	}

}
