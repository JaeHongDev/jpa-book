package domain;

import javax.persistence.*;

@Entity
@IdClass(MemberProductId.class)
public class MemberProduct {
    @Id
    @ManyToOne
    @JoinColumn(name="Member_Id")
    private Member member; // memberProductId. member connect

    @Id
    @ManyToOne
    @JoinColumn(name="Product_Id")
    private Product product; // memberProductId. product connect

    private int orderAmount;
}
