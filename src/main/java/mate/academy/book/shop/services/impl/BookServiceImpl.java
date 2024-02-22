package mate.academy.book.shop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mate.academy.book.shop.models.Book;
import mate.academy.book.shop.services.BookService;
import mate.academy.book.shop.repositories.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	private final BookRepository bookRepository;

	@Autowired
	public BookServiceImpl(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}
}