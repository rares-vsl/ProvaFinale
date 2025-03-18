package model;

import java.awt.*;

public class WinBox {
    private int x, y, width, height;

    public WinBox(int x, int y, int width, int height) {
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

        if (playerX + playerW > x && playerX < x + width &&
                playerY + playerH > y && playerY < y + height) {
            return true;
        }

        return false;
    }

    public void draw(Graphics2D g2d) {
        g2d.setColor(Color.YELLOW);
        g2d.fillRect(x, y, width, height);
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}