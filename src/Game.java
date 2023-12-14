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
    }

    public void startGame(){
        this.road = new Road();
        this.player = new Player();
        this.carSpawner = new CarSpawner(player, this);
        this.userInterface = new UserInterface(this);
        this.manager = new Manager();


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

        this.endGame();
    }

    public void updateScore(){
        this.player.setScore(this.player.getScore()+1);
        this.userInterface.updateScore();
    }

    public Player getPlayer() {
        return player;
    }

    public void endGame(){
        this.manager.stopManagingObject(this);
        this.manager.stopManagingObject(carSpawner);
        this.manager.stopManagingObject(player.getCarPlayer());

        root.run();
        player.destroyPlayer();
        carSpawner.destroyCars();
        road.destroyRoad();
        userInterface.destroyUI();
    }

    public boolean gameRunning(){
        return root.isGameRunning();
    }

    public Manager getManager() {
        return this.manager;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
}
