package book.listener;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import book.entity.Book;

@Component
public class ListenerAddBook {
	
	@EventListener
	@Async
	public void addBookListener(Book book){
		System.out.println("Add book " + book.getTitle());
	}

}
