package book.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import book.entity.Book;
import book.exception.BookOfTheSameTitileExistInDBExecption;
import book.repositories.BookDao;

@Service
public class BookDaoServiceImp implements BookDaoService{

	@Autowired
	private BookDao bookDao;
	
	@Override
	public Book getBookByTitle(String title) {
		return bookDao.getBookByTitle(title);
	}

	@Override
	public void addBook(Book book) throws BookOfTheSameTitileExistInDBExecption {
		
		String title = book.getTitle();
		
		if(bookDao.getBookByTitle(title) != null){
			throw new BookOfTheSameTitileExistInDBExecption(title);
		}
		bookDao.addBook(book);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteBookByTitle(String title) {
		bookDao.deleteBookByTitle(title);
	}

	@Override
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void changeBookPrice(String title, int price) {
		bookDao.changeBookPrice(title, price);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookDao.getAllBooks();
	}
}
