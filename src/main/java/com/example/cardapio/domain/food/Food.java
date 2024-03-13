package com.example.cardapio.domain.food;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "foods")
@Table(name = "foods")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Food {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;


    public Food(FoodRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }

}
