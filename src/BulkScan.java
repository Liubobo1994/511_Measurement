
public class BulkScan {
	
	int n=0; //����״ֵ̬��0��ʼ��1������2�����ο�ֵ
   
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
