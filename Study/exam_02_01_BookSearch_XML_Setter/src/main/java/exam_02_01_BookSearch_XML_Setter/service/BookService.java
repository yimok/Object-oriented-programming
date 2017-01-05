package exam_02_01_BookSearch_XML_Setter.service;

import java.util.ArrayList;

import exam_02_01_BookSearch_XML_Setter.dao.BookDAO;
import exam_02_01_BookSearch_XML_Setter.dto.BookDTO;

public class BookService {

	private BookDAO dao;
	private String keyword;
	
	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	//생성자가 받아와서 필드에 설정하는 방법 - Constructor injection
	public BookService(BookDAO dao)
	{
		this.dao = dao;
	}

	public ArrayList<BookDTO> findBookByKeyword() {
		//DAO가 필요해요
		return dao.select(keyword);
	}

}
