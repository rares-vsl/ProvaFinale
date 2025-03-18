package control;

import model.GameModel;
import model.Terrain;
import view.GameFrame;
import view.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameController implements KeyListener, ActionListener {
    private GameModel model;
    private GameView view;
    private Timer timer;
    private GameFrame gameFrame; // riferimento al frame per gestire il game over
    // Imposta una soglia di caduta (modifica in base alle tue esigenze)
    private final int FALL_THRESHOLD = 500;

    public GameController(GameModel model, GameView view, GameFrame gameFrame) {
        this.model = model;
        this.view = view;
        this.gameFrame = gameFrame;
        view.addKeyListener(this);
        view.setFocusable(true);
        view.requestFocusInWindow();

        // Timer per il game loop (circa 50 fps)
        timer = new Timer(50, this);
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        model.update();

        // Controllo collisioni per atterrare sul terreno
        for (Terrain t : model.getLevel().getTerrains()) {
            if (t.checkCollision(model.getPlayer())) {
                model.getPlayer().land(t.getY());
            }
        }

        // Se il player cade al di sotto della soglia, interrompi il gioco
        if (model.getPlayer().getY() > FALL_THRESHOLD) {
            timer.stop();
            gameFrame.showGameOver();
        }

        view.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            model.getPlayer().moveLeft();
        } else if (key == KeyEvent.VK_RIGHT) {
            model.getPlayer().moveRight();
        } else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_SPACE) {
            model.getPlayer().jump();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            model.getPlayer().stop();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }
}

