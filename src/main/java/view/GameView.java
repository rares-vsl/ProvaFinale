package view;

import model.GameModel;
import model.Pillar;
import model.Player;
import model.Terrain;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private GameModel model;
    // Dimensioni fisse della view
    private final int fixedWidth = 1200;
    private final int fixedHeight = 400;

    public GameView(GameModel model) {
        this.model = model;
        setPreferredSize(new Dimension(fixedWidth, fixedHeight));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g.create();

        // Calcola l'offset per la camera
        int offsetX = model.getPlayer().getX() - fixedWidth / 2;
        if (offsetX < 0) {
            offsetX = 0;
        }
        g2d.translate(-offsetX, 0);

        // Disegna i segmenti di terreno (rettangoli verdi) e il pilastro (rettangolo blu)
        int windowHeight = getHeight();
        for (Terrain t : model.getLevel().getTerrains()) {
            if (t instanceof Pillar) {
                g2d.setColor(Color.BLUE); // Pilastro blu
            } else {
                g2d.setColor(Color.GREEN); // Terreno verde
            }
            t.draw(g2d, windowHeight);
        }

        model.getLevel().getWinBox().draw(g2d);

        // Disegna il player (un quadrato rosso)
        Player p = model.getPlayer();
        g2d.setColor(Color.RED);
        g2d.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());

        g2d.dispose();
    }
}
