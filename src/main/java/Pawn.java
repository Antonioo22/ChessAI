public class Pawn extends Piece implements CanMove{
    public Pawn(PieceColor color) {
        super(color);
    }
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2,Board board) {
        // Check if the move is two squares forward on the first move
        if (x1 == x2 && y1 - y2 == (getColor() == PieceColor.WHITE ? -2 : 2) && y1 == (getColor() == PieceColor.WHITE ? 6 : 1)) {
            return true;
        }
        // Check if the move is one square forward
        if (x1 == x2 && y1 - y2 == (getColor() == PieceColor.WHITE ? -1 : 1)) {
            return true;
        }
        // Check if the move is diagonal for capturing an enemy piece
        if (Math.abs(x1 - x2) == 1 && y1 - y2 == (getColor() == PieceColor.WHITE ? -1 : 1) && board.getPiece(x2, y2) != null && board.getPiece(x2, y2).getColor() != getColor()) {
            return true;
        }
        return false;
    }@Override
    public boolean arePiecesInWay(int x1, int y1, int x2, int y2, Board board) {
        // Check if the pawn is moving diagonally
        if (x1 != x2 && y1 != y2) {
            // If the destination square is occupied by an enemy piece, it is a valid move
            if (board.isYourPieceOnSquare(x2, y2, this.getColor())) {
                return false;
            } else {
                // If the destination square is not occupied, it is an invalid move
                return true;
            }
        }
        // Check if the pawn is moving vertically
        if (x1 == x2) {
            // Check the direction of the move
            if (this.getColor() == PieceColor.WHITE) {
                // Check if there are any pieces in the way for a white pawn moving up
                for (int i = y1 - 1; i > y2; i--) {
                    if (board.getPiece(x1, i) != null) {
                        return true;
                    }
                }
            } else {
                // Check if there are any pieces in the way for a black pawn moving down
                for (int i = y1 + 1; i < y2; i++) {
                    if (board.getPiece(x1, i) != null) {
                        return true;
                    }
                }
            }
            return false;
        }
        // If the pawn is not moving diagonally or vertically, it is an invalid move
        return true;
    }
}
