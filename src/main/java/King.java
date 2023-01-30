public class King extends Piece implements CanMove {
    public King(PieceColor color) {
        super(color);
    }



    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2,Board board) {
        // Check if the move is one square horizontally, vertically, or diagonally
        if (Math.abs(x1 - x2) <= 1 && Math.abs(y1 - y2) <= 1) {
            return true;
        }
        return false;
    }
    public boolean isKingInCheck(PieceColor kingColor, Board board) {
        // Find the coordinates of the king
        int[] kingCoords = findKing(kingColor, board);
        int kingX = kingCoords[0];
        int kingY = kingCoords[1];

        // Check if any opposing pieces can attack the king
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece != null && piece.getColor() != kingColor && piece instanceof CanMove) {
                    CanMove movePiece = (CanMove) piece;
                    if (movePiece.isValidMove(i, j, kingX, kingY,board) && !movePiece.arePiecesInWay(i, j, kingX, kingY, board) ) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private int[] findKing(PieceColor kingColor, Board board) {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                Piece piece = board.getPiece(i, j);
                if (piece instanceof King && piece.getColor() == kingColor) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
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
                if (board.getPiece(x, y) != null && board.getPiece(x, y).getColor() != currentPiece.getColor()) {
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
                    if (board.getPiece(x, y) != null && board.getPiece(x, y).getColor() != currentPiece.getColor()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
