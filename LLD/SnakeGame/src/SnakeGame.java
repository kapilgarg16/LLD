// SnakeGame.java
import java.util.*;

public class SnakeGame {
    private final int rows, cols;
    private final Deque<Position> body = new ArrayDeque<>(); // head at front
    private final Set<Position> bodySet = new HashSet<>();   // fast membership checks
    private boolean gameOver = false;
    private int moveCount = 0;

    // initial length = 3, placed horizontally with head at center column+1
    public SnakeGame(int rows, int cols) {
        if (rows <= 0 || cols <= 0) throw new IllegalArgumentException("Board must be positive size");
        this.rows = rows; this.cols = cols;
        int midR = rows / 2;
        int midC = cols / 2;
        Position tail = new Position(midR, midC - 1);
        Position mid  = new Position(midR, midC);
        Position head = new Position(midR, midC + 1);
        body.addFirst(head);   // head at front
        body.addLast(mid);
        body.addLast(tail);    // tail at back
        bodySet.add(head); bodySet.add(mid); bodySet.add(tail);
    }

    // Move snake one step in direction. Returns true if move succeeded.
    // Game ends (returns false) if snake collides with itself.
    public boolean moveSnake(Direction dir) {
        if (gameOver) return false;
        moveCount++;
        Position head = body.peekFirst();
        int nr = (head.r + dir.dr) % rows; if (nr < 0) nr += rows;
        int nc = (head.c + dir.dc) % cols; if (nc < 0) nc += cols;
        Position newHead = new Position(nr, nc);

        boolean willGrow = (moveCount % 5 == 0);
        Position tail = body.peekLast();

        // collision check: allow moving into tail only if tail will be removed this move (!willGrow)
        if (bodySet.contains(newHead) && !( !willGrow && newHead.equals(tail) )) {
            gameOver = true;
            return false;
        }

        body.addFirst(newHead);
        bodySet.add(newHead);

        if (!willGrow) {
            Position removed = body.removeLast();
            bodySet.remove(removed);
        } // else: grew by 1

        return true;
    }

    public boolean isGameOver() { return gameOver; }
    public int getMoveCount() { return moveCount; }
    public List<Position> getSnakePositions() { return new ArrayList<>(body); }
    public int getRows() { return rows; }
    public int getCols() { return cols; }
}
