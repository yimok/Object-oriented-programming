package exam_02_03_BookSearch_Java_DI.service;

import java.util.ArrayList;

import exam_02_03_BookSearch_Java_DI.dao.BookDAO;
import exam_02_03_BookSearch_Java_DI.dto.BookDTO;

public class BookService {
	
	private BookDAO dao;
	private String keyword;

	public BookService(BookDAO dao)
	{
		this.dao = dao;
	}
	
	public void setKeyword(String keyword){
		
		this.keyword = keyword;
	}
	
	public ArrayList<BookDTO> findBookByKeyword() {
		//DAO가 필요해요
		return dao.select(keyword);
	}
	
}
