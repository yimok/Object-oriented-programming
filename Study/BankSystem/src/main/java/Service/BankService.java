package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DAO.BankDAO;
import DTO.BankDTO;

public class BankService {

	public BankDTO deposit(BankDTO dto) {

		// 로직 처리를 한다.
		// 다만 우리 프로그램은 별다른 로직처리가 없음
		// Database 처리만 하면된다.

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loading Success");
			// 2. 실제 데이터베이스에 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false); // 해당 connection에 transaction을 설정

			// connection을 넘김
			BankDAO dao = new BankDAO();
			int result = dao.UpdateDepositTransaction(con, dto);

			// 맨 마지막에 제대로 처리가 되면 commit, 아니면 rollback
			if (result == 1) {
				con.commit();

			} else {
				con.rollback();
			}

			//select로 결과 리턴
			dto = dao.SelectResult(con, dto);
			con.close();

		} catch (Exception e) {

			System.out.println(e);
		}

		return dto;
	}

	public BankDTO withdrawal(BankDTO dto) {

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 실제 데이터베이스에 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false); // 해당 connection에 transaction을 설정

			// connection을 넘김

			BankDAO dao = new BankDAO();
			int result = dao.UpdateWithdrawalTransaction(con, dto);

			// 맨 마지막에 제대로 처리가 되면 commit, 아니면 rollback
			if (result == 1) {
				con.commit();

			} else {
				con.rollback();
			}

			//select로 결과 리턴
			dto = dao.SelectResult(con, dto);
			con.close();
		} catch (Exception e) {

			System.out.println(e);
		}

		return dto;
	}

	public ArrayList<BankDTO> transfer(ArrayList<BankDTO> list) {

		// 데이터의 불일치성에 대한 문제를 어떻게 해겨랳야 하나요??
		// 이문제를 해결하기 위해서 Transaction처리를 꼭 해야줘야 한다.
		// Service단에서 Transaction처리를 해 줘야 한다.
		// Transaction이 어디에 설정하는가를 잘 생각해 봐야 한다.
		// 여기서 Connection을 만들어서 Transaction을 걸어야 한다.
		// 이 Connection을 DAO에 넘겨줘서 사용하도록 한다.

		try {
			// 1. 드라이버 로딩
			Class.forName("com.mysql.jdbc.Driver");

			// 2. 실제 데이터베이스에 접속
			String url = "jdbc:mysql://localhost:3306/library";
			String id = "root";
			String pw = "cps431";
			Connection con = DriverManager.getConnection(url, id, pw);
			con.setAutoCommit(false); // 해당 connection에 transaction을 설정

			// connection을 넘김
			BankDAO dao = new BankDAO();
			int result = dao.UpdateTransferTransaction(con, list);

			// 맨 마지막에 제대로 처리가 되면 commit, 아니면 rollback
			if (result == 1) {
				con.commit();

			} else {
				con.rollback();
			}

			//select로 결과 리턴
			list = dao.SelectResultList(con, list);
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

		return list;
	}

}
