package exam_02_01_BookSearch_XML_Setter;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.context.support.AbstractApplicationContext;

import org.springframework.context.support.GenericXmlApplicationContext;

import exam_02_01_BookSearch_XML_Setter.dto.BookDTO;
import exam_02_01_BookSearch_XML_Setter.service.BookService;

public class Main {

	public static void main(String[] args) {
		
		//DI 즉 주입이 어떻게 할건지 xml문서에 기입이 되어있음
		//스프링 컨테이너인 ctx가 config를 보고 DI를 수행함
		
		//applicationCtx.xml 는 리소스 폴더에 있어야함.
		String config ="classpath:applicationCtx.xml";
		//DI 작업을해주는 스프링 객체
		//xml에 명시되어있는 객체 2개를 생성.
		AbstractApplicationContext ctx = new GenericXmlApplicationContext(config);
		
		Scanner s = new Scanner(System.in);
		System.out.print("키워드를 입력하세요=>");

		String keyword = s.nextLine();
		
		//service 객체를 직접만드는게 아니라 스프링컨테이너에서 꺼내 사용함.
		//스프링 컨테이너에서 필요한 service 객체를 하나 끄집어 냄 , Service의 클래스 타입을 직접 명시도 해줘야함.
		BookService service = ctx.getBean("service" , BookService.class);
		ArrayList<BookDTO> list = service.findBookByKeyword(keyword);
		
		for(BookDTO dto : list)
		{
			System.out.println(dto.getBtitle() + ", " + dto.getBauthor());
		
		}
	}

}
