package Time;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class Time extends JFrame {

    JTextField text;
    String time = null;

    public Time(JTextField text) {
    	this.text = text ;
        Timer timer = new Timer();
        timer.schedule(new RemindTask(), 0, 1000);
    }

    public String getTime() {
        Calendar calendar = Calendar.getInstance();
        Date date = (Date) calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        time = format.format(date);
        return time;
    }

    private class RemindTask extends TimerTask {
         public void run() {
             text.setText(getTime());
         }
    }
}