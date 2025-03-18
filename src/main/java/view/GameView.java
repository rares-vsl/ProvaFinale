package view;

import model.GameModel;
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
        // Se il player è nella parte sinistra, l'offset risulterebbe negativo; in tal caso lo clamping a 0 fa spawnare il terreno dal bordo sinistro
        int offsetX = model.getPlayer().getX() - fixedWidth / 2;
        if (offsetX < 0) {
            offsetX = 0;
        }
        g2d.translate(-offsetX, 0);

        // Disegna i segmenti di terreno (rettangoli verdi)
        g2d.setColor(Color.GREEN);
        for (Terrain t : model.getLevel().getTerrains()) {
            g2d.fillRect(t.getX(), t.getY(), t.getWidth(), t.getHeight());
        }

        // Disegna il player (un quadrato rosso)
        Player p = model.getPlayer();
        g2d.setColor(Color.RED);
        g2d.fillRect(p.getX(), p.getY(), p.getWidth(), p.getHeight());

        g2d.dispose();
    }
}
