import com.formdev.flatlaf.FlatDarkLaf;

import javax.swing.*;
import java.awt.*;

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
        this.rootWindow.validate();
        this.rootWindow.repaint();
        this.rootWindow.setVisible(true);
    }
    public void showLeaders(){
        this.rootWindow.remove(this.mainMenu.getMainMenu());
        this.rootWindow.add(this.leaderBoard.getLeaderBoard());
        this.rootWindow.validate();
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
