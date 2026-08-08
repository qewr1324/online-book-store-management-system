package ir.nas.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@SequenceGenerator(name = "seq_gen", sequenceName = "book_seq_gen", initialValue = 0, allocationSize = 1)
public class Book extends BaseModel<Long>
{
    @Column(nullable = false, length = 50, unique = true)
    private String title;

    @Column(nullable = false, length = 20, unique = true)
    private String ISBN;

    @Column(precision = 10, scale = 2, nullable = false)
    private BigDecimal price;

    // TODO publisher
    // TODO authors
}
