package model;

import java.awt.*;

public class Pillar extends Terrain {
    public Pillar(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean checkCollision(Player p) {
        int playerX = p.getX();
        int playerY = p.getY();
        int playerW = p.getWidth();
        int playerH = p.getHeight();

        // Verifica l'overlap orizzontale
        if (playerX + playerW > getX() && playerX < getX() + getWidth()) {
            // Verifica se la parte bassa del giocatore tocca il pilastro dall'alto
            if (playerY + playerH >= getY() && playerY < getY()) {
                return true;
            }
        }
        return false;
    }
}