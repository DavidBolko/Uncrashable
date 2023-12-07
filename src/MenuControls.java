import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuControls implements ActionListener {
    private JPanel controlsPanel;
    private MainWindow mainWindow;
    private JButton startButton;
    private JButton leaderboardButton;
    private JButton quitButton;
    public MenuControls(JPanel controlsPanel, MainWindow mainWindow) {
        this.controlsPanel = controlsPanel;
        this.mainWindow = mainWindow;

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

        this.controlsPanel.add(startButton);
        this.controlsPanel.add(Box.createVerticalStrut(2));
        this.controlsPanel.add(leaderboardButton);
        this.controlsPanel.add(Box.createVerticalStrut(2));
        this.controlsPanel.add(quitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            System.out.println("dasd");
            mainWindow.setGameRunning(true);
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
}
