package constant;

public enum PhoneStatusConstant {
    TYPE1("Thân máy, màn hình không bị trầy xước & chức năng hoạt động tốt"),
    TYPE2("Màn hình đẹp, thân máy trầy xước 3 vết và chức năng hoạt động tốt"),
    TYPE3("Trầy xước nặng và có lỗi chức năng máy"),
    TYPE4("Màn hình âm ảnh nhẹ, không dính iCloud, KNOX"),
    TYPE5("Màn hình âm ảnh nặng, máy dính iCloud, KNOX");

    public String value;

    PhoneStatusConstant(String value) {
        this.value = value;
    }
}
