package mate.academy.book.shop.repositories;

import mate.academy.book.shop.models.Book;
import java.util.List;

public interface BookRepository {
	Book save(Book book);

	List<Book> findAll();
}
