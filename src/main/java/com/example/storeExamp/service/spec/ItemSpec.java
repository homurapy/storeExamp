package com.example.storeExamp.service.spec;

import com.example.storeExamp.model.Item;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Objects;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ItemSpec {

    public static Specification<Item> nameEq(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("name"), name);
    }

    public static Specification<Item> nameLike(String name) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), "%" + name + "%");
    }

    public static Specification<Item> priceLess(Integer price) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThan(root.get("price"), price);
    }
    public static Specification<Item> build(Map<String, String> params) {
        return params.entrySet().stream()
                .filter(it-> StringUtils.hasText(it.getValue()))
                .map(it -> {
                    if ("name".equals(it.getKey())) {
                        return ItemSpec.nameEq(it.getValue());
                    }
                    if ("price".equals(it.getKey())) {
                        return ItemSpec.priceLess(Integer.parseInt(it.getValue()));
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .reduce(Specification::and)
                .orElse(null);
    }
}
