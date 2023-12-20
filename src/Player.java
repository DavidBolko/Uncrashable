import javax.swing.JOptionPane;

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
    public Car getCar() {
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

    public String getInformation(){
        String medal;
        if(this.score >= 0 && this.score <= 20){
            medal = "BRONZE";
        } else if(this.score > 20 && this.score <= 50){
            medal = "SILVER";
        }
        else if(this.score > 50 && this.score <= 100){
            medal = "GOLD";
        }
        else if(this.score > 100 && this.score <= 200){
            medal = "EMERALD";
        }
        else{
            medal = "DIAMOND";
        }
        return String.format("%s:%d:%s", this.name, this.score, medal);
    }
}
