package DateActivity;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.TimeUnit;


public class DateClass {
	
	private Calendar theDay = new GregorianCalendar();
	private HashMap<String, String> histRecords = new HashMap<String, String>();
	private Random random = new Random();
	private String[] weather = {"sunny", "rainy","cloudy","snow", "windy"};
	private int[] temperature = {78, 98, 65, 32, 45};
	private final int RANDOM_LIMIT = 5;
	private SimpleDateFormat simpleFormatter = new SimpleDateFormat("EEEE");
	private Date today = new Date();
	
	public String getDateAnswer(int year, int mon, int day){
		int month = mon - 1;
		String strReturn = "";
		String strDate = String.format("%02d%02d%04d", month, day, year);
		
		if (isDateExist(strDate)){
			strReturn = histRecords.get(strDate);
		}else{
			theDay.set(year, month, day);
			Date date = (Date) theDay.getTime();
			String weekOfDay = simpleFormatter.format(date);
			long diff = getDifferenceDays(today, date);
			
			String wea = weather[random.nextInt(RANDOM_LIMIT)];
			int tem = temperature[random.nextInt(RANDOM_LIMIT)];
			
			String answer = String.format("That was a %s. It was a %s day and the temperature averaged %d degrees. It was %d days ago.", weekOfDay, wea, tem, diff);
			strReturn = answer;
			histRecords.put(strDate, answer);
		}
		
		return strReturn;
	}
	
	private boolean isDateExist(String strDate){
		if(histRecords.containsKey(strDate)){
			return true;
		}else{
			return false;
		}
		
	}
	
	private long getDifferenceDays(Date d1, Date d2) {
	    long diff = d1.getTime() - d2.getTime();
	    return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}

}
