package view;

import javax.swing.*;
import java.awt.*;

public class WinPanel extends JPanel {
    public WinPanel(Runnable restartAction) {
        setLayout(new BorderLayout());
        setBackground(new Color(0, 0, 0, 150)); // Sfondo semi-trasparente

        JLabel messageLabel = new JLabel("Hai vinto!", SwingConstants.CENTER);
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