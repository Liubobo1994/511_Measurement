package Time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class Time1 extends JFrame {

    JTextField text;
    Date date2 = null;

    public Time1(JTextField text,Date date) {
    	this.text = text ;
    	this.date2 = date ;
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1000);
    }

    public String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date date1 = (Date) calendar.getTime();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date11 = sdf.format(date1);
        String date22 = sdf.format(date2);
        
        Date d1 = null ;
        Date d2 = null ;
		try {
			d1 = sdf.parse(date11);
			d2 = sdf.parse(date22);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	    long diff = (d1.getTime() - d2.getTime())/1000;
	    long hour = diff/(60*60); 
	    long minut = diff/60;
	    long second = diff - hour*60*60 - minut*60 ;
	    
	    String s1 = String.valueOf(hour);
	    String s2 = String.valueOf(minut);
	    String s3 = String.valueOf(second);
	    return s1+":"+s2+":"+s3;

	    
        
    }

    private class RemindTask extends TimerTask {
         public void run() {
             text.setText(getTime());
         }
    }
}