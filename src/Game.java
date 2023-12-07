import fri.shapesge.FontStyle;
import fri.shapesge.Manager;
import fri.shapesge.TextBlock;

public class Game {

    private Manager manager;
    private Player player;
    private CarSpawner carSpawner;
    public Game() {
        new Road();

        this.manager = new Manager();
        this.player = new Player();

        CollisionSystem collisionSystem = new CollisionSystem(this);
        this.carSpawner = new CarSpawner(player, collisionSystem);

        manager.manageObject(carSpawner);
        manager.manageObject(player.getCarPlayer());
    }

    public void gameOver(){
        TextBlock t = new TextBlock("GAME OVER", 250, 150);
        t.changeFont("Serif", FontStyle.BOLD, 30);
        t.changeColor("red");
        t.makeVisible();

        manager.stopManagingObject(carSpawner);
        manager.stopManagingObject(player.getCarPlayer());
    }
}
