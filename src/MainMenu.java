import com.formdev.flatlaf.FlatDarkLaf;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu implements ActionListener {
    private Root root;
    private JPanel mainMenu;
    private JLabel image;

    private JButton startButton;
    private JButton leaderboardButton;
    private JButton quitButton;
    private JComboBox<Difficulty> difficultyOptions;

    public MainMenu(Root root){
        this.root = root;

        this.mainMenu = new JPanel();
        this.mainMenu.setLayout(new BoxLayout(mainMenu, BoxLayout.Y_AXIS));
        this.mainMenu.setMinimumSize(new Dimension(800, 600));
        this.mainMenu.setMaximumSize(new Dimension(800, 600));
        this.mainMenu.setBackground(Color.BLACK);

        this.image = new JLabel();
        BufferedImage image = loadImage("src/resources/semestralka.png");
        this.image.setIcon(new ImageIcon(image));
        this.image.setAlignmentX(Component.CENTER_ALIGNMENT);

        this.mainMenu.add(this.image);
        this.constructControls();
        this.mainMenu.setBackground(Color.BLACK);
    }

    private BufferedImage loadImage(String path){
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return image;
    }

    private void constructControls() {
        this.startButton = new JButton("Start");
        this.leaderboardButton = new JButton("Leadeboard");
        this.quitButton = new JButton("Quit");

        startButton.setPreferredSize(new Dimension(100, 20));
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        startButton.addActionListener(this);

        leaderboardButton.setPreferredSize(new Dimension(100, 20));
        leaderboardButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        leaderboardButton.addActionListener(this);

        quitButton.setPreferredSize(new Dimension(100, 20));
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(this);


        this.difficultyOptions = new JComboBox<>(Difficulty.values());
        this.difficultyOptions.addActionListener(this);
        this.mainMenu.add(difficultyOptions);
        this.mainMenu.add(Box.createVerticalStrut(2));
        this.mainMenu.add(startButton);
        this.mainMenu.add(Box.createVerticalStrut(2));
        this.mainMenu.add(leaderboardButton);
        this.mainMenu.add(Box.createVerticalStrut(2));
        this.mainMenu.add(quitButton);
        this.mainMenu.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            if (!root.isGameRunning()){
                this.root.runGame((Difficulty)difficultyOptions.getSelectedItem());
            } else{
                this.root.run();
            }
        } else if (e.getSource() == this.leaderboardButton) {
            this.root.showLeaders();
        }
        else if (e.getSource() == this.quitButton) {
            System.exit(0);
        }
    }

    public JPanel getMainMenu(){
        return this.mainMenu;
    }

}
