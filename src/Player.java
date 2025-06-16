public class Player {
    private Car car;
    private int score;
    public Player() {
        this.car = new Car( 480,true, 2);
    }
    public Car getCarPlayer() {
        return this.car;
    }

    public int getScore() {
        return this.score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
