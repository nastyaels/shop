package com.eliseeva.shop.orders;
import com.eliseeva.shop.purchase.PurchaseEntity;
import com.eliseeva.shop.users.UserEntity;
import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "ABOUTORDER")
public class OrderEntity {
    @Setter(AccessLevel.NONE)
    private @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) Long id;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    private UserEntity user;

    @Setter(AccessLevel.PROTECTED)
    @ToString.Exclude
    @OneToMany(mappedBy = "order",fetch = FetchType.LAZY,cascade = CascadeType.ALL,orphanRemoval = true)
    private List<PurchaseEntity> purchases;

    @Setter(AccessLevel.PROTECTED)
    private Deliveries delivery;

    @Setter(AccessLevel.PROTECTED)
    private OrderStatuses status;

    @Setter(AccessLevel.PROTECTED)
    private Payment payment;

    @Setter(AccessLevel.PROTECTED)
    private String deliveryAddress;

    @Setter(AccessLevel.PROTECTED)
    private LocalDateTime deliveryTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        OrderEntity that = (OrderEntity) o;
        return id != null && Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
