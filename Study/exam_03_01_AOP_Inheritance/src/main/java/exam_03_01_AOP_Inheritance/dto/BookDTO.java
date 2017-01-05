package exam_03_01_AOP_Inheritance.dto;

public class BookDTO {

	private String btitle;
	private String bauthor;
	
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
