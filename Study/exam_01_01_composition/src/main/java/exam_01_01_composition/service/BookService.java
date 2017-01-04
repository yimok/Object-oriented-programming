package exam_01_01_composition.service;

import java.util.ArrayList;

import exam_01_01_composition.DAO.BookDAO;
import exam_01_01_composition.DAO.DAO;
import exam_01_01_composition.DTO.BookDTO;

public class BookService {

	private DAO dao;
	
	
	public BookService(DAO dao) {
		this.dao = dao;
	}


	public DAO getDao() {
		return dao;
	}


	public void setDao(BookDAO dao) {
		this.dao = dao;
	}


	public ArrayList<BookDTO> findBookByKeyword(String keyword) {
		
		return dao.select(keyword);
		
	}
	
	

}
