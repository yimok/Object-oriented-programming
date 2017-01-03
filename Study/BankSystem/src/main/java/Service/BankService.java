package Service;

import java.util.ArrayList;

import DAO.BankDAO;
import DTO.BankDTO;

public class BankService {

	public BankDTO deposit(BankDTO dto) {
		
		//로직 처리를 한다.
		//다만 우리 프로그램은 별다른 로직처리가 없음
		//Database 처리만 하면된다.
		
		
		//DB 처리후 결과를 dto에 저장하고 Controller 쪽으로 리턴 
		BankDAO dao = new BankDAO();
		dto = dao.UpdateDeposit(dto);
		
		return dto;
	}

	public BankDTO withdrawal(BankDTO dto) {
		
		BankDAO dao = new BankDAO();
		dto = dao.UpdateWithdrawal(dto);
		
		
		return dto;
	}

	public ArrayList<BankDTO> transfer(ArrayList<BankDTO> list) {
	
		BankDAO dao = new BankDAO();
		list = dao.UpdateTransfer(list);
		
		
		return list;
	}



}
