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
        this.addCar();
        this.addCar();
        this.addCar();
    }

    public void addCar(){
        Random r = new Random();
        if(this.cars.isEmpty()){
            int newPosY = r.nextInt(400)-600;
            this.cars.add(new Car(newPosY, false, r.nextInt(3)+1));
        }
        else{
            int nextLane = r.nextInt(3)+1;
            int newPosY = r.nextInt(400)-600;
            for (Car car : this.cars) {
                if(car.getRoadLane() == nextLane){
                    if((car.getPosY() - newPosY) < 100){
                        if((newPosY + 180) < 450){
                            newPosY += 180;
                        }
                        else{
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
            this.cars.add(new Car(newPosY, false, nextLane));
        }
    }


    /*
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
    */


    public void tik(){
        Car carWhichLeftScreen = null;
        for (Car car : this.cars) {
            if(car.getRoadLane() == 1){
                car.moveCarY(4);
                if(car.getPosY()>600){
                    carWhichLeftScreen = car;
                }
            }
            else if(car.getRoadLane() == 2){
                car.moveCarY(8);
                if(car.getPosY()>600){
                    carWhichLeftScreen = car;
                }
            }
            else{
                car.moveCarY(6);
                if(car.getPosY()>600){
                    carWhichLeftScreen = car;
                }
            }
            this.collisionSystem.detectCollision(car, player);
        }
        if(carWhichLeftScreen != null){
            carWhichLeftScreen.destroy();
            this.cars.remove(carWhichLeftScreen);
            carWhichLeftScreen = null;
            this.addCar();
        }
    }
}
