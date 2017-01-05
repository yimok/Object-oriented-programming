package exam_03_01_AOP_Inheritance;

import org.aspectj.lang.JoinPoint;

public class MyCrossCuttingConern {

	//advice 역할을 하는 method를 작성
	//부가적인 역할을 하는 코드를 작성
	public void printMethodName(JoinPoint joinpoint) {
		
		String name = joinpoint.getSignature().toShortString();
		System.out.println("호출된 method : " + name);
		
	}
	
}
