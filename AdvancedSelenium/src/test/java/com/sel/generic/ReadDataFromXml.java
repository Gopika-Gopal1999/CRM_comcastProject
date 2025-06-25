package com.sel.generic;

import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public class ReadDataFromXml {
    @Test
    public void Seleniun(XmlTest test)
    {
    	System.out.println(test.getParameter("Browser"));
    	System.out.println(test.getParameter("Url"));
    	System.out.println(test.getParameter("Username"));
    	System.out.println(test.getParameter("Password"));
    }
    
}
