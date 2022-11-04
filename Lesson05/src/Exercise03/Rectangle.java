package Exercise03;

public class Rectangle {
    double width;
    double height;
    String color;

    //Tạo HCN chiều dài =1, chiều rộng =1;
    public Rectangle() {
        width =1;
        height=1;
    }
    //Tạo HCN có chiều dài, chiều rộng xác định qua tham số
    public Rectangle(double width, double height, String color) {
        this.width = width;
        this.height = height;
        this.color = color;
    }

    //Trả về chiều rộng
    public double getWidth() {
        return width;
    }
    //thiết lập chiều rộng mới
    public void setWidth(double width) {
        this.width = width;
    }
    //Trả về chiều dài
    public double getHeight() {
        return height;
    }
    //thiết lập chiều dài mới
    public void setHeight(double height) {
        this.height = height;
    }
    //Trả về màu
    public String getColor() {
        return color;
    }
    //thiết lập màu mới
    public void setColor(String color) {
        this.color = color;
    }
    //Tính và trả về diện tích
    public double findArea(){
        return width*height;
    }
    //Tính và trả về chu vi
    public double findPerimeter(){
        return (width+height)*2;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "width=" + width +
                ", height=" + height +
                ", color='" + color + '\'' +
                '}';
    }
}
