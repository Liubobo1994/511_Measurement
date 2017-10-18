
public class CaculationArea {
	     CaculationArea(){}
	     float space=(float) 0.5; //扫描间隔，默认为0.5度
	     float scanAngle=160; //扫描角度，默认为160度
	     int pointCount=(int) (scanAngle/space);//每次扫描的点数目，默认为0.5度的间隔，340个点
	     float pointDistance[]=new float[pointCount];
	     CaculationArea(float[] pointDistance)
	    {
	    	this.pointDistance=pointDistance;   //每个点的距离
	    }
		public float returnArea()
				{
			      float area=0;  //面积
			      int i;
			      for(i=0;i<pointCount-1;i++)
			      {
			    	 float r=(pointDistance[i]+pointDistance[i+1])/2; //计算积分扇面的半径
//			    	 System.out.println(r); 
			    	 float sectorArea=(float) (Math.PI*space/180*r*r/2);               //计算积分扇面的面积
			    	  area=area+sectorArea;
			      }
			      return area;
				}
}
