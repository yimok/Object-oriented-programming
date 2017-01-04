package exam_01_01_composition.DAO;

import java.util.ArrayList;

import exam_01_01_composition.DTO.BookDTO;

public interface DAO {

	ArrayList<BookDTO> select(String keyword);

	

}
