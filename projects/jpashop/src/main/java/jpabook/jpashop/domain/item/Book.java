package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("B")
@Getter @Setter
public class Book extends Item {

    private String author;
    private String isbn;
}
