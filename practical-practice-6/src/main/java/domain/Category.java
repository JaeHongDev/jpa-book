package domain;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @Column(name="category_id")
    @GeneratedValue
    private Long id;

    @ManyToOne
    private Category parent;

    private String name;
}
