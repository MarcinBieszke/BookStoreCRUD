package book.handlers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import book.entity.Book;
import book.exception.BookOfTheSameTitileExistInDBExecption;
import book.exception.ErrorCustom;
import book.services.BookDaoService;

@Controller
public class ComplexHandler {
	
	@Autowired
	private BookDaoService bookDaoServie;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addBookPage(Book book, Model model){
		model.addAttribute("book", book);
		return "add";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addBookToDB(@Valid @ModelAttribute("book") Book book, Errors errors) throws BookOfTheSameTitileExistInDBExecption{
		
		if(errors.hasErrors()) return "add";
		
		publisher.publishEvent(book);
		bookDaoServie.addBook(book);
		
		return "index";
	}
	
	@RequestMapping("/delete/{title}")
	public String deleteBook(@PathVariable("title") String title){
		bookDaoServie.deleteBookByTitle(title);
		return "books";
	}
	
	@ExceptionHandler(BookOfTheSameTitileExistInDBExecption.class)
	public String exceptionHandler(BookOfTheSameTitileExistInDBExecption ex, RedirectAttributes model){
		ErrorCustom errorCustom = new ErrorCustom();
		errorCustom.setMessage("This book exist in DataBase " + ex.getTitleBook());
		model.addFlashAttribute("errorCustom", errorCustom);
		
		return "redirect:/add";
	}
}
