package data;

import utilities.Xls_Reader;

public class DataXLS
{
	Xls_Reader data = new Xls_Reader("/Users/shyanigaurav/Desktop/QA Projects New/Testing/Files/shyani.xlsx");
	
	// Login Test
	
	public String wrongEmail = data.getCellData("Data4" , "wrongEmail" , 2);
	public String wrongPassword = data.getCellData("Data4" , "wrongPassword" , 2);
	public String emailWithSpecialChar = data.getCellData("Data4" , "emailWithSpecialChar" , 2);
	public String globalErr = data.getCellData("Data4" , "globalErr" , 2);
	public String emailWithSpecialCharErr = data.getCellData("Data4" , "emailWithSpecialCharErr" , 2);
	public String emptyEmailErr = data.getCellData("Data4" , "emptyEmailErr" , 2);
	public String emptyPassErr = data.getCellData("Data4" , "emptyPassErr" , 2);
	
	// Footer
	
	// Profile Test
	
	//Search Test
	
	//Add to Cart
}