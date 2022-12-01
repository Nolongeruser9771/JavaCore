package entities;

import java.time.LocalDate;

public class MemberOrder extends Order {
    private Member member;

    public MemberOrder(LocalDate orderDate, Product product, int quantity, Member member) {
        super(orderDate, product, quantity);
        this.total = quantity* product.getPrice()- member.getRewardPoint();
        this.member = member;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "MemberOrder{" +
                "id=" + id +
                ", orderDate=" + orderDate +
                ", member=" + member +
                ", product=" + product +
                ", quantity=" + quantity +
                ", total=" + total +
                '}';
    }
}
