package domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Item {
    @Id
    @Column(name="Item_id")
    @GeneratedValue
    private Long id;

    private String name;
    private Long price;

    private int stockQuantity;

}
