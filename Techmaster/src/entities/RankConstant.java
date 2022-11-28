package entities;

public enum RankConstant {
    XS("Xuất Sắc"),
    G("Giỏi"),
    K("Khá"),
    TB("Trung Bình"),
    Y("Yếu"),
    KEM("Kém");

    public String value;

    RankConstant(String value) {
        this.value = value;
    }
}
