package constant;

public enum PhoneTypeConstant {
    A("Apple"),
    S("SamSung"),
    O("Oppo");

    public String value;

    PhoneTypeConstant(String value) {
        this.value = value;
    }
}
