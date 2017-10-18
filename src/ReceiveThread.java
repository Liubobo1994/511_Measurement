//开始测量后返回瞬时流量，累积流量，累积体积到状态窗口


import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;



public class ReceiveThread extends Thread {
	InputStream is;
	private double sleepTimeLength=20; //接收数据休眠时间
 	float area;
    static	double accumulateFlow=0;
    static double accumulateQuantity=0;
	public ReceiveThread(InputStream is) 
	{
		this.is = is ;
	}
	   
	
	public void run()
	{
		while(true)
	          {
	        	  
        	     try
        	        {  
	        	        byte[] buffer;
	        	        buffer=new byte[is.available()];
	        	        float instanceFlow;
	        	        if(buffer.length!=0)
	        	        {
	        	    	    is.read(buffer);
	        	    	    String telegramData = new String(buffer);//一次传输的报文
	        	    	    DataProcess data = new DataProcess(telegramData);
	        	    	    area=data.StringProcessing();//处理一次传输的报文
	        	    	    
         	    	        CalcutionInstanceFlow cal=new CalcutionInstanceFlow();
                            instanceFlow=cal.Calculate(area);//计算瞬时流量
                         
	        	    	  if(area!=0)
	        	    	  {
	        	    /*	  System.out.println(new Date()+"的瞬时流量="+ instanceFlow);
	        	    		  System.out.println(area);
	        	    		  
	        	    		  System.out.println(new Date()+"的累积流量是"+accumulateFlow);
	        	    		  Calendar time=Calendar.getInstance();
	        	    		  System.out.println(time.getTimeInMillis()+"\n");*/
	        	    		 
	        	    		  String strInstanceFlow=String.valueOf(instanceFlow);
	        	    		  StatePanel.jtf_7.setText(strInstanceFlow);//返回瞬时流量（体积）
	        	    		  
	        	    		  
	        	    		  accumulateFlow= (accumulateFlow+instanceFlow*0.02);
	        	    		  String straccumulateFlow=String.valueOf(accumulateFlow);
	        	    		  StatePanel.jtf_8.setText(straccumulateFlow);//(返回累积流量-体积)
	        	    		  
	        	    		 accumulateQuantity= accumulateFlow*SetParameter.bulkDensity;
	        	    		 float AccumulateFlowQuantity=(float) (accumulateQuantity);
	        	    		 String strAccumulateFlowQuantity=String.valueOf(AccumulateFlowQuantity);
	        	    		 StatePanel.jtf_9.setText(strAccumulateFlowQuantity);//(返回累积流量-质量)
	        	    				  
	        	    		 
	        	    	  }
	        	    	    
         	    	      Thread.sleep((long) sleepTimeLength);
			           
	        	        }
       	          }catch (IOException | InterruptedException e) {e.printStackTrace();}
	            }
	          
	 }
	
	
	
}
