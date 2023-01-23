public class Board {
    private int columns = 8;
    private int rows = 8;
    private Piece[][] gameBoard;


    public Board(){
        gameBoard = new Piece[rows][columns];
        initialize();
    }
    private void initialize() {
        gameBoard[0][4] = new Piece("white","King");
        gameBoard[7][4] = new Piece("black","King");
        gameBoard[0][0] = new Piece("white","Rook");
        gameBoard[0][7] = new Piece("white","Rook");
        gameBoard[7][0] = new Piece("black","Rook");
        gameBoard[7][7] = new Piece("black","Rook");
        gameBoard[0][2] = new Piece("white","Bishop");
        gameBoard[0][5] = new Piece("white","Bishop");
        gameBoard[7][2] = new Piece("black","Bishop");
        gameBoard[7][5] = new Piece("black","Bishop");
        gameBoard[0][1] = new Piece("white","Knight");
        gameBoard[0][6] = new Piece("white","Knight");
        gameBoard[7][1] = new Piece("black","Knight");
        gameBoard[7][6] = new Piece("black","Knight");
        gameBoard[0][3] = new Piece("white","Queen");
        gameBoard[7][3] = new Piece("black","Queen");
        for (int i = 0; i < 8 ; i++) {
            gameBoard [1][i] = new Piece("white","Pawn");
            gameBoard[6][i] = new Piece("black","Pawn");
        }

    }
    public Piece getPiece (int x,int y){
        return gameBoard[x][y];
    }
    public void setPiece(int x, int y, Piece piece) {
        gameBoard[x][y] = piece;
    }
    public boolean movePiece(int x1, int y1, int x2, int y2) {
        Piece piece = getPiece(x1, y1);
        setPiece(x2, y2, piece);
        setPiece(x1, y1, null);
        return true;
    }
    public void  showBoard(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Piece piece = gameBoard[i][j];
                if (piece == null) {
                    System.out.print(" [] ");
                } else {
                    System.out.print(piece.getType() + " ");
                }
            }
            System.out.println();
        }
    }
    public boolean isYourPieceOnSquare(int x, int y, String color) {
        Piece piece = gameBoard[x][y];
        if(piece != null && piece.getColor().equalsIgnoreCase(color)){
            return true;
        }
        return false;
    }

}


