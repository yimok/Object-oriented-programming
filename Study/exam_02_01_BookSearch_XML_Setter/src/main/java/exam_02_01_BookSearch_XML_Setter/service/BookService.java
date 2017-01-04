package exam_02_01_BookSearch_XML_Setter.service;

import java.util.ArrayList;

import exam_02_01_BookSearch_XML_Setter.dao.BookDAO;
import exam_02_01_BookSearch_XML_Setter.dto.BookDTO;

public class BookService {

	private BookDAO dao;
	
	public BookDAO getDao() {
		return dao;
	}

	public void setDao(BookDAO dao) {
		this.dao = dao;
	}

	public ArrayList<BookDTO> findBookByKeyword(String keyword) {
		//DAO가 필요해요
		return dao.select(keyword);
	}

}
