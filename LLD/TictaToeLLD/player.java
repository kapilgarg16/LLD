public class player
{
    public string name;
    public PlayingPiece playingPiece;

    public player(string name, PlayingPiece playingPiece) {
        this.name = name;
        this.playingPiece = playingPiece;
    }

    public void setName(string name) {
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setPlayerPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }

    public playingPiece getPlayerPiece(){
        return this.playingPiece;
    }
}