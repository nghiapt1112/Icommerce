package com.demo.Icommerce.domain.product.entity;

import com.demo.Icommerce.infrastructure.payload.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "CATEGORY")
@Getter
@Setter
public class Category extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long categoryId;

    @Column
    private String name;

    @OneToMany(
            mappedBy = "category",
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private Set<Product> product = new LinkedHashSet<>();

    @Override
    public String toString() {
        return "Category{" +
                "categoryId=" + categoryId +
                ", name='" + name + '\'' +
                '}';
    }
}
