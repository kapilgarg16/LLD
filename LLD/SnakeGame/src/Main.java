public class Main {
    private static void printBoard(SnakeGame g) {
        int r = g.getRows(), c = g.getCols();
        char[][] b = new char[r][c];
        for (int i = 0; i < r; i++) for (int j = 0; j < c; j++) b[i][j] = '.';
        java.util.List<Position> body = g.getSnakePositions();
        if (!body.isEmpty()) {
            Position head = body.get(0);
            b[head.r][head.c] = 'H';
            for (int i = 1; i < body.size(); i++) {
                Position p = body.get(i);
                b[p.r][p.c] = 'o';
            }
        }
        System.out.println("Move: " + g.getMoveCount() + (g.isGameOver() ? "  [GAME OVER]" : ""));
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) System.out.print(b[i][j]);
            System.out.println();
        }
    }
    public static void main(String[] args) {
        SnakeGame game = new SnakeGame(6, 8);

        Direction[] moves = {
                Direction.RIGHT, Direction.RIGHT, Direction.DOWN, Direction.LEFT, Direction.UP, // 1-5
                Direction.LEFT, Direction.LEFT, Direction.UP, Direction.RIGHT, Direction.DOWN, // 6-10
                Direction.LEFT, Direction.LEFT, Direction.UP, Direction.RIGHT, Direction.DOWN  // 11-15
        };

        System.out.println("Initial board:");
        printBoard(game);
        System.out.println();

        for (Direction d : moves) {
            boolean ok = game.moveSnake(d);
            printBoard(game);
            System.out.println();
            if (!ok) {
                System.out.println("Snake collided with itself. Exiting demo.");
                break;
            }
        }

        if (!game.isGameOver()) System.out.println("Demo finished without self-collision.");
    }
}