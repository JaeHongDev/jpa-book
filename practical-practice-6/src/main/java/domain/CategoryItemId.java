package domain;


import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryItemId implements Serializable {
    private Long category;
    private Long item;
}
