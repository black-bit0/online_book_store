package mate.academy.book.shop.models;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity(name = "book")
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(nullable = false)
	private String author;

	@Column(nullable = false, unique = true)
	private String isbn ;

	@Column(nullable = false)
	private BigDecimal price;

	private String description;

	@Column(name = "cover_image")
	private String coverImage;
}
