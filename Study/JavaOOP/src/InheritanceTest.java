


interface Word{
	
	//�������̽��� �߻� �޼��带 ������ �ִ�.
	public void printInfo();
}


//Interface�� IS-A ���谡 �����Ѵ�.
class English implements Word{

	//�������̽��� ����Ҷ��� �ݵ�� �߻�޼��带 �������̵� �ؾ��Ѵ�.
	@Override
	public void printInfo() {
		
		
	}
	
}



//Super class, Parent class , Upper class
//����Ŭ����, �θ�Ŭ����
class Human
{
	int age;
	public void printInfo()
	{
		
	}
	
}

//Sub class, child class, �ڽ� Ŭ����, ���� Ŭ����
class Student extends Human{
	}


//Ŭ������ �� ����ϴ� ���� ������ : ���(inheritance)
//����� Ŭ�������� ���յ��� ����� ������ �� �ۿ� ���� �����̴�. -> �ڽ�Ŭ������ ����Ϸ��� �ݵ�� �θ� Ŭ������ �ʿ�
//IS-A Relationship(IS-A ����) : ��Ӱ��迡 �ִ� �� Ŭ�������� �����ϴ� ����� "subclass is a superclass"�� ���踦 �ǹ��Ѵ�.
//������ - ����  ( ���� is a ������), �ݴ�(��)�� �������� �ʴ´�.
//subclass�� Ÿ���� ����ϴ� ���� superclass�� Ÿ���� �ᵵ �ȴ�!!

public class InheritanceTest {

	public static void main(String[] args){
		
		//IS-A ����� ���� ����, ����Ŭ������ ���鋚 ����Ŭ������ ������ �ִ�.
		//���� �������� ���·� �ν��Ͻ��� �� �� �ִ�. ������ �̶���� ���Ѵ�. -> Student b = new Student(); �� �ǰ�, 	Human c = new Student(); �� �ȴ�.
		Human a = new Human();
		Student b = new Student();
		Human c = new Student();
	}
}