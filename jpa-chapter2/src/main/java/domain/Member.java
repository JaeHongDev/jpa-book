package domain;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@ToString
@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name="MEMBER")
public class Member {

    @Id
    @Column(name="ID")
    private String id;

    @Column(name="NAME")
    private String username;

    private Integer age;

    @Builder
    public Member(String id, String username, Integer age) {
        this.id       = id;
        this.username = username;
        this.age      = age;
    }
}
