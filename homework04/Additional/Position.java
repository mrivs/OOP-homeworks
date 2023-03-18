package homework04.Additional;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistanse(Position anPos){
        double distanse=Math.sqrt(Math.pow(this.x - anPos.x, 2) + Math.pow(this.y - anPos.y, 2));
        return distanse;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
