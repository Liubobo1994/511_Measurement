import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;



public class DataProcess {
	
	String telegramData  = null;
	Connection con = null;
//	private static final float PI = (float) 3.1415926;
	int n=360;//һ��ɨ��������
	DataProcess(String telegramData)
	{
		this.telegramData= telegramData ;

	}

	public float StringProcessing()
	{
      

		  float area = 0;
		  String telegramStart= "sSN LMDscandata";
    	  if(telegramData.indexOf(telegramStart)==1)
    	  {
    			  
		       
    		     float[] pointDistance=new float[1000];
		         String [] strArry = telegramData.split(" ");
		         for(int i =27;i<347;i++ )
			     {
			    	int id = i-27;
			    	float distance = (float) 2*(Integer.parseInt(strArry[i], 16))/1000;
			    	pointDistance[id]=distance;      
			    	
			     }
		         
		         CaculationArea calculate=new CaculationArea(pointDistance);
		         area=calculate.returnArea();      //ÿ��ɨ����������
    	  }
		 return area;
    	  
	  }	
	
	//�������ݿ�
	public  void InsertData(int id,float distance,Connection con)
	{
		 String sql = "insert into sets6 values(?,?)";
         try {
        	PreparedStatement pst = con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
			pst.setInt(1, id);
		    pst.setFloat(2, distance);
		    pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	 
	}
	
	//���ݿ�ر�
	public void DatabaseClose()
	{
		try {
			con.close();
			System.out.println("���ݿ�رճɹ�");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//���ݿ�����
	public  void DatabaseLink()

	{
			try {
			String driver = "com.mysql.jdbc.Driver";
			String url = "jdbc:mysql://localhost:3306/point_sets";
			String user = "root";
			String password = "123456";
	        Class.forName(driver);
	        con = DriverManager.getConnection(url,user,password);
	         
	        if(!con.isClosed())
	             System.out.println("Succeeded connecting to the Database!");
	        Statement statement = con.createStatement();
	     } catch(ClassNotFoundException e) {   
	        System.out.println("Sorry,can`t find the Driver!");   
	        e.printStackTrace();   
	        } catch(SQLException e) {
	        e.printStackTrace();  
	        }catch (Exception e) {
	        e.printStackTrace();
	     }finally{
	 //        System.out.println("���ݿ����ݳɹ���ȡ����");
	     }
		
	}
	
}
