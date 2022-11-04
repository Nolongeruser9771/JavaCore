package Exercise04;

public class MyPoint {
    double x;
    double y;

    //Tạo đối tượng mặc định
    public MyPoint() {

    }
    //Tạo đối tượng có toạ độ x, y;
    public MyPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }
    //Tạo đối tượng là bản sao của đối tượng trong tham số
    public MyPoint(MyPoint p) {
        this.x = p.x;
        this.y = p.y;
    }
    //Trả về toạ độ x
    public double getX() {
        return x;
    }
    //Trả về toạ độ y
    public double getY() {
        return y;
    }
    //Trả về khoảng cách từ điểm này tới điểm thứ 2
    public double distance(MyPoint secondpoint) {
        return Math.sqrt(Math.pow((this.x-secondpoint.x),2)+Math.pow((this.y-secondpoint.y),2));
    }
    //Trả về khoảng cách giữa 2 điểm
    public double distance(MyPoint p1, MyPoint p2) {
        return Math.sqrt(Math.pow((p1.x-p2.x),2)+Math.pow((p1.y-p2.y),2));
    }

    @Override
    public String toString() {
        return "MyPoint{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
