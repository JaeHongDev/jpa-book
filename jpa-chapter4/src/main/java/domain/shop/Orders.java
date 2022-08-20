package domain.shop;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="shop_orders")
public class Orders{
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="order_id")
    private Long id;

   @Temporal(TemporalType.TIMESTAMP)
    private Date ordersDate;

   private String status;

   @ManyToOne
    private Member member;
}
