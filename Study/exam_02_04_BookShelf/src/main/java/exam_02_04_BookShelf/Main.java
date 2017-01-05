package exam_02_04_BookShelf;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam_02_04_BookShelf.dto.BookDTO;

public class Main {

	public static void main(String[] args) {

		String config = "classpath:applicationCtx.xml";
		
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		//Bookshelf 클래스 타입인 shelf 객체를 끄집어냄
		BookShelf shelf = ctx.getBean("shelf",BookShelf.class);
		
		System.out.println("책장 title : " + shelf.getTitle());
		System.out.println("책장 price : " + shelf.getPrice());
		
		//shelf에서 getList를 통해 ArrayList를 뽑아내고 그 ArrayList 안에서 인덱스 1인  BookDTO를 뽑아내서
		//title값을 알아낸다.
		System.out.println(shelf.getList().get(1).getBtitle());
		//shelf에서 getMap을 통해 HashMap을 뽑아내고 그 HashMap 안에서
		//key 값이 2인 BookDTO를 찿아서 책의 제목을 출력
		
		System.out.println(shelf.getMap().get(2).getBtitle());
		
		
		//BookDTO 클래스 타입인 book1 빈 객체를 끄집어 냄
		//xml에 scope가 singleton으로 지정되있으면 두 객체 dto1과 dto2는 같다.
		//xml에 scope가 prototype으로 지정되어있으면 getBean() 할때마다 새로운 객체를 생성한다. 
		//따라서 dto1과 dto2는 다른 객체이다. -> scope에 따라 객체가 같냐 다르냐가 결정됨
 		BookDTO dto1 = ctx.getBean("book1",BookDTO.class);

		BookDTO dto2 = ctx.getBean("book1",BookDTO.class);
		
	}

}
