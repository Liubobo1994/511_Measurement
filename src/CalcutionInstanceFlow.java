
public class CalcutionInstanceFlow {

	float spaceTime=(float) 0.02;//扫描时间间隔
    float instanceArea;              //瞬时面积
    float instanceFlow;              //瞬时流量
    
    float Calculate(float instanceArea)
    {
       instanceFlow=(float) ((SetParameter.referenceArea-instanceArea)*Math.cos(SetParameter.betaAngle)*SetParameter.beltVelocity);//求得瞬时的体积流量
       return instanceFlow;
    }  
	
	
	
	
	
	
	
	
	
	
	
	
}
