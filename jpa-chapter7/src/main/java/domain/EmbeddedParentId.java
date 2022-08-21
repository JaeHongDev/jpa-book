package domain;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import java.io.Serializable;

@Data
@Embeddable
public class EmbeddedParentId implements Serializable {
    private static final long serialVersionUID = -8294320056763489172L;
    @Column(name="PARENT_ID1")
    private String id1;
    @Column(name="PARENT_ID2")
    private String id2;

}
