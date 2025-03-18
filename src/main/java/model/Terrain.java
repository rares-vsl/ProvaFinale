package model;

import java.awt.*;

public class Terrain {
    private int x, y, width, height;

    public Terrain(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public boolean checkCollision(Player p) {
        int playerX = p.getX();
        int playerY = p.getY();
        int playerW = p.getWidth();
        int playerH = p.getHeight();

        // Verifica l'overlap orizzontale
        if (playerX + playerW > x && playerX < x + width) {
            // Verifica se la parte bassa del giocatore tocca il terreno dall'alto
            if (playerY + playerH >= y && playerY < y) {
                return true;
            }
        }
        return false;
    }

    public boolean checkSideCollision(Player p) {
        int playerX = p.getX();
        int playerY = p.getY();
        int playerW = p.getWidth();
        int playerH = p.getHeight();

        // Verifica l'overlap verticale
        if (playerY + playerH > y && playerY < y + height) {
            // Verifica se il giocatore tocca il terreno lateralmente
            if ((playerX + playerW >= x && playerX < x) || (playerX <= x + width && playerX + playerW > x + width)) {
                return true;
            }
        }
        return false;
    }

    public void draw(Graphics2D g2d, int windowHeight) {
        g2d.fillRect(x, y, width, windowHeight - y);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}