package domain.shop;


import javax.persistence.*;

@Entity
@Table(name="shop_item")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    private Long id;

    private String name;
    private Long price;
    private int stockQuantity;
}
