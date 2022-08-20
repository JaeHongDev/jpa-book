package domain.shop;

import javax.persistence.*;

@Entity
@Table(name="shop_order_item")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="order_item_id")
    private Long id;

    private Long price;
    private int count;

    @ManyToOne
    private Orders orders;
    @ManyToOne
    private Item item;
}
