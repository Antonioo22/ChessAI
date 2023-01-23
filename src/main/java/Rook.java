public class Rook extends Piece implements Piece.ChessPiece{
    public Rook(String color) {
        super(color, "King");
    }
    @Override
    public boolean isValidMove(int x1, int y1, int x2, int y2) {
        // Check if the move is horizontal or vertical
        if (x1 == x2 || y1 == y2) {
            return true;
        }
        return false;
    }
    @Override
    public boolean arePiecesInWay(int x1, int y1, int x2, int y2){
        return true;
    }

}
