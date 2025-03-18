package view;

import control.GameController;
import model.GameModel;

import javax.swing.*;
import java.awt.*;
public class GameFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private GameView gameView;
    private GameOverPanel gameOverPanel;
    private GameModel model;
    private GameController controller;

    public GameFrame() {
        // Inizializza il CardLayout e il pannello che lo utilizza
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Crea il modello e la view del gioco
        model = new GameModel();
        gameView = new GameView(model);

        // Crea il pannello di Game Over, passandogli l'azione di restart
        gameOverPanel = new GameOverPanel(() -> restartGame());

        // Crea il pannello di vittoria
        WinPanel winPanel = new WinPanel(() -> restartGame());

        // Aggiunge le schermate al cardPanel
        cardPanel.add(gameView, "GAME");
        cardPanel.add(gameOverPanel, "GAME_OVER");
        cardPanel.add(winPanel, "WIN_MESSAGE");

        // Aggiunge il pannello con CardLayout al frame
        add(cardPanel);

        // Crea il controller, che gestisce gli input e il game loop
        controller = new GameController(model, gameView, this);

        // Imposta le proprietà del frame
        setTitle("Platform Game");
        pack();
        setLocationRelativeTo(null);
        setResizable(false); // Finestra a dimensioni fisse
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    // Metodo per passare al pannello Game Over
    public void showGameOver() {
        cardLayout.show(cardPanel, "GAME_OVER");
    }

    public void showWinMessage() {
        cardLayout.show(cardPanel, "WIN_MESSAGE");
    }


    // Metodo per effettuare il restart del gioco
    public void restartGame() {
        // Ricrea il modello e la view
        model = new GameModel();
        gameView = new GameView(model);
        controller = new GameController(model, gameView, this);

        // Svuota il pannello e aggiungi la nuova GameView e il pannello Game Over
        cardPanel.removeAll();
        cardPanel.add(gameView, "GAME");
        cardPanel.add(gameOverPanel, "GAME_OVER");
        cardPanel.add(new WinPanel(() -> restartGame()), "WIN_MESSAGE");

        // Mostra la schermata di gioco
        cardLayout.show(cardPanel, "GAME");
        cardPanel.revalidate();
        cardPanel.repaint();

        // Richiedi il focus sulla nuova GameView in modo che i key events vengano catturati
        SwingUtilities.invokeLater(() -> gameView.requestFocusInWindow());
    }


}
