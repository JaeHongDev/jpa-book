package domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Orders {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Delivery delivery;

    private String orderState;
    private String status;
}
