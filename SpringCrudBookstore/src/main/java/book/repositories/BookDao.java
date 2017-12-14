package book.repositories;

import java.util.List;

import book.entity.Book;

public interface BookDao {
	
	public Book getBookByTitle(String title);
	public void addBook(Book book);
	public void deleteBookByTitle(String title);
	public void changeBookPrice(String title, int price);
	public List<Book> getAllBooks();

}
