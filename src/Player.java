import javax.swing.*;

public class Player {
    private Car car;
    private int score;
    private String name;
    public Player() {
        this.car = new Car( 480,true, 2);
        this.score = 0;
        this.name = "";

        while(this.name.isEmpty()){
            this.name = JOptionPane.showInputDialog("Input your username");
        }
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

    public void destroyPlayer(){
        this.car.destroy();
    }
}
