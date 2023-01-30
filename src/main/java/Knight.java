public class Knight extends Piece implements CanMove {
    public Knight(PieceColor color) {
        super(color);
    }

    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2,Board board) {
        // Check if the move is in an L shape
        if ((Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) || (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2)) {
            return true;
        }
        return false;
    }


}