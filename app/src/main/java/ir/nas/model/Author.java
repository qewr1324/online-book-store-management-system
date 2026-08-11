package ir.nas.model;

import java.util.List;

import ir.nas.model.base.BaseModel;
import ir.nas.model.embeddable.Address;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

/**
 * Author
 * 
 * <p>A class to build the author model. With builder functionality
 * for easier and more readable class construction.</p>
 * 
 * <p><strong>Example:</strong>
 * <pre>
 * {@code Author author = Author.builder()
 *                      .id(Long)
 *                      .firstName(String)
 *                      .lastName(String)
 *                      .phoneNumber(String)
 *                      .age(int)
 *                      .build();
 * }
 * </pre>
 * </p>
 * @implNote It has three relationships: <pre>
 * {@code 
 * @ManyToMany(mappedBy = "authors", cascade = CascadeType.MERGE)
 * List<Book> books;
 * 
 * @ManyToOne(cascade = CascadeType.MERGE)
 * Publisher publisher;
 * 
 * @OneToOne(mappedBy = "author")
 * Profile profile;}</pre>
 * @since 1405
 * @author GhurbeSABZI
 * @version 1.0.0
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@SuperBuilder
@Entity
@Table(name = "authors")
@SequenceGenerator(name = "author_seq_gen", sequenceName = "author_seq_gen", initialValue = 0, allocationSize = 1)
public class Author extends BaseModel<Long>
{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq_gen")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "phone_Number", nullable = false, length = 11, unique = true)
    private String phoneNumber;

    @Column(nullable = false)
    private int age;

    @Embedded
    private Address address;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToMany(mappedBy = "authors", cascade = CascadeType.MERGE)
    private List<Book> books;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @ManyToOne(cascade = CascadeType.MERGE)
    private Publisher publisher;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToOne(mappedBy = "author")
    private Profile profile;
}
