import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuControls implements ActionListener {
    private JPanel controlsPanel;

    private JComboBox<Difficulty> difficultyOptions;
    private Root root;
    private JButton startButton;
    private JButton leaderboardButton;
    private JButton quitButton;
    public MenuControls(JPanel controlsPanel, Root root) {
        this.controlsPanel = controlsPanel;
        this.root = root;

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
        this.controlsPanel.add(difficultyOptions);
        this.controlsPanel.add(Box.createVerticalStrut(2));
        this.controlsPanel.add(startButton);
        this.controlsPanel.add(Box.createVerticalStrut(2));
        this.controlsPanel.add(leaderboardButton);
        this.controlsPanel.add(Box.createVerticalStrut(2));
        this.controlsPanel.add(quitButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == startButton){
            if (!root.isGameRunning()){
                root.runGame((Difficulty)difficultyOptions.getSelectedItem());
            } else{
                root.run();
            }
        } else if (e.getSource() == quitButton) {
            System.exit(0);
        }
    }
}
