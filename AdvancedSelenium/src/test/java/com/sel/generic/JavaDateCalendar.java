package com.sel.generic;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class JavaDateCalendar {

	public static void main(String[] args) {
      Date obj=new Date();
      SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
      String actDate = sim.format(obj);
      System.out.println(actDate);
      
      Calendar calender = sim.getCalendar();
      calender.add(Calendar.DAY_OF_MONTH, 30);
      String dateRequried = sim.format(calender.getTime());
      System.out.println(dateRequried);
	}

}
