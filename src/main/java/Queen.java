public class Queen extends Piece implements Piece.ChessPiece {
    public Queen (String color){
        super(color, "Queen");
    }
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Check if the move is along a diagonal, a horizontal, or a vertical line
        if (x1 == x2 || y1 == y2 || Math.abs(x1-x2) == Math.abs(y1-y2)) {
            return true;
        }
        return false;
    }
    @Override
    public boolean arePiecesInWay(int x1, int y1, int x2, int y2){
        return true;
    }

}
