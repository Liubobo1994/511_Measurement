
public class CaculationArea {
	     CaculationArea(){}
	     float space=(float) 0.5; //ɨ������Ĭ��Ϊ0.5��
	     float scanAngle=160; //ɨ��Ƕȣ�Ĭ��Ϊ160��
	     int pointCount=(int) (scanAngle/space);//ÿ��ɨ��ĵ���Ŀ��Ĭ��Ϊ0.5�ȵļ����340����
	     float pointDistance[]=new float[pointCount];
	     CaculationArea(float[] pointDistance)
	    {
	    	this.pointDistance=pointDistance;   //ÿ����ľ���
	    }
		public float returnArea()
				{
			      float area=0;  //���
			      int i;
			      for(i=0;i<pointCount-1;i++)
			      {
			    	 float r=(pointDistance[i]+pointDistance[i+1])/2; //�����������İ뾶
//			    	 System.out.println(r); 
			    	 float sectorArea=(float) (Math.PI*space/180*r*r/2);               //���������������
			    	  area=area+sectorArea;
			      }
			      return area;
				}
}
