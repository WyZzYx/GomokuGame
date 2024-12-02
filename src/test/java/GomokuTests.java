
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

    public class GomokuTests {



        @BeforeEach
        public void setUp() {
            System.load("/Users/vitaliikoltok/CLionProjects/UTPProjectGomoku/cmake-build-debug/libUTPProjectGomoku.dylib");
            Main.setBoardSize(15);


        }


        @Test
        public void testBoardInitialization() {
            int boardSize = Main.getBoardSize();
            assertEquals(15, boardSize, "Board size should be initialized as 15");

            for (int x = 0; x < boardSize; x++) {
                for (int y = 0; y < boardSize; y++) {
                    int cellState = Main.getBoardState(x, y);
                    assertEquals(0, cellState, "All cells should be empty");
                }
            }
        }

        @Test
        public void testMove() {
            int x = 7;
            int y = 7;
            int currentPlayer = 1;


            Main.mouseClicked(x, y);
            int cellState = Main.getBoardState(x, y);

            assertEquals(currentPlayer, cellState, "Cell should be occupied");
        }

        @Test
        public void testInvalidMove() {
            int x = 7;
            int y = 7;

            Main.mouseClicked(x, y);

            Main.mouseClicked(x, y);
            int cellState = Main.getBoardState(x, y);

            assertEquals(1, cellState, "Cell was already occupied by player 1");
        }

        @Test
        public void testHorizontalWinCondition() { // -

            int boardSize = Main.getBoardSize();
            int pointsToWin = 5;

            for (int x = 0; x <= boardSize; x++) {
                for (int y = 0; y <= boardSize; y++) {
                    Main.setBoardSize(15);

                    for (int i = 0; i <= pointsToWin; i++) {
                        Main.mouseClicked(x+i, y);
                        Main.mouseClicked(x, y+i);

                    }

                    int gameState = Main.gameState();
                    assertEquals(1, gameState, "Horizontal win failed at position " + x + "," + y);
                }
            }
        }
        @Test
        public void testVerticalWinCondition() { // |

            int boardSize = Main.getBoardSize();
            int pointsToWin = 5;

            for (int x = 0; x <= boardSize; x++) {
                for (int y = 0; y <= boardSize; y++) {
                    Main.setBoardSize(15);

                    for (int i = 0; i <= pointsToWin; i++) {
                        Main.mouseClicked(x, y+i);
                        Main.mouseClicked(x+i, y);

                    }

                    int gameState = Main.gameState();
                    assertEquals(1, gameState, "Vertical win failed at position " + x + "," + y);
                }
            }
        }
        @Test
        public void testLeftDiagonalWinCondition() { // Diagonal /

            int boardSize = Main.getBoardSize();
            int pointsToWin = 5;

            for (int x = pointsToWin; x <= boardSize; x++) {
                for (int y = 0; y <= boardSize; y++) {
                    Main.setBoardSize(15);

                    for (int i = 0; i <= pointsToWin; i++) {
                        Main.mouseClicked(x-i, y+i);
                        Main.mouseClicked(x, y+i);

                    }

                    int gameState = Main.gameState();
                    assertEquals(1, gameState, "Left Diagonal win failed at position " + x + "," + y);
                }
            }
        }

        @Test
        public void testRightDiagonalWinCondition() { // Diagonal \

            int boardSize = Main.getBoardSize();
            int pointsToWin = 5;

            for (int x = 0; x <= boardSize; x++) {
                for (int y = 0; y <= boardSize; y++) {
                    Main.setBoardSize(15);

                    for (int i = 0; i <= pointsToWin; i++) {
                        Main.mouseClicked(x+i, y+i);
                        Main.mouseClicked(x+i+1, y+i);

                    }
                    int gameState = Main.gameState();
                    assertEquals(1, gameState, "Right Diagonal win failed at position " + x + "," + y);
                }
            }
        }

        @Test
        public void testTieCondition() {
            int boardSize = Main.getBoardSize();

            for (int y = 0; y < boardSize; y++) {
                for (int x = 0; x < boardSize; x++) {
                    Main.mouseClicked(x, y);

                }
            }

            int gameState = Main.gameState();
            assertEquals(3, gameState, "Game should be Tie");
        }

        @Test
        public void testGameMechanics() {
            int x= 5;
            int y = 5;

            Main.mouseClicked(x, y);
            assertEquals(1, Main.getBoardState(x, y), "First move should be by player 1.");

            Main.mouseClicked(x+1, y+1);
            assertEquals(2, Main.getBoardState(x+1, y+1), "Second move should be by player 2.");

            Main.mouseClicked(x+2, y+2);
            assertEquals(1, Main.getBoardState(x+2, y+2), "Third move should be by player 1.");
        }
    }

