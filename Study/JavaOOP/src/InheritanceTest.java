


interface Word{
	
	//인터페이스는 추상 메서드를 가지고 있다.
	public void printInfo();
}


//Interface도 IS-A 관계가 성립한다.
class English implements Word{

	//인터페이스를 사용할때는 반드시 추상메서드를 오버라이드 해야한다.
	@Override
	public void printInfo() {
		
		
	}
	
}



//Super class, Parent class , Upper class
//상위클래스, 부모클래스
class Human
{
	int age;
	public void printInfo()
	{
		
	}
	
}

//Sub class, child class, 자식 클래스, 하위 클래스
class Student extends Human{
	}


//클래스를 재 사용하는 가장 쉬운방법 : 상속(inheritance)
//상속은 클래스간의 결합도가 상당히 높아질 수 밖에 없는 구조이다. -> 자식클래스를 사용하려면 반드시 부모 클래스가 필요
//IS-A Relationship(IS-A 관계) : 상속관계에 있는 두 클래스간에 성립하는 관계로 "subclass is a superclass"의 관계를 의미한다.
//포유류 - 고래  ( 고래 is a 포유류), 반대(역)는 성립하지 않는다.
//subclass의 타입을 써야하는 곳에 superclass의 타입을 써도 된다!!

public class InheritanceTest {

	public static void main(String[] args){
		
		//IS-A 관계라 수행 가능, 하위클래스를 만들떄 상위클래스로 받을수 있다.
		//★즉 여러가지 형태로 인스턴스를 쓸 수 있다. 다형성 이라고도 말한다. -> Student b = new Student(); 도 되고, 	Human c = new Student(); 도 된다.
		Human a = new Human();
		Student b = new Student();
		Human c = new Student();
	}
}
