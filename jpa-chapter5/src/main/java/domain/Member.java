package domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {
    public Member(String id, String username) {
        this.id       = id;
        this.username = username;
    }

    @Id
    @Column(name="MEMBER_ID")
    private String id;
    private String username;

    @ManyToOne
    private Team team;

    public void setTeam(Team team){
        this.team = team;
    }

}
