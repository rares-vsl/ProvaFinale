package model;

public class BluePlatform extends Terrain {
    public BluePlatform(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public boolean checkCollision(Player p) {
        // La blue platform non permette un atterraggio sicuro: restituisce sempre false
        return true;
    }
}

