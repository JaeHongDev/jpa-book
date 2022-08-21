package domain;

import javax.persistence.*;


@Entity
@IdClass(CategoryItemId.class)
public class CategoryItem {

    @Id
    @JoinColumn(name="CATEGORY_ID")
    @ManyToOne
    private Category category;

    @Id
    @JoinColumn(name="ITEM_ID")
    @ManyToOne
    private Item item;



}
