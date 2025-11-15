// Position.java
public final class Position {
    public final int r, c;
    public Position(int r, int c) { this.r = r; this.c = c; }

    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position p = (Position) o;
        return r == p.r && c == p.c;
    }

    @Override public int hashCode() { return 31 * r + c; }

    @Override public String toString() { return "(" + r + "," + c + ")"; }
}