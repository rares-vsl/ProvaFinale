package model;

public class Player {
    private int x, y;
    private int width = 50, height = 50;
    private double velocityX, velocityY;

    // Costanti per la fisica
    private final double GRAVITY = 0.5;
    private final double JUMP_STRENGTH = -10; // 50
    private final double MOVE_SPEED = 5;

    // Flag per gestire il salto singolo
    private boolean canJump = true;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.velocityX = 0;
        this.velocityY = 0;
    }

    public void moveLeft() {
        velocityX = -MOVE_SPEED;
    }

    public void moveRight() {
        velocityX = MOVE_SPEED;
    }

    public void stop() {
        velocityX = 0;
    }

    public void jump() {
        if (canJump) {
            velocityY = JUMP_STRENGTH;
            canJump = false;
        }
    }

    // Aggiorna la posizione e applica la gravità ad ogni frame
    public void update() {
        // Applica il movimento orizzontale
        x += velocityX;
        // Impedisci che il player esca a sinistra
        if (x < 0) {
            x = 0;
            velocityX = 0;
        }

        // Aggiorna la posizione verticale e applica la gravità
        y += velocityY;
        velocityY += GRAVITY;
    }

    // Viene chiamato quando il giocatore collide con una piattaforma
    public void land(int groundY) {
        if (velocityY > 0) { // Assicurati che il giocatore stia cadendo
            y = groundY - height;
            velocityY = 0;
            canJump = true;
        }
    }

    // Getters
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}


