package book.services;

import java.util.List;

import book.entity.Book;
import book.exception.BookOfTheSameTitileExistInDBExecption;

public interface BookDaoService {
	
	public Book getBookByTitle(String title);
	public void addBook(Book book) throws BookOfTheSameTitileExistInDBExecption;
	public void deleteBookByTitle(String title);
	public void changeBookPrice(String title, int price);
	public List<Book> getAllBooks();
}
