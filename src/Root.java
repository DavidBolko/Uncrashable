public class Root {
    private MainMenu mainMenu;
    private Game game;
    private boolean isGameRunning;
    public Root() {
        this.isGameRunning = false;
        this.mainMenu = new MainMenu(this);
        this.game = new Game(this);

        this.run();
    }

    public void run(){
        isGameRunning = false;
        this.mainMenu.show();
    }

    public void runGame(Difficulty difficulty){
        isGameRunning = true;
        this.mainMenu.close();
        this.game.setDifficulty(difficulty);
        this.game.startGame();
    }

    public boolean isGameRunning(){
        return this.isGameRunning;
    }
}
