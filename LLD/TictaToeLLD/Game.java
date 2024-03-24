public class Game {

    Dequeue<player> players;
    Board board;

    public Game()
    {
        Intialize();
    }

    public void Intialize()
    {
        PlayingPiece pieceO = new PlayingPieceO();
        Player player1 = new player("Kapil", pieceO);

        PlayingPiece piece1 = new PlayingPieceX();
        Player player2 = new player("Chirag", piece1);

        players.add(player1);
        players.add(player2);

        board = new Board(3);
    }

    public string startBoardGame(){
        bool isWinner = true;

        while(isWinner){
            
        }
    }

}