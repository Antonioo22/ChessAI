public class Queen extends Piece implements CanMove {
    public Queen (PieceColor color){
        super(color);
    }
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2,Board board) {
        // Check if the move is along a diagonal, a horizontal, or a vertical line
        if (x1 == x2 || y1 == y2 || Math.abs(x1-x2) == Math.abs(y1-y2)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean arePiecesInWay(int x1, int y1, int x2, int y2, Board board) {
        Piece currentPiece = board.getPiece(x1, y1);
// Check if move is along a diagonal line
        if (Math.abs(x1 - x2) == Math.abs(y1 - y2)) {
            int x = x1;
            int y = y1;
            int xIncrement = x1 < x2 ? 1 : -1;
            int yIncrement = y1 < y2 ? 1 : -1;
            while (x != x2) {
                x += xIncrement;
                y += yIncrement;
                if (board.getPiece(x, y) != null && board.getPiece(x,y).getColor() != currentPiece.getColor()) {
                    return false;
                }
            }
        }
// Check if move is along a horizontal or vertical line
        else if (x1 == x2 || y1 == y2) {
            int xStart = Math.min(x1, x2);
            int xEnd = Math.max(x1, x2);
            int yStart = Math.min(y1, y2);
            int yEnd = Math.max(y1, y2);
            for (int x = xStart + 1; x < xEnd; x++) {
                for (int y = yStart + 1; y < yEnd; y++) {
                    if (board.getPiece(x, y) != null && board.getPiece(x,y).getColor() != currentPiece.getColor()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
