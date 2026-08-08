package ir.nas.model;

import ir.nas.model.base.BaseModel;
import ir.nas.model.embeddable.Address;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
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
@Table(name = "authors")
@SequenceGenerator(name = "seq_gen", sequenceName = "author_seq_gen", initialValue = 0, allocationSize = 1)
public class Author extends BaseModel<Long>
{
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

    // TODO book
    // TODO publisher
    // TODO profile
}
