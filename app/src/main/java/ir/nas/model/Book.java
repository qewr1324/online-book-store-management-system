package ir.nas.model;

import java.math.BigDecimal;
import java.util.List;

import ir.nas.model.base.BaseModel;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "books")
@SequenceGenerator(name = "book_seq_gen", sequenceName = "book_seq_gen", initialValue = 0, allocationSize = 1)
public class Book extends BaseModel<Long>
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_seq_gen")
    private Long id;

    @Column(nullable = false, length = 50, unique = true)
    private String title;

    @Column(nullable = false, length = 20, unique = true)
    private String ISBN;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany
    private List<Author> authors;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne
    private Publisher publisher;
}
