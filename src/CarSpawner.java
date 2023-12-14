import java.util.ArrayList;
import java.util.Random;

public class CarSpawner {
    private ArrayList<Car> cars;
    private Player player;
    private Game game;

    public CarSpawner(Player player, Game game) {
        this.game = game;
        this.player = player;

        this.cars = new ArrayList<Car>();
        this.addCar();
        this.addCar();
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


    public void tik(){
        Car carWhichLeftScreen = null;
        for (Car car : this.cars) {
            if(car.getRoadLane() == 1){
                car.moveCarY((int)( 8 * this.game.getDifficulty().getValue()));
                if(car.getPosY()>600){
                    carWhichLeftScreen = car;
                }
            }
            else if(car.getRoadLane() == 2){
                car.moveCarY((int)( 6 * this.game.getDifficulty().getValue()));
                if(car.getPosY()>600){
                    carWhichLeftScreen = car;
                }
            }
            else{
                car.moveCarY((int)( 4 * this.game.getDifficulty().getValue()));
                if(car.getPosY()>600){
                    carWhichLeftScreen = car;
                }
            }
            CollisionSystem.detectCollision(car, player, this.game);
        }
        if(carWhichLeftScreen != null){
            this.game.updateScore();

            carWhichLeftScreen.destroy();
            this.cars.remove(carWhichLeftScreen);
            this.addCar();
        }
    }

    public void destroyCars(){
        for (Car car : this.cars) {
            car.destroy();
        }
    }
}
