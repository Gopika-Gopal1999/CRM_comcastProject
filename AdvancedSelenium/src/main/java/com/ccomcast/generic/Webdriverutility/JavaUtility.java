package com.ccomcast.generic.Webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	public int getrandomNumber()
	{
		Random rand=new Random();
		int randomnumber = rand.nextInt(5000);
		return randomnumber;
	}
	
	public String getSystemDateYYDDMM()
	{
		Date dateobj=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat();
		String date = sdf.format(dateobj);
		return date;
		
	}
	public String getRequiredDateYYDDMM(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("YYYY-MM-dd");
		Calendar cal=sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH,days);
		String reqDate = sim.format(cal.getTime());
		return reqDate;
	}

	
	

}
