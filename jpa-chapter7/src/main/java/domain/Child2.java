package domain;

import javax.persistence.*;

@Entity
@IdClass(Child2Id.class)
public class Child2 {
    @Id
    @ManyToOne
    @JoinColumn(name="PARENT_ID")
    public Parent2 parent;

    @Id
    @Column(name="CHILD_ID")
    private String childId;

    private String name;
}
