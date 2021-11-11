package com.demo.Icommerce.domain.product.entity;

import com.demo.Icommerce.infrastructure.payload.BaseEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "PRODUCT")
@Getter
@Setter
@NoArgsConstructor
public class Product extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column
    private Long productId;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private BigDecimal price;

    @ManyToOne(fetch = FetchType.LAZY)
    private Category category;

    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(name, product.name) && Objects.equals(price, product.price) && Objects.equals(category, product.category);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, category);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", category=" + category +
                '}';
    }
}
