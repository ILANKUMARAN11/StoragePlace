package com.ilan.auto.deploy.service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperty {

	private RootPath rootPath;
	private ReadResouce readResouce;
	private static ReadProperty single_instance = null;

	ReadProperty() {
		this.rootPath = RootPath.getInstance();
		this.readResouce = ReadResouce.getInstance();
	}

	public static ReadProperty getInstance() {
		if (single_instance == null)
			single_instance = new ReadProperty();

		return single_instance;
	}

	public Properties getProp(String filename) {
		Properties prop = new Properties();
		InputStream input = null;
		try {
			input = new FileInputStream(rootPath.getFile(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			prop.load(input);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop;
	}

}
