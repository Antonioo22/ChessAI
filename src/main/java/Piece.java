public class Piece {
    private String color;
    private String type;
    public Piece(String color, String type) {
        this.color = color;
        this.type = type;
    }
    public String getColor() {
        return color;
    }
    public String getType() {
        return type;
    }

    public interface ChessPiece {
        boolean isValidMove(int x1, int y1, int x2, int y2);
        boolean arePiecesInWay(int x1, int y1, int x2, int y2);

    }

}