package com.eliseeva.shop.goods;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "CAKE")
public class CakeEntity {
    @Setter(AccessLevel.PROTECTED)
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @Column(name = "name")
    private String name;

    @Setter(AccessLevel.PROTECTED)
    private BigDecimal calories;

    @Setter(AccessLevel.PROTECTED)
    private String image;

    @Setter(AccessLevel.PROTECTED)
    private BigDecimal price;

    @Setter(AccessLevel.PROTECTED)
    private BigDecimal weight;

    @Setter(AccessLevel.PROTECTED)
    private String ingredients;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        CakeEntity that = (CakeEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
