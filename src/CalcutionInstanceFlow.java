
public class CalcutionInstanceFlow {

	float spaceTime=(float) 0.02;//ɨ��ʱ����
    float instanceArea;              //˲ʱ���
    float instanceFlow;              //˲ʱ����
    
    float Calculate(float instanceArea)
    {
       instanceFlow=(float) ((SetParameter.referenceArea-instanceArea)*Math.cos(SetParameter.betaAngle)*SetParameter.beltVelocity);//���˲ʱ���������
       return instanceFlow;
    }  
	
	
	
	
	
	
	
	
	
	
	
	
}
