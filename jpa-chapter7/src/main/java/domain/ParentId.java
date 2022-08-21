package domain;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;



@Data
@NoArgsConstructor
public class ParentId implements Serializable {
   private String id1;
   private String id2;

    public ParentId(String id1, String id2) {
        this.id1 = id1;
        this.id2 = id2;
    }


}
