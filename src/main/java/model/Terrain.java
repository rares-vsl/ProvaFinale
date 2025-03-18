package model;

public class Terrain {
    private int x, y, width, height;

    public Terrain(int x, int y, int width, int height) {
        this.x = x;
        this.y = y; // y rappresenta la quota del terreno
        this.width = width;
        this.height = height;
    }

    // Controlla una collisione semplice: se il giocatore è in corrispondenza
    // del bordo superiore del terreno (semplice collisione verticale)
    public boolean checkCollision(Player p) {
        int playerX = p.getX();
        int playerY = p.getY();
        int playerW = p.getWidth();
        int playerH = p.getHeight();

        // Verifica l'overlap orizzontale
        if (playerX + playerW > x && playerX < x + width) {
            // Verifica se la parte bassa del giocatore tocca il terreno
            if (playerY + playerH >= y && playerY + playerH <= y + height) {
                return true;
            }
        }
        return false;
    }

    // Getters
    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
}
