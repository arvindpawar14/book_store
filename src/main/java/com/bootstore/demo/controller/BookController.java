package com.bootstore.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.bootstore.demo.entity.Book;
import com.bootstore.demo.entity.MyBookList;
import com.bootstore.demo.service.BookService;
import com.bootstore.demo.service.MyBookListService;

@Controller
public class BookController {
	
	@Autowired
	private BookService bookService;

	@Autowired
	private MyBookListService myBookListService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/book_register")
	public String BookRegister() {
		return "bookregister";
	}

	@GetMapping("/available_books")
	public ModelAndView getAllBook() {
		List<Book> list = bookService.getallBook();
	//	ModelAndView mav = new ModelAndView();
		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String AddBook(@ModelAttribute Book b) {
		bookService.save(b);
		return "redirect:/available_books";
	}

	@GetMapping("/my_books")
	public String getMyBooks(Model model) {
		List<MyBookList> list = myBookListService.getAllMyBooks();
		model.addAttribute("book", list);
		return "myBooks";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = bookService.getBookById(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		myBookListService.saveMyBook(mb);
		return "redirect:/my_books";
	}

	@RequestMapping("/editBook/{id}")
	public String editBook(@PathVariable("id") int id, Model model) {
		Book b = bookService.getBookById(id);
		model.addAttribute("book", b);
		return "bookEdit";
	}

	@RequestMapping("//deleteBook/{id}")
	public String editBook(@PathVariable("id") int id) {
		bookService.deleteById(id);
		return "redirect:/available_book";
	}

}
