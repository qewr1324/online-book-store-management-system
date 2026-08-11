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
 * 
 * <p>The address class is a non-entity class
 * and is added to models as an embedded class.</p>
 * 
 * <p><strong>Example:</strong>
 * <pre>
 * {@code public class Example extends BaseModel<Long> {
 *      @Embedded
 *      private Address address;
 * 
 *      // Other Properties ...
 * }
 * }
 * </pre>
 * </p>
 * @since 1405
 * @author GhurbeSABZI
 * @version 1.0.0
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
