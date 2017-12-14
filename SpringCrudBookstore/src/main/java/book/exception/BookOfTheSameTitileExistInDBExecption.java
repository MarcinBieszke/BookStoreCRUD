package book.exception;


public class BookOfTheSameTitileExistInDBExecption extends RuntimeException {
	
	private String titleBook;
	
	public BookOfTheSameTitileExistInDBExecption(String titleBook){
		this.titleBook = titleBook;
	}

	public String getTitleBook() {
		return titleBook;
	}

}
