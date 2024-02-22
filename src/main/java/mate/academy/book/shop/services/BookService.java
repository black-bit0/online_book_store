package mate.academy.book.shop.services;

import mate.academy.book.shop.models.Book;
import java.util.List;

public interface BookService {

	void save(Book book);

	List<Book> findAll();
}
