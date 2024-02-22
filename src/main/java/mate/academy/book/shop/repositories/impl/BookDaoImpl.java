package mate.academy.book.shop.repositories.impl;

import mate.academy.book.shop.repositories.BookRepository;
import mate.academy.book.shop.models.Book;
import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class BookDaoImpl implements BookRepository {
	private final SessionFactory sessionFactory;

	@Autowired
	public BookDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Book save(Book book) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();
			session.save(book);
			transaction.commit();
			return book;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			throw new RuntimeException("Can't insert book to db: " + book.getTitle());
		} finally {
		if (session != null) {
			session.close();
		}
		}
	}

	@Override
	public List<Book> findAll() {
		try (Session session = sessionFactory.openSession()) {
			return session.createNativeQuery("SELECT * FROM book", Book.class).list();
		} catch (Exception e) {
			throw new RuntimeException("Error while retrieving all books", e);
		}
	}
}
