
public class Main {

	public static void main(String[] args)
	{
		Car car = new Car();
		// 소문자 car 는  reference variable , 즉 그냥 변수인데 그안에 메모리 주소값이 있음. 그 메모리 주소값을 따라가니깐 인스턴스가 있다.
		// 근데 객체라고도 부름 정확한 의미가 위의 의미.
		
		
		car.fuel = 1000;
		car.go();
	}
	
	
}
