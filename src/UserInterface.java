import fri.shapesge.FontStyle;
import fri.shapesge.TextBlock;

public class UserInterface {
    private TextBlock scoreDisplay;
    private Game game;
    private TextBlock gameOverText;
    public UserInterface(Game game) {

        this.game = game;
        this.gameOverText = new TextBlock("GAME OVER!", 250, 100);

        this.scoreDisplay = new TextBlock(String.valueOf(this.game.getPlayer().getScore()), 750, 50);
        this.scoreDisplay.changeFont("Serif", FontStyle.BOLD, 30);
        this.scoreDisplay.changeColor("blue");
        this.scoreDisplay.makeVisible();
    }

    public void showGameOverText(){
        this.gameOverText.changeFont("Serif", FontStyle.BOLD, 30);
        this.gameOverText.changeColor("red");
        this.gameOverText.makeVisible();
    }

    public void updateScore(){
        scoreDisplay.changeText(String.valueOf(this.game.getPlayer().getScore()));
    }

    public void destroyUI(){
        this.scoreDisplay.makeInvisible();
        this.gameOverText.makeInvisible();
    }

}
