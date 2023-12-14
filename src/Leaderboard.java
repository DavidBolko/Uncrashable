import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Leaderboard implements ActionListener {
    private JPanel leaderBoard;
    private JTable playerList;
    private JButton backButton;
    private Root root;

    public Leaderboard(Root root) {
        this.root = root;

        this.leaderBoard = new JPanel();
        this.leaderBoard.setLayout(new BoxLayout(leaderBoard, BoxLayout.Y_AXIS));
        this.leaderBoard.setMinimumSize(new Dimension(800, 600));
        this.leaderBoard.setMaximumSize(new Dimension(800, 600));
        this.leaderBoard.setBackground(Color.BLACK);

        String[] columns = {"Username", "Score", "Medal"};
        this.playerList = new JTable(FileManager.getPlayers(), columns);
        JScrollPane scrollPane = new JScrollPane(this.playerList);

        this.leaderBoard.add(scrollPane);

        this.backButton = new JButton("Back");
        this.backButton.setPreferredSize(new Dimension(100, 20));
        this.backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.backButton.addActionListener(this);
        this.leaderBoard.add(this.backButton);
    }

    public JPanel getLeaderBoard() {
        return this.leaderBoard;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == backButton){
            root.run();
        }
    }
}
