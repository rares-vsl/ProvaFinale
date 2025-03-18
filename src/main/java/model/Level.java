package model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Terrain> terrains;
    private int scale = 5;
    private int groundY = 350; // posizione verticale del terreno
    private int currentX = 0;
    private WinBox winBox;

    public Level() {
        terrains = new ArrayList<>();
        createLevel();
    }

    private void createLevel() {
        addTerrain(200);
        addGap(35);
        addPillar(30, 70);
        addGap(50);
        addWinBox(50, 50);
        addTerrain(500);
    }


    private void addTerrain(int units) {
        terrains.add(new Terrain(currentX, groundY, units * scale, groundY));
        currentX += units * scale;
    }

    private void addGap(int units) {
        currentX += units * scale;
    }

    private void addPillar(int units, int height) {
        int pillarX = currentX;
        int pillarY = groundY - height;
        terrains.add(new Pillar(pillarX, pillarY, units * scale, height));
        currentX += units * scale;
    }

    private void addWinBox(int units, int height) {
        int winBoxX = currentX + 50 * scale; // 50 unità dopo l'inizio della piattaforma finale
        int winBoxY = groundY - height + 50; // Posizionato sopra la piattaforma finale
        winBox = new WinBox(winBoxX, winBoxY, units, height);
    }
    public List<Terrain> getTerrains() {
        return terrains;
    }

    public WinBox getWinBox() {
        return winBox;
    }
}