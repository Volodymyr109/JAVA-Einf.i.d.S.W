/*
Eingaben im Bereich {0, 1.2}, {0.5, 1.3}, {1.5, 1.3}, {Math.cos(Math.toRadians(15)), Math.sin(Math.toRadians(15))}, //1
                    {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(45)), Math.sin(Math.toRadians(45))}, //2
                    {0, -1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(75)), Math.sin(Math.toRadians(75))}, //3
                    {-1.2, 0}, {-1.3, -0.5}, {-1.3, -1.5}, {Math.cos(Math.toRadians(105)), Math.sin(Math.toRadians(105))}, //4
                    {0, 1.2}, {0.5, -1.3}, {1.5, -1.3}, {Math.cos(Math.toRadians(135)), Math.sin(Math.toRadians(135))}, //5
                    {-1.2, 0}, {-1.3, -0.5}, {-1.3, -1.5}, {Math.cos(Math.toRadians(175)), Math.sin(Math.toRadians(175))}, //6
                    {0, 1.2}, {0.5, -1.3}, {1.5, -1.3}, {Math.cos(Math.toRadians(205)), Math.sin(Math.toRadians(205))}, //7
                    {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(235)), Math.sin(Math.toRadians(235))}, //8
                    {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(265)), Math.sin(Math.toRadians(265))}, //9
                    {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(295)), Math.sin(Math.toRadians(295))}, //10
                    {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(315)), Math.sin(Math.toRadians(315))}, //11
                    {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(345)), Math.sin(Math.toRadians(345))}, //12
 */

public class ArenaTest {
    public static void main(String[] args) {
        double[][] tributes = {
                {0, 1.2}, {0.5, 1.3}, {1.5, 1.3}, {Math.cos(Math.toRadians(15)), Math.sin(Math.toRadians(15))}, //1
                {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(45)), Math.sin(Math.toRadians(45))}, //2
                {0, -1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(75)), Math.sin(Math.toRadians(75))}, //3
                {-1.2, 0}, {-1.3, -0.5}, {-1.3, -1.5}, {Math.cos(Math.toRadians(105)), Math.sin(Math.toRadians(105))}, //4
                {0, 1.2}, {0.5, -1.3}, {1.5, -1.3}, {Math.cos(Math.toRadians(135)), Math.sin(Math.toRadians(135))}, //5
                {-1.2, 0}, {-1.3, -0.5}, {-1.3, -1.5}, {Math.cos(Math.toRadians(175)), Math.sin(Math.toRadians(175))}, //6
                {0, 1.2}, {0.5, -1.3}, {1.5, -1.3}, {Math.cos(Math.toRadians(205)), Math.sin(Math.toRadians(205))}, //7
                {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(235)), Math.sin(Math.toRadians(235))}, //8
                {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(265)), Math.sin(Math.toRadians(265))}, //9
                {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(295)), Math.sin(Math.toRadians(295))}, //10
                {1.2, 0}, {1.3, 0.5}, {1.3, 1.5}, {Math.cos(Math.toRadians(315)), Math.sin(Math.toRadians(315))}, //11
                {0, 1.2}, {-0.5, -1.3}, {-1.5, -1.3}, {Math.cos(Math.toRadians(345)), Math.sin(Math.toRadians(345))}, //12
        };

        for (double[] tribute : tributes) {
            int area = Arena.getArea(tribute[0], tribute[1]);
            System.out.println("( x: " + tribute[0] + ", y: " + tribute[1] + ") nicht aktiv in Area: " + area);
        }
    }
}
