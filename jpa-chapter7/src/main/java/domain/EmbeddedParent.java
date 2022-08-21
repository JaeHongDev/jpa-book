package domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class EmbeddedParent {
    @EmbeddedId
    private EmbeddedParentId id;

    private String name;
}
