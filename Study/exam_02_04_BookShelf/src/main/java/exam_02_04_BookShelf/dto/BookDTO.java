package exam_02_04_BookShelf.dto;

public class BookDTO {

		//필드는 특별한 이유가 있지 않는한 information hiding때문에
		//private으로 설정한다.
		private String btitle;
		private String bauthor;
		
		//기본 constructor는 사용하던 사용하지 않던간에 반드시 명시를 해 주세요!!
		
		public BookDTO()
		{
			
		}

		
		//private 필드에 대한 getter/setter
		public String getBtitle() {
			return btitle;
		}

		public void setBtitle(String btitle) {
			this.btitle = btitle;
		}

		public String getBauthor() {
			return bauthor;
		}

		public void setBauthor(String bauthor) {
			this.bauthor = bauthor;
		}
		
	
		
}
