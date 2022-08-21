package domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.criteria.internal.predicate.MemberOfPredicate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Member {
    @Id
    private String id;

    private String username;

    @ManyToOne
    @JoinColumn(name = "team_ID")
    private Team team;

    @OneToOne
    @JoinColumn(name="LOCKER_ID")
    private Locker locker;

    @ManyToMany
    @JoinTable(name="MEMBER_PRODUCT", joinColumns = @JoinColumn(name="MEMBER_ID"),
        inverseJoinColumns = @JoinColumn(name="PRODUCT_ID")
    )
    private List<Product> products = new ArrayList<Product>();

    @OneToMany(mappedBy = "member")
    private List<MemberProduct> memberProducts;
    public void setTeam(Team team){
        this.team = team;
        if(!this.team.getMembers().contains(this)){
            team.getMembers().add(this);
        }
    }
    public void addProduct(Product product){
        products.add(product);
        product.getMembers().add(this);
    }
}
