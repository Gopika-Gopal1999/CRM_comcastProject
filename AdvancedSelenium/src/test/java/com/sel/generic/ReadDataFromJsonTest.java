package com.sel.generic;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJsonTest {

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
     JSONParser parser=new JSONParser();
     Object obj = parser.parse(new FileReader("C:\\Users\\LENOVO\\TekPyramid\\AdvancedSelenium\\data\\JsonData.JSON"));
     JSONObject map=(JSONObject)obj;
     System.out.println(map.get("Url"));
     System.out.println(map.get("Browser"));
     System.out.println(map.get("Username"));
     System.out.println(map.get("Password"));
     System.out.println(map.get("TimeOuts"));
	}
}
