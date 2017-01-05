package exam_02_04_BookShelf;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import exam_02_04_BookShelf.dto.BookDTO;

public class Main {

	public static void main(String[] args) {

		String config = "classpath:applicationCtx.xml";
		
		//Spring Container 생성
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		
		//xml문서 불러들이는 부분
		ctx.load(config);
		
		//load 메서드로 xml을 불러올 경우 반드시 refresh() 메서드를 수행해야함.
		//xml 적용
		ctx.refresh();
		
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
	
		ctx.close();
	}

}
