package book.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import book.entity.Book;

@Repository
@Transactional
public class BookDaoImp implements BookDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getSession(){
		return sessionFactory.getCurrentSession();
	}

	@Override
	public Book getBookByTitle(String title) {
		Query query =  getSession().createQuery("from Book where title=:title");
		query.setParameter("title", title);
		return (Book) query.uniqueResult();
	}

	@Override
	public void addBook(Book book) {
		 getSession().save(book);
		
	}

	@Override
	public void deleteBookByTitle(String title) {
		Book book = getBookByTitle(title);
		 getSession().delete(book);
		
	}

	@Override
	public void changeBookPrice(String title, int price) {
		Book book = getBookByTitle(title);
		book.setPrice(price);
	}

	@Override
	public List<Book> getAllBooks() {
		Query query =  getSession().createQuery("from Book");
		return query.list();
	}
	
}
