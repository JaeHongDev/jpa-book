import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Getter
@Setter
@NoArgsConstructor
@ToString
@DynamicUpdate
@Entity
@Table(name = "MEMBER")
public class Member {
    @Id
    @Column(name="ID")
    private String id;

    @Column(name="name")
    private String name;

    private Integer age;

    @Builder
    public Member(String id, String name, Integer age) {
        this.id   = id;
        this.name = name;
        this.age  = age;
    }
}
