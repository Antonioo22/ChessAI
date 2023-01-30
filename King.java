public class King extends Piece implements sPiece {
    public King(String color) {
        super(color, "King");
    }
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Check if the move is one square horizontally, vertically, or diagonally
        if (Math.abs(x1 - x2) <=1  && Math.abs(y1 - y2) <= 1) {
            return true;
        }
        return false;
    }
}
