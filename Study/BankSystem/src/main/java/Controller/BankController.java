package Controller;

import java.util.ArrayList;
import java.util.Scanner;

import DTO.BankDTO;
import Service.BankService;



public class BankController {

	//반복 사용되는 자원들은 필드로 잡아서 사용하는게 효율적이다.
	Scanner s;

	public BankController()
	{
		ArrayList<BankDTO> list = new ArrayList<BankDTO>();
		String menu = null;
		s = new Scanner(System.in);
		
		do{
			System.out.println("--- 메뉴입니다. ---");
			System.out.println("1. 입금");
			System.out.println("2. 출금");
			System.out.println("3. 이체");
			System.out.println("4. 종료");
			System.out.print("메뉴를 입력하세요 => ");
			menu = s.nextLine();
			
			if(menu.equals("1"))
			{
				System.out.print("입금할 사람의 이름: ");
				String name = s.nextLine();
				System.out.print("입금할 금액을 입력하세요:");
				int money = s.nextInt();
				
				//DTO를 만들고  데이터를 넣은 후 DTO를 이용해 서비스쪽에 넘김
				BankDTO dto = new BankDTO();
				dto.setUsername(name);
				dto.setBalance(money);
				
				BankService service = new BankService();
				
				//결과처리된 것을 다시 dto로 받음
				dto = service.deposit(dto);
				System.out.println(dto.getUsername() + "의 잔액은" + dto.getBalance() + "입니다.");
				

			}
			else if (menu.equals("2"))
			{
				
				System.out.print("출금할 사람의 이름: ");
				String name = s.nextLine();
				System.out.print("출금할 금액을 입력하세요:");
				int money = s.nextInt();
				
				//DTO를 만들고  데이터를 넣은 후 DTO를 이용해 서비스쪽에 넘김
				BankDTO dto = new BankDTO();
				dto.setUsername(name);
				dto.setBalance(money);
				
				BankService service = new BankService();
				
				//결과처리된 것을 다시 dto로 받음
				dto = service.withdrawal(dto);
				System.out.println(dto.getUsername() + "의 잔액은" + dto.getBalance() + "입니다.");
				
			}
			else if(menu.equals("3"))
			{
				
				System.out.print("이체할 사람의 이름: ");
				String name = s.nextLine();
				System.out.print("누구에게 이체 하시겠습니까:");
				String name2 = s.nextLine();
						
				System.out.print("이체할 금액을 입력하세요:");
				int money = s.nextInt();
				
				//DTO를 만들고  데이터를 넣은 후 DTO를 이용해 서비스쪽에 넘김
				BankDTO dto = new BankDTO();
				dto.setUsername(name);
				dto.setBalance(money);
				
				BankDTO dto2 = new BankDTO();
				dto2.setUsername(name2);
				dto2.setBalance(money);
				
				list.add(dto);
				list.add(dto2);
				BankService service = new BankService();
				
				//결과처리된 것을 다시 dto로 받음
				list = service.transfer(list);
				System.out.println(list.get(0).getUsername() + "의 잔액은" + list.get(0).getBalance() + "입니다.");
				System.out.println(list.get(1).getUsername() + "의 잔액은" + list.get(1).getBalance() + "입니다.");
			}
			

			
		}while(!menu.equals("4"));
		System.out.println("프로그램 종료");
			

		
	}
		
		
}
	

