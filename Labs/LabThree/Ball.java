import java.awt.*;

public class Ball {
    private double xPos, yPos, xVelo, yVelo;
    private int radius, width, height;
    private Color ballColor;

    public Ball(double x, double y, double xv, double yv, int r, Color c, int w, int h) {
        if (x <= w && x >= 0 && y <= h && y >= 0) {
            this.xPos = x;
            this.yPos = y;
        } else {
            this.xPos = 0;
            this.yPos = 0;
        }

        this.xVelo = xv;
        this.yVelo = yv;
        this.ballColor = c;
        this.radius = r;
        this.width = w;
        this.height = h;

    }

    public double getX() {
        return xPos;
    }

    public double getY() {
        return yPos;
    }

    public double getVx() {
        return xVelo;
    }

    public double getVy() {
        return yVelo;
    }

    public int getRadius() {
        return radius;
    }

    public Color getColor() {
        return ballColor;
    }

    public void setX(double x1) {
        xPos = x1;
    }

    public void setY(double y1) {
        yPos = y1;
    }

    public void setVx(double vx1) {
        xVelo = vx1;
    }

    public void setVy(double vy1) {
        yVelo = vy1;
    }

    public void setRadius(int r1) {
        radius = r1;
    }

    public void setColor(Color c1) {
        ballColor = c1;
    }

    public void update() {
        xPos += xVelo;
        yPos += yVelo;
        if (xPos + 2 * radius > width || xPos < 0) {
            xVelo *= -1;
            // if (xPos + 2 * radius > width) {
            // xPos = width;
            // } else if (xPos < 0) {
            // xPos = 0;
            // }
        }
        if (yPos + 2 * radius > height || yPos < 0) { // if its reached a wall)
            // System.out.println("UNDER WALL");
            // System.out.println("yVelo before" + yVelo);
            yVelo *= -1;

            // if (yPos + 2 * radius > height) {
            // yPos = height;
            // } else if (yPos < 0) {
            // yPos = 0;
            // }
        }
    }

    public void draw(Graphics g) {
        g.setColor(ballColor);
        g.fillOval((int) xPos, (int) yPos, radius * 2, radius * 2);

    }

    public void updateBoundaries(int a, int b) {
        width = a;
        height = b;
    }
}
