import javax.swing.*;
import java.awt.*;

public class Chai {

    public JFrame window = new JFrame("window");
    public Container container;
    public JPanel titleNamePanel, startButtonPanel, mainTextPanel;
    public JLabel titleNameLabel;
    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font bodyFont = new Font("Times New Roman", Font.PLAIN, 30);
    JButton startButton;

    public void showWindow() {

        window.setSize(800, 600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.LIGHT_GRAY);
        window.setLayout(null);
        container = window.getContentPane();

        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100, 100, 600, 150);
        titleNamePanel.setBackground(Color.LIGHT_GRAY);
        titleNameLabel = new JLabel("ADVENTURE");
        titleNameLabel.setForeground(Color.WHITE);
        titleNameLabel.setFont(titleFont);

        startButtonPanel = new JPanel();
        startButtonPanel.setBounds(300, 400, 200, 100);
        startButtonPanel.setBackground(null);

        startButton = new JButton("START");
        startButton.setBackground(null);
        startButton.setForeground(Color.LIGHT_GRAY);
        startButton.setFont(bodyFont);

        titleNamePanel.add(titleNameLabel);
        startButtonPanel.add(startButton);
        container.add(titleNamePanel, BorderLayout.CENTER);
        container.add(startButtonPanel, BorderLayout.AFTER_LAST_LINE);
        window.setVisible(true);

    }

    public void showMainScreen() {

        mainTextPanel = new JPanel();
        mainTextPanel.setBounds(100, 100, 600, 250);
        mainTextPanel.setBackground(Color.BLUE);
        container.add(mainTextPanel);

    }

}
