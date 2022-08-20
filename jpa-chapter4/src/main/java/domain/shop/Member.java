package domain.shop;

import javax.persistence.*;

@Entity
@Table(name="shop_member")
public class Member {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name="member_id")
   private Long memberId;

   private String name;

   private String city;
   private String street;
   private String zipCode;
}
