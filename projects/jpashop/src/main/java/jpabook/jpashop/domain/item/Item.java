package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import jpabook.jpashop.domain.Category;
import jpabook.jpashop.exception.NotEnoughStockException;
import lombok.*;

import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "dtype")
@Getter @Setter
public class Item {

    @Id
    @GeneratedValue
    @Column(name = "item_id")
    private Long id;

    private String name;
    private Integer price;
    private Integer stockQuantity;

    @ManyToMany(mappedBy = "items")
    private List<Category> categories = new ArrayList<>();

    // == 비즈니스 로직 == //

    // stock 증가
    public void addStock(int quantity) {
        this.stockQuantity += quantity;
    }

    // stock 감소
    public void removeStock(int quantity) {
        int leftStock = this.stockQuantity - quantity;
        if (leftStock < 0) {
            throw new NotEnoughStockException("Not enough stock");
        }
        this.stockQuantity = leftStock;
    }
}

