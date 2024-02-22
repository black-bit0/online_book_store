package mate.academy.book.shop;

import mate.academy.book.shop.repositories.BookRepository;
import mate.academy.book.shop.models.Book;
import mate.academy.book.shop.services.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class BookServiceTest {

	@Autowired
	private BookService bookService;

	@MockBean
	private BookRepository bookRepository;

	@Test
	void testSave() {
		// Given
		Book bookToSave = Book.builder()
				.title("Test Book")
				.author("Test Author")
				.isbn("1234567890")
				.price(new BigDecimal("19.99"))
				.description("Test Description")
				.coverImage("test-image.jpg")
				.build();

		// When
		bookService.save(bookToSave);

		// Then
		verify(bookRepository, times(1)).save(bookToSave);
	}

	@Test
	void testFindAll() {
		// Given
		List<Book> books = Arrays.asList(
				Book.builder().title("Book 1").build(),
				Book.builder().title("Book 2").build(),
				Book.builder().title("Book 3").build()
		);

		when(bookRepository.findAll()).thenReturn(books);

		// When
		List<Book> result = bookService.findAll();

		// Then
		assertEquals(3, result.size());
		assertEquals("Book 1", result.get(0).getTitle());
		assertEquals("Book 2", result.get(1).getTitle());
		assertEquals("Book 3", result.get(2).getTitle());
	}
}
