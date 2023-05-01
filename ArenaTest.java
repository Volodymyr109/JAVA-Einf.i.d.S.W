/*
Eingaben im Bereich von 0 bis 30 Grad: (0, 1.2), (0.5, 1.3), (1.5, 1.3), (Math.cos(Math.toRadians(15)), Math.sin(Math.toRadians(15)))
Eingaben im Bereich von 30 bis 60 Grad: (1.2, 0), (1.3, 0.5), (1.3, 1.5), (Math.cos(Math.toRadians(45)), Math.sin(Math.toRadians(45)))
Eingaben im Bereich von 60 bis 90 Grad: (0, -1.2), (-0.5, -1.3), (-1.5, -1.3), (Math.cos(Math.toRadians(75)), Math.sin(Math.toRadians(75)))
Eingaben im Bereich von 90 bis 120 Grad: (-1.2, 0), (-1.3, -0.5), (-1.3, -1.5), (Math.cos(Math.toRadians(105)), Math.sin(Math.toRadians(105)))
Eingaben im Bereich von 120 bis 150 Grad: (0, 1.2), (0.5, -1.3), (1.5, -1.3), (Math.cos(Math.toRadians(135)), Math.sin(Math
 */

public class ArenaTest {
    public static void main(String[] args) {
        double[][] tributes = {
                {0, 1.2}, {0.5, 1.3}, {1.5, 1.3}, {Math.cos(Math.toRadians(15)), Math.sin(Math.toRadians(15))},
                {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(45)), Math.sin(Math.toRadians(45))},
                {0, -1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(75)), Math.sin(Math.toRadians(75))},
                {-1.2, 0}, {-1.3, -0.5}, {-1.3, -1.5}, {Math.cos(Math.toRadians(105)), Math.sin(Math.toRadians(105))},
                {0, 1.2}, {0.5, -1.3}, {1.5, -1.3}, {Math.cos(Math.toRadians(135)), Math.sin(Math.toRadians(135))},
                {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(315)), Math.sin(Math.toRadians(315))},
                {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(345)), Math.sin(Math.toRadians(345))}
        };

        for (double[] tribute : tributes) {
            int area = Arena.getArea(tribute[0], tribute[1]);
            System.out.println("(" + tribute[0] + ", " + tribute[1] + ") is in area " + area);
        }
    }
}