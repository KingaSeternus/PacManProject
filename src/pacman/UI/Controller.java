package pacman.UI;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import pacman.Server.Game;
import pacman.Server.enums.GameStatus;

import java.util.Timer;
import java.util.TimerTask;

import static pacman.UI.Model.retrieveModel;

public class Controller implements EventHandler<KeyEvent> {

    private static final double FPS = 6.0;

    private static final String TIPS_TEXT = "Ruch - strzałki | P - Pauza | R - Restart";

    @FXML
    private View view;

    @FXML
    private Label tipsLabel;

    @FXML
    private Label infoLabel;

    @FXML
    private Label score;

    private Game game;

    private Timer timer;

    public void initialize() {
        this.game = new Game();
        this.view.initializeGrid(game.getMap().getBoardHeight(), game.getMap().getBoardWidth());
        tipsLabel.setText(String.format("%s", TIPS_TEXT));
        startTimer();
    }

    private void startTimer() {
        if (timer != null) {
            timer.cancel();
        }
        this.timer = new Timer();
        this.timer.schedule(task(), 0, (long) (1000.0 / FPS));
    }

    private TimerTask task() {
        return new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> {
                    game.iteration();
                    view.updateView(retrieveModel(game));
                    score.setText(String.format("Wynik: %d", game.getScore()));
                    infoLabel.setText(String.format("Status: %s", game.getGameInfo()));
                    if (game.getGameStatus() != GameStatus.PLAY) {
                        timer.cancel();
                    }
                });
            }
        };
    }

    @Override
    public void handle(KeyEvent keyEvent) {
        switch (keyEvent.getCode()) {
            case UP:
                game.getPlayer().moveUP();
                break;
            case DOWN:
                game.getPlayer().moveDOWN();
                break;
            case RIGHT:
                game.getPlayer().moveRIGHT();
                break;
            case LEFT:
                game.getPlayer().moveLEFT();
                break;
            case P:
                if (game.getGameStatus() == GameStatus.PLAY) {
                    game.setGameStatus(GameStatus.PAUSE);
                } else if (game.getGameStatus() == GameStatus.PAUSE) {
                    game.setGameStatus(GameStatus.PLAY);
                    startTimer();
                }
                break;
            case R:
                game.startNewGame();
                startTimer();
                break;
            default:
                break;
        }
        keyEvent.consume();
    }
}
