package view;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    public GameOverPanel(Runnable restartAction) {
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0, 150)); // Sfondo semi-trasparente

        JLabel messageLabel = new JLabel("Game Over!", SwingConstants.CENTER);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 36));
        messageLabel.setForeground(Color.WHITE);
        add(messageLabel, BorderLayout.CENTER);

        JButton restartButton = new JButton("Restart");
        restartButton.setFont(new Font("Arial", Font.PLAIN, 24));
        restartButton.addActionListener(e -> restartAction.run());
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(restartButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }
}
