package domain;

import java.io.Serializable;
import java.util.Objects;

public class MemberProductId implements Serializable {
    private String member ; // connect MemberProduct.member
    private String product; // connect MemberProduct.product

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberProductId that = (MemberProductId) o;
        return Objects.equals(member, that.member) && Objects.equals(product, that.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(member, product);
    }
}
