package pacman.Server.maps;

import pacman.Server.enums.BoardObject;

import static pacman.Server.enums.BoardObject.*;

public class map_1 {

    private final static BoardObject[] row_1 = {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL};
    private final static BoardObject[] row_2 = {WALL, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, WALL, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, WALL};
    private final static BoardObject[] row_3 = {WALL, POWER_UP, WALL, WALL, POINT, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, POINT, WALL, WALL, POWER_UP, WALL};
    private final static BoardObject[] row_4 = {WALL, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, WALL};
    private final static BoardObject[] row_5 = {WALL, POINT, WALL, WALL, POINT, WALL, POINT, WALL, WALL, WALL, WALL, WALL, POINT, WALL, POINT, WALL, WALL, POINT, WALL};
    private final static BoardObject[] row_6 = {WALL, POINT, POINT, POINT, POINT, WALL, POINT, POINT, POINT, WALL, POINT, POINT, POINT, WALL, POINT, POINT, POINT, POINT, WALL};
    private final static BoardObject[] row_7 = {WALL, WALL, WALL, WALL, POINT, WALL, WALL, WALL, EMPTY, WALL, EMPTY, WALL, WALL, WALL, POINT, WALL, WALL, WALL, WALL};
    private final static BoardObject[] row_8 = {EMPTY, EMPTY, EMPTY, WALL, POINT, WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, WALL, POINT, WALL, EMPTY, EMPTY, EMPTY};
    private final static BoardObject[] row_9 = {WALL, WALL, WALL, WALL, POINT, WALL, EMPTY, WALL, EMPTY, WALL, EMPTY, WALL, EMPTY, WALL, POINT, WALL, WALL, WALL, WALL};
    private final static BoardObject[] row_10 = {WALL, EMPTY, EMPTY, EMPTY, POINT, EMPTY, EMPTY, WALL, GHOST_HOME, EMPTY, GHOST_HOME, WALL, EMPTY, EMPTY, POINT, EMPTY, EMPTY, EMPTY, WALL};
    private final static BoardObject[] row_11 = {WALL, WALL, WALL, WALL, POINT, WALL, EMPTY, WALL, WALL, WALL, WALL, WALL, EMPTY, WALL, POINT, WALL, WALL, WALL, WALL};
    private final static BoardObject[] row_12 = {EMPTY, EMPTY, EMPTY, WALL, POINT, WALL, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, WALL, POINT, WALL, EMPTY, EMPTY, EMPTY};
    private final static BoardObject[] row_13 = {WALL, WALL, WALL, WALL, POINT, WALL, EMPTY, WALL, WALL, WALL, WALL, WALL, EMPTY, WALL, POINT, WALL, WALL, WALL, WALL};
    private final static BoardObject[] row_14 = {WALL, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, WALL, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, WALL};
    private final static BoardObject[] row_15 = {WALL, POWER_UP, WALL, WALL, POINT, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, POINT, WALL, WALL, POWER_UP, WALL};
    private final static BoardObject[] row_16 = {WALL, POINT, POINT, WALL, POINT, POINT, POINT, POINT, POINT, PACMAN_HOME, POINT, POINT, POINT, POINT, POINT, WALL, POINT, POINT, WALL};
    private final static BoardObject[] row_17 = {WALL, WALL, POINT, WALL, POINT, WALL, POINT, WALL, WALL, WALL, WALL, WALL, POINT, WALL, POINT, WALL, POINT, WALL, WALL};
    private final static BoardObject[] row_18 = {WALL, POINT, POINT, POINT, POINT, WALL, POINT, POINT, POINT, WALL, POINT, POINT, POINT, WALL, POINT, POINT, POINT, POINT, WALL};
    private final static BoardObject[] row_19 = {WALL, POINT, WALL, WALL, WALL, WALL, WALL, WALL, POINT, WALL, POINT, WALL, WALL, WALL, WALL, WALL, WALL, POINT, WALL};
    private final static BoardObject[] row_20 = {WALL, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, POINT, WALL};
    private final static BoardObject[] row_21 = {WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL, WALL};


    public static BoardObject[][] getBoard() {
        return new BoardObject[][]{row_1, row_2, row_3, row_4, row_5, row_6, row_7, row_8, row_9, row_10, row_11,
                row_12, row_13, row_14, row_15, row_16, row_17, row_18, row_19, row_20, row_21};
    }


}
