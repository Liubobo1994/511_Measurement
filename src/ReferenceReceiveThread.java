import java.io.IOException;
import java.io.InputStream;


public class ReferenceReceiveThread  {
	InputStream is;

 	public static float averageArea=0,area=0,sumArea=0;//����100��ɨ���յ������ݣ����ƽ��ֵ��Ϊ�ο����
    int count=0;                         //������ձ��ĵĴ���
    int countTimes=0;                    //������ձ�����������Ϊ0�Ĵ���
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
	        	        buffer=new byte[is.available()];        //buffer���������뱨��
	        	        if(buffer.length!=0)
	        	        {
	        	        	
	        	        	is.read(buffer);
	        	    	    String telegramData = new String(buffer);//һ�δ���ı���
	        	    	    DataProcess data = new DataProcess(telegramData);
	        	    	    area=data.StringProcessing();//����һ�δ���ı���
	        	    	    if(area!=0)countTimes++;        //ͨ��������õ������Ϊ0ʱ��������1
	     //   	    	    System.out.println("countTimes��ֵ��"+countTimes);
	        	    	    count++;
	        	    	    sumArea=sumArea+area;                   //countTimes�μ���������
	     //   	    	    System.out.println(count);
	        	        }
       	             }catch (IOException  e) {e.printStackTrace();}
        	       if(count>=countTelegram)        
        	       {
        	    	   averageArea=sumArea/countTimes;                //ƽ���ο����
        	    	   System.out.println("ƽ�������"+averageArea);
            	     break;
        	       }
	            }
	     return averageArea;     //����ƽ���Ĳο����
	          
	}
	
	
}