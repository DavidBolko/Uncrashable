import java.util.ArrayList;
import java.util.Random;

public class CarSpawner {
    private ArrayList<Car> cars;
    private CollisionSystem collisionSystem;
    private Player player;

    public CarSpawner(Player player, CollisionSystem collisionSystem) {
        this.collisionSystem = collisionSystem;
        this.player = player;

        this.cars = new ArrayList<Car>();
        this.randomizeCars();
    }

    public void randomizeCars(){
        Random random = new Random();
        this.cars.add(new Car(random.nextInt(400)-400, false, random.nextInt(3)+1));
        for (int i = 1; i < 3; i++) {
            int nextPosY = random.nextInt(350) - 400;
            int nextLane = random.nextInt(3)+1;

            Car firstCar = this.cars.get(0);

            if(firstCar.getRoadLane() == nextLane){
                if(Math.abs(firstCar.getPosY() - nextPosY) < 100){
                    System.out.println("Prve auto zavadzalo" + nextPosY);
                    if((nextPosY + 180) + 400 < 450){
                        nextPosY += 180;
                    }
                    else{
                        System.out.println("Zmena pruhu");
                        if(nextLane == 3){
                            nextLane--;
                        }
                        else{
                            nextLane++;
                        }
                    }
                }
            }
            if(i > 1){
                if(this.cars.get(1).getRoadLane() == nextLane){
                    if(Math.abs(this.cars.get(1).getPosY() - nextPosY) < 100){
                        System.out.println("Druhe auto zavadzalo" + nextPosY);
                        if((nextPosY + 180) + 400 < 450){
                            nextPosY += 180;
                        }
                        else{
                            System.out.println("Zmena pruhu");
                            if(nextLane == 3){
                                nextLane--;
                            }
                            else{
                                nextLane++;
                            }
                        }
                    }
                }
            }

            this.cars.add(new Car(nextPosY, false, nextLane));
        }
    }

    public void tik(){
        for (Car car : this.cars) {
            if(car.getRoadLane() == 1){
                car.moveCarY(4);
            }
            else if(car.getRoadLane() == 2){
                car.moveCarY(8);
            }
            else{
                car.moveCarY(6);
            }
            this.collisionSystem.detectCollision(car, player);
        }
    }
}
