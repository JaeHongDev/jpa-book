package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Setter
@Getter
@Entity
@IdClass(ParentId.class)
public class Parent {
    @Id
    @Column(name="PARENT_ID1")
    private String id1;

    @Id
    @Column(name="PARENT_ID2")
    private String id2;
    private String name;
}
