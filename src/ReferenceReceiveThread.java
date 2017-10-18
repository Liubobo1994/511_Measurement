import java.io.IOException;
import java.io.InputStream;


public class ReferenceReceiveThread  {
	InputStream is;

 	public static float averageArea=0,area=0,sumArea=0;//定义100次扫描收到的数据，求出平均值即为参考面积
    int count=0;                         //定义接收报文的次数
    int countTimes=0;                    //定义接收报文求得面积不为0的次数
    public ReferenceReceiveThread(){}
   
	public ReferenceReceiveThread(InputStream is) 
	{
		this.is = is ;
	}
	public float run(int countTelegram)
	{
		     	          while(true)
	          {
	        	  
        	     try
        	        {  
	        	        byte[] buffer;
	        	        buffer=new byte[is.available()];        //buffer缓冲区读入报文
	        	        if(buffer.length!=0)
	        	        {
	        	        	
	        	        	is.read(buffer);
	        	    	    String telegramData = new String(buffer);//一次传输的报文
	        	    	    DataProcess data = new DataProcess(telegramData);
	        	    	    area=data.StringProcessing();//处理一次传输的报文
	        	    	    if(area!=0)countTimes++;        //通过报文求得的面积不为0时，计数加1
	     //   	    	    System.out.println("countTimes的值是"+countTimes);
	        	    	    count++;
	        	    	    sumArea=sumArea+area;                   //countTimes次计算的总面积
	     //   	    	    System.out.println(count);
	        	        }
       	             }catch (IOException  e) {e.printStackTrace();}
        	       if(count>=countTelegram)        
        	       {
        	    	   averageArea=sumArea/countTimes;                //平均参考面积
        	    	   System.out.println("平均面积是"+averageArea);
            	     break;
        	       }
	            }
	     return averageArea;     //返回平均的参考面积
	          
	}
	
	
}