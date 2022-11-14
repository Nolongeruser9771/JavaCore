package Constant;

public enum ProductGroupConstant {
    DT("Điện tử"),
    DL("Điện lạnh"),
    MT("Máy tính"),
    TBVP("Thiết bị văn phòng");

    public String value;

    ProductGroupConstant(String value) {
        this.value = value;
    }
}
