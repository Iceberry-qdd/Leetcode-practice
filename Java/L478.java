import java.util.Random;

public class L478 {
    public static void main(String[] args) {

    }

    private double radius;
    private double x_center;
    private double y_center;
    Random random = new Random();

    public L478(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        while (true) {
            double randomX = random.nextDouble() * (radius * 2) - radius;
            double randomY = random.nextDouble() * (radius * 2) - radius;
            if (randomX * randomX + randomY * randomY <= radius * radius) {
                return new double[]{randomX + x_center, randomY + y_center};
            }
        }
    }
}
