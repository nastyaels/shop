package com.eliseeva.shop.goods;

import com.eliseeva.shop.rest.dto.Cake;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Access;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class CustomCakeRepositoryImpl implements CustomCakeRepository{
    @Autowired
    EntityManager em;

    @Override
    public boolean eByName(String name) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<CakeEntity> cq = cb.createQuery(CakeEntity.class);
        Root<CakeEntity> cake = cq.from(CakeEntity.class);
        List<Predicate> predicates = new ArrayList<>();
        if (name != null) {
            predicates.add(cb.equal(cake.get("name"), name));
        }
        cq.where(predicates.toArray(new Predicate[0]));

        return em.createQuery(cq).getResultList().stream().findAny().isPresent();
    }
}
