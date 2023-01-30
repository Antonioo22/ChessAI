public class Board {
    private int columns = 8;
    private int rows = 8;
    private Piece[][] gameBoard;


    public Board(){
        gameBoard = new Piece[rows][columns];
        initialize();
    }
    private void initialize() {
        gameBoard[7][4] = new King(PieceColor.BLACK);
        gameBoard[0][4] = new King(PieceColor.WHITE);
        gameBoard[0][0] = new Rook(PieceColor.WHITE);
        gameBoard[0][7] = new Rook(PieceColor.WHITE);
        gameBoard[7][0] = new Rook(PieceColor.BLACK);
        gameBoard[7][7] = new Rook(PieceColor.BLACK);
        gameBoard[0][2] = new Bishop(PieceColor.WHITE);
        gameBoard[0][5] = new Bishop(PieceColor.WHITE);
        gameBoard[7][2] = new Bishop(PieceColor.BLACK);
        gameBoard[7][5] = new Bishop(PieceColor.BLACK);
        gameBoard[0][1] = new Knight(PieceColor.WHITE);
        gameBoard[0][6] = new Knight(PieceColor.WHITE);
        gameBoard[7][1] = new Knight(PieceColor.BLACK);
        gameBoard[7][6] = new Knight(PieceColor.BLACK);
        gameBoard[0][3] = new Queen(PieceColor.WHITE);
        gameBoard[7][3] = new Queen(PieceColor.BLACK);
        for (int i = 0; i < 8 ; i++) {
            gameBoard [1][i] = new Pawn(PieceColor.WHITE);
            gameBoard[6][i] = new Pawn(PieceColor.BLACK);
        }



    }

    public Piece getPiece (int x,int y){
        return gameBoard[x][y]  ;
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
    public void showBoard() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                Piece piece = gameBoard[i][j];
                if (piece == null) {
                    System.out.print("<>");
                } else if (piece instanceof King) {
                    System.out.print("K ");
                } else if (piece instanceof Rook) {
                    System.out.print("R ");
                } else if (piece instanceof Bishop) {
                    System.out.print("B ");
                } else if (piece instanceof Knight) {
                    System.out.print("N ");
                } else if (piece instanceof Queen) {
                    System.out.print("Q ");
                } else if (piece instanceof Pawn) {
                    System.out.print("P ");
                }
            }
            System.out.println();
        }
    }
    public boolean isYourPieceOnSquare(int x, int y, PieceColor color) {
        Piece piece = gameBoard[x][y];
        if(piece != null && piece.getColor().equals(color)){
            return true;
        }
        return false;
    }


}


