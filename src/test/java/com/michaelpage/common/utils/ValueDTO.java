package com.michaelpage.common.utils;

import java.io.File;
import jxl.Sheet;
import jxl.Workbook;

public class ValueDTO {

	private String URl;
	private String username;
	private String password;
	private String client;
	private String chromedriverpath;
	private String geckodriver;
	private String Iepath;
	private String email;
	private String firefoxprofilepath;
	private String chromeprofilepath;
	private String webDriverObj;
	private String languageSelection;

	public String getLanguageSelection() {
		return languageSelection;
	}

	public void setLanguageSelection(String languageSelection) {
		this.languageSelection = languageSelection;
	}

	public String getWebDriverObj() {
		return webDriverObj;
	}

	public void setWebDriverObj(String webDriverObj) {
		this.webDriverObj = webDriverObj;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getChromedriverpath() {
		return chromedriverpath;
	}

	public void setChromedriverpath(String chromedriverpath) {
		this.chromedriverpath = chromedriverpath;
	}

	public String getGeckodriverpath() {
		return geckodriver;
	}

	public void setGeckodriverpath(String geckodriver) {
		this.geckodriver = geckodriver;
	}

	public String getIepath() {
		return Iepath;
	}

	public void setIepath(String Iepath) {
		this.Iepath = Iepath;
	}

	public String getFirefoxProfilePath() {
		return firefoxprofilepath;
	}

	public void setFirefoxProfilePath(String firefoxprofilepath) {
		this.firefoxprofilepath = firefoxprofilepath;
	}

	public String getChromeProfilePath() {
		return chromeprofilepath;
	}

	public void setChromeProfilePath(String chromeprofilepath) {
		this.chromeprofilepath = chromeprofilepath;
	}

	public String getURl() {
		return URl;
	}

	public void setURl(String uRl) {
		URl = uRl;
	}

	public String getClient() {
		return client;
	}

	public void setClient(String client) {
		this.client = client;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public ValueDTO() {
		try {
			Workbook wb;
			File file = new File("./src/test/resources/TestDataFiles/Test Data.xls");
			Sheet sh, sh1;
			wb = Workbook.getWorkbook(file);
			sh = wb.getSheet("Input Sheet");
			sh1 = wb.getSheet("Tech Config");

			this.URl = sh.getCell(0, 2).getContents();
			this.username = sh.getCell(1, 2).getContents();
			this.password = sh.getCell(2, 2).getContents();
			this.webDriverObj = sh.getCell(3, 2).getContents();
			this.email = sh.getCell(4, 2).getContents();
			this.languageSelection = sh.getCell(5, 2).getContents();

			this.chromedriverpath = sh1.getCell(0, 1).getContents();
			this.firefoxprofilepath = sh1.getCell(1, 1).getContents();
			this.geckodriver = sh1.getCell(1, 2).getContents();
			this.chromeprofilepath = sh1.getCell(2, 1).getContents();
			this.Iepath = sh1.getCell(3, 1).getContents();


			/*
			 * System.out.println(sh.getCell(0, 2).getContents().toString());
			 * System.out.println(sh.getCell(3, 2).getContents().toString());
			 * System.out.println(sh.getCell(5, 2).getContents().toString());
			 */


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
