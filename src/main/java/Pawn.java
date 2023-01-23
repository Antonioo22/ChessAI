public class Pawn extends Piece implements Piece.ChessPiece{
    public Pawn(String color) {
        super(color, "Piece");

    }
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Check if the move is one square horizontally, vertically, or diagonally
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
            return true;
        }
        return false;
    }
    @Override
    public boolean arePiecesInWay(int x1, int y1, int x2, int y2){
        return true;
    }


}
