import fri.shapesge.Manager;

public class Game {

    private Manager manager;
    private Player player;
    private CarSpawner carSpawner;
    private UserInterface userInterface;
    private Difficulty difficulty;
    private Root root;
    private Road road;

    public Game(Root root) {
        this.root = root;
        this.manager = new Manager();
    }

    public void startGame(){
        this.road = new Road();
        this.player = new Player();
        this.carSpawner = new CarSpawner(player, this);
        this.userInterface = new UserInterface(this);


        System.out.println(this.difficulty);
        manager.manageObject(carSpawner);
        manager.manageObject(this);
        manager.manageObject(player.getCarPlayer());
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }


    public void gameOver(){
        this.userInterface.showGameOverText();

        manager.stopManagingObject(carSpawner);
        manager.stopManagingObject(player.getCarPlayer());
    }

    public void updateScore(){
        this.player.setScore(this.player.getScore()+1);
        this.userInterface.updateScore();
    }

    public Player getPlayer() {
        return player;
    }

    public void endGame(){
        this.manager.stopManagingObject(carSpawner);
        this.manager.stopManagingObject(player.getCarPlayer());
        this.manager.stopManagingObject(this);
        this.manager = null;

        player.destroyPlayer();
        carSpawner.destroyCars();
        road.destroyRoad();
        userInterface.destroyUI();
        root.run();
    }
}
