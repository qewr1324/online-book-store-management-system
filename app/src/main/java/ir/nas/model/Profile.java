package ir.nas.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Lob;
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
@Table(name = "profiles")
@SequenceGenerator(name = "seq_gen", sequenceName = "profile_seq_gen", initialValue = 0, allocationSize = 1)
public class Profile extends BaseModel<Long>
{
    @Lob
    private String biography;

    @Column(length = 50, unique = true)
    private String email;

    @Column(nullable = false, unique = true, length = 20)
    private String username;

    @Column(nullable = false, unique = true, length = 20)
    private String password;

    // TODO author
    // TODO book
    // TODO publisher
}
