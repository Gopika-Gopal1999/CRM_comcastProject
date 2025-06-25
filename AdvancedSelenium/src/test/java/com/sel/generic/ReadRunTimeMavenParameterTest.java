package com.sel.generic;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest {
 @Test
 public void rumTimeParameterTest()
 {
	 String url=System.getProperty("url");
	 String Browser=System.getProperty("browser");
	 String username=System.getProperty("username");
	 String password=System.getProperty("password");
	 System.out.println("Env="+url);
	 System.out.println("Browser="+Browser);
	 System.out.println("username="+username);
	 System.out.println("password="+password);
 }
}
