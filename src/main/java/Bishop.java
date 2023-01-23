public class Bishop extends Piece implements Piece.ChessPiece {
    public Bishop(String color) {
        super(color, "Bishop");
    }

    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Check if the move is along a diagonal line
        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            return true;
        }
        return false;

    }
    @Override
    public boolean arePiecesInWay(int x1, int y1, int x2, int y2){
        return true;
    }

}

