public interface CanMove {


        boolean isValidMove(int x1, int y1, int x2, int y2,Board board);
        default boolean arePiecesInWay(int x1, int y1, int x2, int y2,Board board){
            return false;
        }


}
