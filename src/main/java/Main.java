import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.showBoard();
        Scanner scanner = new Scanner(System.in);
        boolean whiteTurn = true;
        while (whiteTurn) {
            System.out.println("Enter the coordinates of the piece you want to move (x1 y1 x2 y2) or type 'exit' to quit:");
            String input = scanner.nextLine();
            if (input.equals("exit")) {
                break;
            }
            String[] coordinates = input.split(" ");
            int x1 = Integer.parseInt(coordinates[0]);
            int y1 = Integer.parseInt(coordinates[1]);
            int x2 = Integer.parseInt(coordinates[2]);
            int y2 = Integer.parseInt(coordinates[3]);
            Piece piece = board.getPiece(x1, y1);
            if ( piece instanceof CanMove) {
                CanMove movePiece = (CanMove) piece;
                if (movePiece.arePiecesInWay(x1, y1, x2, y2, board) && board.isYourPieceOnSquare(x2, y2, piece.getColor())) {
                    board.movePiece(x1, y1, x2, y2);
                    board.showBoard();
                    whiteTurn = false;
                } else {
                    System.out.println("Invalid move, try again");
                }
            } else {
                System.out.println("There is no piece on that square or the piece cannot move");
            }
        }
        scanner.close();
    }
}
