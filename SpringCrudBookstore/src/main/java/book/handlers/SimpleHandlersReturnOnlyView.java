package book.handlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import book.entity.Book;
import book.services.BookDaoService;

@Controller
public class SimpleHandlersReturnOnlyView {
	
	@Autowired
	private BookDaoService bookDaoService;
	
	@RequestMapping("/")
	public String mainPage(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String loginPage(){
		return "log";
	}
	
	@RequestMapping("/book/{title}")
	public String showBook(@PathVariable("title") String title, Model model){
		Book book = bookDaoService.getBookByTitle(title);
		model.addAttribute("book", book);
		return "book";
	}
	
	@RequestMapping("/books")
	public String showAllBooks(Model model){
		List<Book> listBooks = bookDaoService.getAllBooks();
		model.addAttribute("books", listBooks);
		return "books";
	}
	
	@RequestMapping("/errorPage")
	public String errorPage(){
		return "accesserror";
	}
	
	@RequestMapping("/book/{title}/{price}")
	public String showBook(@PathVariable("title") String title, @PathVariable("price") int price, RedirectAttributes model){
		bookDaoService.changeBookPrice(title, price);
		model.addAttribute("title", title);
		
		return "redirect:/book/{title}";
		}
	
	
}
