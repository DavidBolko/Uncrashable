import fri.shapesge.Image;

import java.util.Random;

public class Car {
    private Image carObject;
    private int posX;
    private int posY;
    private int roadLane;
    private boolean isPlayer;

    public Car(int posY, boolean isPlayer, int lane) {
        Random random = new Random();
        this.isPlayer = isPlayer;

        if(this.isPlayer){
            this.roadLane = 2;
            this.posX = 340;
            this.posY = posY;
            this.carObject = new Image("src/resources/carPlayer.png", this.posX, this.posY);
        }
        else{
            this.roadLane = lane;
            switch(roadLane){
                case 1:
                    this.posX = 200;
                break;
                case 2:
                    this.posX = 320;
                break;
                default:
                    this.posX = 420;
                break;
            }

            this.posY = posY;
            this.carObject = new Image("src/resources/car"+ (random.nextInt(3)+1) + ".png", this.posX, this.posY);
        }
        carObject.makeVisible();
    }

    public int getPosX() {
        return this.posX;
    }

    public int getPosY() {
        return this.posY;
    }

    public void moveCarY(int amount){
        this.posY += amount;
        this.carObject.moveVertical(amount);
    }

    public void moveRight(){
        if(this.posX+20 <= 450){
            this.posX += 20;
            this.carObject.moveHorizontal(20);
            if(this.posX >= 200 && this.posX < 260){
                setRoadLane(1);
            }
            else if(this.posX >= 260 && this.posX <= 360){
                setRoadLane(2);
            }
            else{
                setRoadLane(3);
            }
        }
    }

    public void moveLeft(){
        if(this.posX-20 >= 200){
            this.posX -= 20;
            this.carObject.moveHorizontal(-20);
            if(this.posX >= 200 && this.posX < 260){
                setRoadLane(1);
            }
            else if(this.posX >= 260 && this.posX <= 360){
                setRoadLane(2);
            }
            else{
                setRoadLane(3);
            }
        }
    }

    public int getRoadLane() {
        return this.roadLane;
    }

    public void setRoadLane(int lane){
        this.roadLane = lane;
    }

    public void explode(){
        this.carObject.changeImage("src/resources/explosion.png");
    }

    public void destroy(){
        this.carObject.makeInvisible();
    }

}
