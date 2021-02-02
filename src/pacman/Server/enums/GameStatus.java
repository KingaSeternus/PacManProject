package pacman.Server.enums;

public enum GameStatus {
    PLAY("GRA"), PAUSE("PAUZA"), WIN("ZWYCIESTWO"), LOSE("PORAZKA");

    private String translation;

    GameStatus(String translation) {
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }
}
