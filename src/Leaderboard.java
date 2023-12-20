import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Leaderboard implements ActionListener {
    private JPanel leaderBoard;
    private JTable playerList;
    private JButton backButton;
    private DefaultTableModel tableModel;
    private Root root;

    private final String[] columns = {"Username", "Score", "Medal"};

    public Leaderboard(Root root) {
        this.root = root;

        this.leaderBoard = new JPanel();
        this.leaderBoard.setLayout(new BoxLayout(leaderBoard, BoxLayout.Y_AXIS));
        this.leaderBoard.setMinimumSize(new Dimension(800, 600));
        this.leaderBoard.setMaximumSize(new Dimension(800, 600));
        this.leaderBoard.setBackground(Color.BLACK);

        this.tableModel = new DefaultTableModel();
        this.playerList = new JTable();
        this.updateLeaderBoard();

        JScrollPane scrollPane = new JScrollPane(this.playerList);
        this.leaderBoard.add(scrollPane);

        this.backButton = new JButton("Back");
        this.backButton.setPreferredSize(new Dimension(100, 20));
        this.backButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.backButton.addActionListener(this);
        this.leaderBoard.add(this.backButton);
        this.leaderBoard.setVisible(true);
    }

    public void updateLeaderBoard(){
        this.tableModel.setRowCount(0);
        this.tableModel.setDataVector(FileManager.getPlayers(), columns);
        this.playerList.setModel(tableModel);
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
