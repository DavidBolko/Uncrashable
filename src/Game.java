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
        manager.manageObject(player.getCar());
    }

    public void setDifficulty(Difficulty difficulty){
        this.difficulty = difficulty;
    }


    public void gameOver(){
        this.manager.stopManagingObject(this);
        this.manager.stopManagingObject(carSpawner);
        this.manager.stopManagingObject(player.getCar());

        new Thread(()->{
            try {
                Thread.sleep(1000);

                player.destroyPlayer();
                carSpawner.destroyCars();
                road.destroyRoad();
                this.userInterface.hideScore();

                this.userInterface.showGameOverText();

                FileManager.savePlayer(player.getInformation());
                root.run();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Thread.currentThread().interrupt();
        }).start();
    }


    public void updateScore(){
        this.player.setScore(this.player.getScore()+1);
        System.out.println(player.getScore());
        this.userInterface.updateScore();
    }

    public Player getPlayer() {
        return player;
    }

    public Difficulty getDifficulty() {
        return this.difficulty;
    }
}
