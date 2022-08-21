package domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class GrandChildId implements Serializable {
    private Child2Id child;
    private String id;
}
