package acmp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    int x;
    int y;
    int t;
    int u;

    public static void main(String[] args) throws Exception {
        Piece[][] pieces = {
                {Piece.ROOK_WHITE, Piece.KNIGHT_WHITE, Piece.BISHOP_WHITE, Piece.QUEEN_WHITE, Piece.KING_WHITE, Piece.BISHOP_WHITE, Piece.KNIGHT_WHITE, Piece.ROOK_WHITE},
                {Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK},
                {Piece.ROOK_BLACK, Piece.KNIGHT_BLACK, Piece.BISHOP_BLACK, Piece.QUEEN_BLACK, Piece.KING_BLACK, Piece.BISHOP_BLACK, Piece.KNIGHT_BLACK, Piece.ROOK_BLACK}
        };

        int[][] twoDimArray = new int[][] {
                {5, 7, 3, 17},
                {7, 0, 1, 12},
                {8, 3, 2, 3}
        };

        Piece[][] copy = Arrays.stream(pieces).map(Piece[]::clone).toArray(Piece[][]::new);

    }

    @Override
    public String toString() {
        return "Main{" +
                "x=" + x +
                ", y=" + y +
                ", t=" + t +
                ", u=" + u +
                '}';
    }

    public static List<Integer> coordinatesKingWhite(Piece[][] arr) {
        List<Integer> res = new ArrayList<>();

        Piece[][] copy = Arrays.stream(arr).map(Piece[]::clone).toArray(Piece[][]::new);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                if (arr[i][j] == Piece.KING_BLACK) {
                    res.add(i);
                    res.add(j);
                }
            }
        }
        return res;
    }

//
//    public static int print(int[][] arr) throws Exception {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                if (arr[i][j]) {
//                    return 1;
//                } else {
//                    return 0;
//                }
//            }
//            System.out.println();
//        }
//        throw new Exception();
//    }
}
