package exam_02_03_BookSearch_Java_DI.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import exam_02_03_BookSearch_Java_DI.dao.BookDAO;
import exam_02_03_BookSearch_Java_DI.service.BookService;


//Annotation : 특정 작업을 지시해줌.
//@Configuration : 이것은 설정에 관련된 클래스라는것을 Spring에 알려줌.
@Configuration
public class ApplicationContext {

	
	//Spring이 ApplicationContext  클래스를 읽어서 Bean 어노테이션을 찿고
	//지정된 메서드를 수행하여 객체를 생성하고 리턴
	@Bean
	public BookDAO dao()
	{
		BookDAO dao = new BookDAO();
		return dao;
		
		
	}
	
	@Bean
	public BookService service(){
		
		//dao() 를 호출해서 리턴된 객체를 BookService에 넘김
		BookService service = new BookService(dao());
		service.setKeyword("여행");
		return service;
	}
	
}
