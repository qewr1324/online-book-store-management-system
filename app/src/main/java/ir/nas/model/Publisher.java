package ir.nas.model;

import java.time.LocalDate;
import java.util.List;

import ir.nas.model.base.BaseModel;
import ir.nas.model.embeddable.Address;
import ir.nas.model.enums.CompanyType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
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
@Table(name = "publishers")
@SequenceGenerator(name = "publisher_seq_gen", sequenceName = "publisher_seq_gen", initialValue = 0, allocationSize = 1)
public class Publisher extends BaseModel<Long>
{
    @Column(name = "company_name", length = 50, nullable = false, unique = true)
    private String companyName;

    @Column(length = 50, unique = true)
    private String email;

    @Column(name = "national_code", length = 50, nullable = false, unique = true)
    private String nationalId;

    @Enumerated(EnumType.STRING)
    private CompanyType companyType;

    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    @Column(length = 50, nullable = false, unique = true)
    private String website;

    @Embedded
    private Address address;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "publisher")
    private List<Book> books;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "publisher")
    private List<Author> authors;
}
