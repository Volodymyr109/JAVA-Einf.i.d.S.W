public class Arena {
    private static final double RADIUS = 1.5;
    private static final double ANGLE_INCREMENT = 30.0;

    public static int getArea(double x, double y) {
        double distance = Math.sqrt(x*x + y*y);
        if (distance > RADIUS) {
            return -1;
        } else {
            double angle = Math.toDegrees(Math.atan2(y, x));
            if (angle < 0) {
                angle += 360;
            }
            int area = (int) Math.floor(angle / ANGLE_INCREMENT);
            return area;
        }
    }
}