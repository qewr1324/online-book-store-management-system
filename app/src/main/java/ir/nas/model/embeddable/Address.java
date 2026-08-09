package ir.nas.model.embeddable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Address
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
@Embeddable
public class Address
{
    @Column(length = 20, nullable = false)
    private String country;

    @Column(length = 20, nullable = false)
    private String province;

    @Column(length = 20, nullable = false)
    private String city;

    @Column(length = 10, nullable = false)
    private String postalCode;
}
