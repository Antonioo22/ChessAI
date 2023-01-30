



public class Piece {
    private PieceColor color;
    private String type;

    public PieceColor getColor() {
        return color;
    }
    public Piece(PieceColor color){
        this.color = color;
    }

    public void setColor(PieceColor color) {
        this.color = color;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}