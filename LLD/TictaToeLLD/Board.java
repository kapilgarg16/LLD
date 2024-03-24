public class Board {

    public int size;
    public PlayingPiece [][]board;

    //we are creating size*size of board;
    public Board(int size){
        this.size = size;
        board = new PlayingPiece[size][size];
    }

    public bool addPiece(int row, int column, PlayingPiece playingPiece){

        if(board[row][column] != null){
            return false;
        }

        board[row][column] = playingPiece;
        return true;
    }

    public List < pair<int,int> > getFreeCells()
    {
        List<pair<int,int>>ls;
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++)
            {
                if(board[i][j] == null){
                    ls.add({i,j});
                }
            }
        }
        return ls;
    }
    public void printBoard()
    {
        for(int i = 0 ; i < size ; i++){
            for(int j = 0 ; j < size ; j++)
            {
                if(board[i][j].pieceType == X)
                system.println.out("X  |");
                else if(board[i][j].pieceType == O)
                system.println.out("O  ");
                else
                system.println.out("  |");
            }
        }
    }
}