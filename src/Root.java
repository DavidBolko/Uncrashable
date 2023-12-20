import com.formdev.flatlaf.FlatDarkLaf;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

public class Root {
    private MainMenu mainMenu;
    private JFrame rootWindow;
    private Leaderboard leaderBoard;
    private Game game;
    private boolean isGameRunning;
    public Root() {
        FlatDarkLaf.setup();

        this.rootWindow = new JFrame();
        this.rootWindow.setLayout(new GridBagLayout());
        this.rootWindow.setMinimumSize(new Dimension(800, 600));
        this.rootWindow.setMaximumSize(new Dimension(800, 600));
        this.rootWindow.getContentPane().setBackground(Color.black);
        this.rootWindow.setAutoRequestFocus(false);

        this.isGameRunning = false;
        this.mainMenu = new MainMenu(this);
        this.leaderBoard = new Leaderboard(this);
        this.game = new Game(this);
        this.run();
    }

    public void run(){
        this.isGameRunning = false;
        this.rootWindow.remove(this.leaderBoard.getLeaderBoard());
        this.rootWindow.add(this.mainMenu.getMainMenu());
        this.rootWindow.revalidate();
        this.rootWindow.repaint();
        this.rootWindow.setVisible(true);
    }
    public void showLeaders(){
        this.rootWindow.remove(this.mainMenu.getMainMenu());
        this.leaderBoard.updateLeaderBoard();
        this.rootWindow.add(this.leaderBoard.getLeaderBoard());
        this.rootWindow.revalidate();
        this.rootWindow.repaint();
    }
    public void runGame(Difficulty difficulty){
        isGameRunning = true;
        this.rootWindow.setVisible(false);
        this.game.setDifficulty(difficulty);
        this.game.startGame();
    }

    public boolean isGameRunning(){
        return this.isGameRunning;
    }
}
