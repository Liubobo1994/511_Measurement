import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.io.BufferedReader;



public class SocketSendInstruction {

	 byte [] authorizedInstruction = {0X02,0X73,0X4D,0X4E,0X20,0X53,0X65,0X74,0X41,0X63,0X63,0X65,0X73,0X73,0X4D,0X6F,0X64,0X65,0X20,0X30,0X33,0X20,0X46,0X34,0X37,0X32,0X34,0X37,0X34,0X34,0X03};
	 byte [] startInstruction = {0X02,0X73,0X4D,0X49,0X20,0X30,0X20,0X33,0X20,0X46,0X34,0X37,0X32,0X34,0X37,0X34,0X34,0X03,0X02,0X73,0X4D,0X49,0X20,0X34,0X38,0X03,0X02,0X73,0X4D,0X49,0X20,0X32,0X03};
     byte [] stopInstruction =  {0x02,0x73,0x4D,0x49,0x20,0x30,0x20,0x33,0x20,0x46,0x34,0x37,0x32,0x34,0x37,0x34,0x34,0x03,0x02,0x73,0x4D,0x49,0x20,0x34,0x41,0x03,0x02,0x73,0x4D,0x49,0x20,0x32,0x03};     
     byte [] sendDataPermanentlyInstruction= {0X02,0X73,0X45,0X4E,0X20,0X4C,0X4D,0X44,0X73,0X63,0X61,0X6E,0X64,0X61,0X74,0X61,0X20,0X31,0X03};
	 String ipAddress="192.168.0.67";//ip地址
	 int port=2111;                  //端口号 
	 private OutputStream os;
	 private InputStream in;
     SocketSendInstruction()
     {
    	  try {	
			     
		       Socket socket = new Socket(ipAddress,port);
		        os = socket.getOutputStream();
		        in =socket.getInputStream();
//		       new SendThread(os).start();
//		       new ReceiveTread(is).start();      
	        } 
	        catch (IOException e) 
	       {
	            e.printStackTrace();       
	        }
     }	 
     
	 void startMeasure()
	  {
			try {
				
				os.write(authorizedInstruction);
				os.write(startInstruction); 
				
				System.out.println("开始测量");
        		os.write(sendDataPermanentlyInstruction);	
				os.flush();
				ReceiveThread receiveData=new ReceiveThread(in);
				 receiveData.start();
			    } 
			catch (IOException e)
			  {
				e.printStackTrace();
		      }
	  }
	 void stopMachine()
	 {
		  try {
				os.write(authorizedInstruction);
				os.write(stopInstruction);
				System.out.println("停止测量");
				os.flush();
			    } 
			catch (IOException e)
			  {
				e.printStackTrace();
		      }
	 }
     float startMeasureReference()//求出初始状态下的参考面积averageArea

	 {
    	 float averageArea=0;
    	 int countTelegram=10000;
		 try {
				os.write(authorizedInstruction);
				os.write(startInstruction); 
				System.out.println("开始测量");
     		    os.write(sendDataPermanentlyInstruction);	
				os.flush();
				ReferenceReceiveThread receiveData=new ReferenceReceiveThread(in);
			     averageArea=receiveData.run(countTelegram);
    	      } 
			catch (IOException e)
			  {
				e.printStackTrace();
		      } 
		 return averageArea;
	  }
		 
}
