package Service;

import java.util.ArrayList;

import DAO.BookDAO;
import DTO.BookDTO;

//Service 는 로직을 처리하는 객체를 만들기위한 class
public class BookService {

	public ArrayList<BookDTO> findBookbyKeyword(String keyword) {
		
		
		//로직처리 수행(더하고, 빼고, 반복문 돌리고 등등..) -> 다만 우리가 수행할 코드는 로직수행이 필요없음 검색만하면됨. 
		//따라서 바로 데이터베이스 처리가 필요하다. -> 그런데 데이터베이스 처리는 무조건 DAO에서 수행
		//dao 인스턴스 생성
		BookDAO dao = new BookDAO();
		//dao로 keyword를 넘김
		ArrayList<BookDTO> list = dao.select(keyword);
		return list;
	}

}
