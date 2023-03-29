

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double getDistanse(Position anPos){
        double distanse=Math.Sqrt (Math.Pow(this.x - anPos.x, 2) + Math.Pow(this.y - anPos.y, 2));
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

    public void moveRight(){
        this.x=this.x+1;
    }
    public void moveLeft(){
        this.x=this.x-1;
    }
    public void moveUp(){
        this.y=this.y+1;
    }
    public void moveDown(){
        this.y=this.y-1;
    }

    public override bool Equals(object? obj)
    {
        return obj is Position position &&
               x == position.x &&
               y == position.y;
    }


}