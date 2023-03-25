package homework06.Additional;

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
   
    public boolean isEquals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Position other = (Position) obj;
        if (x != other.x)
            return false;
        if (y != other.y)
            return false;
        return true;
    }
}
