package model;

public class GameModel {
    private Player player;
    private Level level;

    public GameModel() {
        // Il giocatore parte ad una posizione iniziale (ad esempio, 50 pixel da sinistra e 300 pixel in verticale)
        player = new Player(50, 300);
        level = new Level();
    }

    // Aggiorna lo stato del gioco: movimento del giocatore e eventuale collisione
    public void update() {
        player.update();
    }

    public Player getPlayer() { return player; }
    public Level getLevel() { return level; }
}
