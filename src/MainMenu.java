import com.formdev.flatlaf.FlatDarkLaf;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MainMenu{

    private JFrame window;
    private JPanel controlsPanel;
    private MainWindow mainWindow;

    public MainMenu(MainWindow mainWindow){
        FlatDarkLaf.setup();

        this.mainWindow = mainWindow;

        this.window = new JFrame();
        this.window.setLayout(new GridBagLayout());
        this.window.setMinimumSize(new Dimension(800, 600));
        this.window.setMaximumSize(new Dimension(800, 600));

        this.controlsPanel = new JPanel();
        this.controlsPanel.setLayout(new BoxLayout(controlsPanel, BoxLayout.Y_AXIS));
        this.controlsPanel.setMinimumSize(new Dimension(800, 600));
        this.controlsPanel.setMaximumSize(new Dimension(800, 600));
        this.controlsPanel.setBackground(Color.BLACK); 

        JLabel imageComponent = new JLabel();
        BufferedImage image = loadImage("src/resources/semestralka.png");
        imageComponent.setIcon(new ImageIcon(image));
        imageComponent.setAlignmentX(Component.CENTER_ALIGNMENT);

        MenuControls menuControls = new MenuControls(this.controlsPanel, this.mainWindow);

        window.getContentPane().setBackground(Color.BLACK);
        window.add(imageComponent);
        window.add(controlsPanel);
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

    public void show(){
        window.setVisible(true);
    }

    public void close(){
        window.setVisible(false);
    }

}
