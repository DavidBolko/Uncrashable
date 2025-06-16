public class MainWindow {
    private MainMenu mainMenu;
    private boolean isGameRunning;
    public MainWindow() {
        this.isGameRunning = false;
        this.mainMenu = new MainMenu(this);

        this.run();
    }

    public void run(){
        if(isGameRunning){
            this.mainMenu.close();
            Game game = new Game();
        }
        else{
            this.mainMenu.show();
        }
    }

    public void setGameRunning(boolean value) {
        isGameRunning = value;
        this.run();
    }
}
