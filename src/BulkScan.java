
public class BulkScan {
	
	int n=0; //测量状态值，0开始，1结束，2测量参考值
   
	BulkScan(){}
	static void  run(int n)
	{
		
     	SocketSendInstruction socketSend=new SocketSendInstruction();
     	if(n==0)
     	{
     		socketSend.startMeasure();
    
     	}
       if(n==1)
     	{
    	   socketSend.stopMachine();
     	}
       if(n==2)
       {
    	   
           SetParameter.referenceArea=socketSend.startMeasureReference();
          
	   }
	}
}
