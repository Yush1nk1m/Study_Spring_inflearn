package jpabook.jpashop.domain.item;

import jakarta.persistence.*;
import lombok.*;

@Entity
@DiscriminatorValue("A")
@Getter @Setter
public class Album extends Item {

    private String artist;
    private String etc;
}
