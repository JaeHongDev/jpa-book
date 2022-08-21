package domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Member {
    @Id
    @GeneratedValue
    private Long id;
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;

}
