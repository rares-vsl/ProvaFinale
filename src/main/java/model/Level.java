package model;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Terrain> terrains;

    public Level() {
        terrains = new ArrayList<>();
        // Assumiamo una scala: 1 unità = 5 pixel
        int scale = 5;
        int groundY = 350; // posizione verticale del terreno

        // Primo tratto: terreno piatto di 200 unità
        terrains.add(new Terrain(0, groundY, 200 * scale, 20));

        // Voragine: ipotizziamo una gap di 45 unità (non creiamo un oggetto Terrain per il gap)
        int gapWidth = 45 * scale;

        // Secondo tratto: terreno piatto di 200 unità dopo la gap
        terrains.add(new Terrain(200 * scale + gapWidth, groundY, 200 * scale, 20));
    }

    public List<Terrain> getTerrains() {
        return terrains;
    }
}
