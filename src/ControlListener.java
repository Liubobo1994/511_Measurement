import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import Time.Time1;

public class ControlListener implements ActionListener {

	static String a = null ;
	Date date;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getActionCommand() == "开始测量")
		{
			ReceiveThread.accumulateFlow=0;
			ReceiveThread.accumulateQuantity=0;
			BulkScan.run(0);
			Calendar calendar = Calendar.getInstance();
		    date = (Date) calendar.getTime();
		    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		    String time = format.format(date);
			StatePanel.jtf_1.setText(time);	
			
		//new Time1(StatePanel.jtf_3,date).getTime();
		}
		
		if(e.getActionCommand() == "结束测量")
		{
			   BulkScan.run(1);	
				
				//运行时间
				Calendar calendar1 = Calendar.getInstance();
			    Date date2 = (Date) calendar1.getTime();
			    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String date11 = sdf.format(date2);
		        String date22 = sdf.format(date);
		       
		       Date d1 = null ;
		       Date d2 = null ;
				try {
					d1 = sdf.parse(date11);
					d2 = sdf.parse(date22);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  
			    long diff = (d1.getTime() - d2.getTime())/1000;
			    long hour = diff/(60*60); 
			    long minut = diff/60;
			    long second = diff - hour*60*60 - minut*60 ;
			    
			    String s1 = String.valueOf(hour);
			    String s2 = String.valueOf(minut);
			    String s3 = String.valueOf(second);
			    StatePanel.jtf_4.setText(s1+":"+s2+":"+s3);//计算出运行时间
			    
				Calendar calendar2 = Calendar.getInstance();
			    date = (Date) calendar2.getTime();
			    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String time2 = format.format(date);
				StatePanel.jtf_3.setText(time2);
								
		}
		
		
		if(e.getActionCommand() == "设置参数")
		{
		 
			DialogPanel dialog = new DialogPanel();
			dialog.setVisible(true);
		}
		if(e.getActionCommand() == "OK")
		{
			String a = DialogPanel.jtf_1.getText(); 
			if(a!=null)
			{	
		    	SetParameter.beltVelocity= Float.parseFloat(a);
			    String strBeltVelocity=String.valueOf(SetParameter.beltVelocity);
			    StatePanel.jtf_6.setText(strBeltVelocity);
			}
			
			String b = DialogPanel.jtf_2.getText(); 
			if(b!=null)
			{
			   SetParameter.bulkDensity = Float.parseFloat(b);
			   String strBulkDensity=String.valueOf(SetParameter.bulkDensity);
			   StatePanel.jtf_5.setText(strBulkDensity);
			}
			
			String c = DialogPanel.jtf_3.getText();  
			if(c!=null)
				{
				     SetParameter.MaxFlow= Float.parseFloat(c);
				}
		}
		if(e.getActionCommand() == "初始参数测量")
		{
			BulkScan.run(2);
		}
	}
	
	public ControlListener()
	{}

}
