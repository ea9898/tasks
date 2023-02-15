package chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.LongStream;

class Main {

    public static void main(String[] args) throws Exception {
        Piece[][] arr1 = {
                {Piece.ROOK_WHITE, Piece.KNIGHT_WHITE, Piece.BISHOP_WHITE, Piece.QUEEN_WHITE, Piece.KING_WHITE, Piece.BISHOP_WHITE, Piece.KNIGHT_WHITE, Piece.ROOK_WHITE},
                {Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE, Piece.PAWN_WHITE},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY, Piece.EMPTY},
                {Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK, Piece.PAWN_BLACK},
                {Piece.ROOK_BLACK, Piece.KNIGHT_BLACK, Piece.BISHOP_BLACK, Piece.QUEEN_BLACK, Piece.KING_BLACK, Piece.BISHOP_BLACK, Piece.KNIGHT_BLACK, Piece.ROOK_BLACK}
        };


        //boolean[][] mapThreat = new boolean[8][8];
        //Arrays.mapThreat, false);
        //colorPiece(Piece.KING_WHITE);
        //coordinatesKing(mapThreat, 3, 2);
        //coordinatesKnight(mapThreat, 3, 2); // 3 горизанталь 2 вертикаль
        //coordinatesRook(mapThreat, 4, 3);
        //coordinatesBishop(mapThreat, 4, 3);
        //coordinatesQueen(mapThreat, 3, 3);
        //coordinatesPawn(mapThreat, 3, 7);
        //allThreatMap(arr1, mapThreat, ColorPiece.WHITE);
        //int[] arr = findKing(arr1, ColorPiece.BLACK);
        //System.out.println(arr[0] + " " + arr[1]);
        //System.out.println(checkKing(arr1, ColorPiece.WHITE));
        //kingMoves(1, 2);
        //Move move = new Move(4, 0, 4, 1);
        //makeMove(move, arr1);
        //printMove(kingMoves(4, 5), arr1);
        //printMove(pawnMovesWhite(arr1, 1, 1), arr1);
        //printMove(pawnMovesBlack(arr1, 1, 6), arr1);
        //printMove(knightMoves(4, 5), arr1);
        //printMove(listCoordinatesRook(arr1, 4, 5), arr1);
        //printMove(listCoordinatesBishop(arr1, 4, 5), arr1);
        //printMove(allMoves(arr1, ColorPiece.BLACK), arr1);
        //System.out.println(allMoves(arr1, ColorPiece.WHITE));
        //printMove(filterIllegalMoves(allMoves(arr1, ColorPiece.BLACK), arr1), arr1);
        //System.out.println(moveFromText("a2b3"));
        //print(inputMove(arr1, ColorPiece.WHITE));
//        inputMovePlayer(arr1, ColorPiece.WHITE);
        //print(mapThreat);

        calcCircleRadius(10);
    }

    public static void calcCircleRadius(double area) {
//        double circumference = Math.PI * 2 * area;
//        System.out.printf("%.3f", circumference);

        double pi = 3.14159;
        double circumference = (2 * pi * area);
        double area2 = (pi * (area * 2));
        System.out.println("The radius of the circle " + area);
        System.out.println("The circumference of the circle " + circumference);
        System.out.println("The area of the circle " + area2);
    }

    // функция которая меняет игрока каждый ход
    public static void inputMovePlayer(Piece[][] p, ColorPiece color) throws Exception {
        color = color.WHITE;
        print(p);
        while (true) {
            print(inputMove(p, color));
            if (color == ColorPiece.WHITE) {
                color = ColorPiece.BLACK;
                System.out.println(ColorPiece.BLACK);
            } else {
                color = ColorPiece.WHITE;
                System.out.println(ColorPiece.WHITE);
            }
        }
    }

    // функция принимает ход ввиде строки
    public static Move moveFromText(String move) {
        int departureX = move.charAt(0) - 97;
        int departureY = move.charAt(1) - 48;
        int arrivalX = move.charAt(2) - 97;
        int arrivalY = move.charAt(3) - 48;

        return new Move(departureX, departureY - 1, arrivalX, arrivalY - 1);
    }

    // функция делает ход на доске
    public static Piece[][] inputMove(Piece[][] p, ColorPiece color) throws Exception {
        Scanner sc = new Scanner(System.in);

        String move = null;
        while (sc.hasNextLine()) {
            move = sc.nextLine();
            Pattern pattern = Pattern.compile("[a-h][1-8][a-h][1-8]");
            Matcher matcher = pattern.matcher(move);
            if (!matcher.matches()) {
                System.out.println("попробуйте еще раз");
            }
        }

        if (allMoves(p, color).contains(moveFromText(move))) {
            makeMove(moveFromText(move), p);
        }

        return p;
    }

    // печать всех фигур на доске
    public static void print(Piece[][] p) {
        System.out.println("  ABCDEFGH");

        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < 8; j++) {
                if (p[i][j] == Piece.ROOK_WHITE) {
                    System.out.print("R");
                } else if (p[i][j] == Piece.KNIGHT_WHITE) {
                    System.out.print("G");
                } else if (p[i][j] == Piece.BISHOP_WHITE) {
                    System.out.print("B");
                } else if (p[i][j] == Piece.QUEEN_WHITE) {
                    System.out.print("Q");
                } else if (p[i][j] == Piece.KING_WHITE) {
                    System.out.print("K");
                } else if (p[i][j] == Piece.PAWN_WHITE) {
                    System.out.print("P");
                } else if (p[i][j] == Piece.EMPTY) {
                    System.out.print("_");
                } else if (p[i][j] == Piece.ROOK_BLACK) {
                    System.out.print("r");
                } else if (p[i][j] == Piece.KNIGHT_BLACK) {
                    System.out.print("g");
                } else if (p[i][j] == Piece.BISHOP_BLACK) {
                    System.out.print("b");
                } else if (p[i][j] == Piece.QUEEN_BLACK) {
                    System.out.print("q");
                } else if (p[i][j] == Piece.KING_BLACK) {
                    System.out.print("k");
                } else if (p[i][j] == Piece.PAWN_BLACK) {
                    System.out.print("p");
                }
            }
            System.out.println();
        }
    }

    // ход фигуры с заменой
    public static void makeMove(Move m, Piece[][] p) {
        p[m.getArrivalY()][m.getArrivalX()] = p[m.getDepartureY()][m.getDepartureX()];
        p[m.getDepartureY()][m.getDepartureX()] = Piece.EMPTY;
    }

    // печать ходов
    public static void printMove(List<Move> move, Piece[][] p) {
        for (int i = 0; i < move.size(); i++) {
            Piece[][] copy = Arrays.stream(p).map(Piece[]::clone).toArray(Piece[][]::new);
            //System.out.print(move.get(i).getDepartureX());
            //System.out.print(move.get(i).getDepartureY());
            //System.out.print(move.get(i).getArrivalX());
            //System.out.print(move.get(i).getArrivalY());
            makeMove(move.get(i), copy);
            print(copy);
        }
    }

    // копирование всех фигур
    public static Piece[][] clonePiece(Piece[][] p) {
        return Arrays.stream(p).map(Piece[]::clone).toArray(Piece[][]::new);
    }

    // печать расположения фигур и пустых клеток
    public static void print(boolean[][] arr) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (arr[i][j]) {
                    System.out.print("X" + " ");
                } else {
                    System.out.print("." + " ");
                }
            }
            System.out.println();
        }
    }

    // проверка выхода за границы и цвета фигуры
    public static boolean checkBoundaryAndColorPiece(Piece arrivalP, Piece departureP) throws Exception {
        if ((arrivalP != Piece.EMPTY && colorPiece(arrivalP) != colorPiece(departureP)) || arrivalP == Piece.EMPTY) {
            return true;
        }
        return false;
    }

    // возвращает цвет фигуры
    public static ColorPiece colorPiece(Piece p) throws Exception {
        Piece[] arrW = {Piece.ROOK_WHITE, Piece.KNIGHT_WHITE, Piece.BISHOP_WHITE, Piece.BISHOP_WHITE, Piece.QUEEN_WHITE, Piece.KING_WHITE, Piece.PAWN_WHITE};
        Piece[] arrB = {Piece.ROOK_BLACK, Piece.KNIGHT_BLACK, Piece.BISHOP_BLACK, Piece.BISHOP_BLACK, Piece.QUEEN_BLACK, Piece.KING_BLACK, Piece.PAWN_BLACK};

        for (int i = 0; i < arrW.length; i++) {
            if (p == arrW[i]) {
                return ColorPiece.WHITE;
            } else if (p == arrB[i]) {
                return ColorPiece.BLACK;
            }
        }

        throw new Exception("" + p);
    }

    // координаты короля, карта угроз короля
    public static void coordinatesKing(boolean[][] mapThreat, Piece[][] arr, int x, int y) { // карта угроз короля
        int[] arrX = {x - 1, x - 1, x - 1, x + 1, x + 1, x + 1, x, x};
        int[] arrY = {y - 1, y, y + 1, y - 1, y, y + 1, y - 1, y + 1};

        for (int i = 0; i < 8; i++) {
            if (checkBoundary(arrX[i], arrY[i])) {
                mapThreat[arrY[i]][arrX[i]] = true;
            }
        }
    }

    // возвращает список всех ходов короля
    public static List<Move> kingMoves(Piece[][] p, int x, int y) throws Exception {
        int[] arrX = {x - 1, x - 1, x - 1, x + 1, x + 1, x + 1, x, x};
        int[] arrY = {y - 1, y, y + 1, y - 1, y, y + 1, y - 1, y + 1};
        List<Move> listMove = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            if (checkBoundary(arrX[i], arrY[i]) && checkBoundaryAndColorPiece(p[arrY[i]][arrX[i]], p[y][x])) {
                Move move = new Move(x, y, arrX[i], arrY[i]);
                listMove.add(move);
            }
        }

        return listMove;
    }

    // проверяем открылся ли король для каждого хода в списке move, такие хода называются illigal(нелегальные)
    public static List<Move> filterIllegalMoves(List<Move> move, Piece[][] p) throws Exception {
        List<Move> listMove = new ArrayList<>();

        for (int i = 0; i < move.size(); i++) {
            Piece[][] cloneP = clonePiece(p);
            makeMove(move.get(i), cloneP);

            if (!checkKing(cloneP, colorPiece(cloneP[move.get(i).getArrivalY()][move.get(i).getArrivalX()]))) {
                listMove.add(move.get(i));
            }
        }

        return listMove;
    }

    // хода коня
    public static List<Move> knightMoves(Piece[][] p, int x, int y) throws Exception {
        int[] arrX = {x - 1, x + 1, x + 2, x + 2, x + 1, x - 1, x - 2, x - 2};
        int[] arrY = {y - 2, y - 2, y - 1, y + 1, y + 2, y + 2, y + 1, y - 1};
        List<Move> listMove = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            if (checkBoundary(arrX[i], arrY[i]) && checkBoundaryAndColorPiece(p[arrY[i]][arrX[i]], p[y][x])) { // метод отвечает за цвет но не за выход за границу
                Move move = new Move(x, y, arrX[i], arrY[i]);
                listMove.add(move);
            }
        }
        return listMove;
    }

    // ход белой пешки
    public static List<Move> pawnMovesWhite(Piece[][] p, int x, int y) {
        List<Move> listMove = new ArrayList<>();

        if (y == 1) {
            if (checkBoundary(x, y + 2) && p[y + 2][x] == Piece.EMPTY) {
                listMove.add(new Move(x, y, x, y + 2));
            }
        }

        if (checkBoundary(x, y + 1) && p[y + 1][x] == Piece.EMPTY) {
            listMove.add(new Move(x, y, x, y + 1));
        }
        if (checkBoundary(x - 1, y + 1) && p[y + 1][x - 1] != Piece.EMPTY) {
            listMove.add(new Move(x, y, x - 1, y + 1));
        }
        if (checkBoundary(x + 1, y + 1) && p[y + 1][x + 1] != Piece.EMPTY) {
            listMove.add(new Move(x, y, x + 1, y + 1));
        }

        return listMove;
    }

    // ход черной пешки
    public static List<Move> pawnMovesBlack(Piece[][] p, int x, int y) {
        List<Move> listMove = new ArrayList<>();

        if (y == 6) {
            if (checkBoundary(x, y - 2) && p[y - 2][x] == Piece.EMPTY) {
                listMove.add(new Move(x, y, x, y - 2));
            }
        }

        if (checkBoundary(x, y - 1) && p[y - 1][x] == Piece.EMPTY) {
            listMove.add(new Move(x, y, x, y - 1));
        }
        if (checkBoundary(x - 1, y - 1) && p[y - 1][x - 1] != Piece.EMPTY) {
            listMove.add(new Move(x, y, x - 1, y - 1));
        }
        if (checkBoundary(x + 1, y - 1) && p[y - 1][x + 1] != Piece.EMPTY) {
            listMove.add(new Move(x, y, x + 1, y - 1));
        }
        return listMove;
    }

    // поиск короля и цвета
    public static int[] findKing(Piece[][] arr, ColorPiece color) throws Exception {
        int[] list = new int[2];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                if (color == ColorPiece.WHITE && arr[y][x] == Piece.KING_WHITE) {
                    list[0] = y;
                    list[1] = x;
                    return list;
                } else if (color == ColorPiece.BLACK && arr[y][x] == Piece.KING_BLACK) {
                    list[0] = y;
                    list[1] = x;
                    return list;
                }
            }
        }
        throw new Exception("Нет короля");
    }

    // состовляем карту угроз, проверяем короля
    public static boolean checkKing(Piece[][] piece, ColorPiece color) throws Exception {
        boolean[][] mapThreat = new boolean[8][8]; // карта угроз

        allThreatMap(piece, mapThreat, color == ColorPiece.WHITE ? ColorPiece.BLACK : ColorPiece.WHITE); // состовляем карту угроз

        int[] cK = findKing(piece, color); // коородинаты короля

        return mapThreat[cK[0]][cK[1]];
    }

    // проверка выхода за границы
    public static boolean checkBoundary(int x, int y) {
        return x < 8 && x >= 0 && y < 8 && y >= 0;
    }

    // координаты коня
    public static void coordinatesKnight(boolean[][] mapThreat, Piece[][] arr, int x, int y) {
        int[] arrX = {x - 1, x + 1, x + 2, x + 2, x + 1, x - 1, x - 2, x - 2};
        int[] arrY = {y - 2, y - 2, y - 1, y + 1, y + 2, y + 2, y + 1, y - 1};

        for (int i = 0; i < 8; i++) {
            if (checkBoundary(arrX[i], arrY[i])) {
                mapThreat[arrY[i]][arrX[i]] = true;
            }
        }
    }

    // ход башни с проверкой выхода за границы
    public static void lineRook(boolean[][] mapThreat, Piece[][] arr, int x, int y, int dX, int dY) {
        for (int x1 = x + dX, y1 = y + dY; checkBoundary(x1, y1); x1 = x1 + dX, y1 = y1 + dY) {
            if (arr[y1][x1] == Piece.EMPTY) {
                mapThreat[y1][x1] = true;
            }
            if (arr[y1][x1] != Piece.EMPTY) {
                mapThreat[y1][x1] = true;
                break;
            }
        }
    }

    // все хода башни с проверкой выхода за границы
    public static List<Move> listLineRook(Piece[][] arr, int x, int y, int dX, int dY) {
        List<Move> listMove = new ArrayList<>();

        for (int x1 = x + dX, y1 = y + dY; checkBoundary(x1, y1); x1 = x1 + dX, y1 = y1 + dY) {
            if (arr[y1][x1] == Piece.EMPTY) {
                Move move = new Move(x, y, x1, y1);
                listMove.add(move);
            }
            if (arr[y1][x1] != Piece.EMPTY) {
                //Move move = new Move(x, y, x1,  y1);
                //listMove.add(move);
                break;
            }
        }
        return listMove;
    }

    // координаты башни
    public static void coordinatesRook(boolean[][] mapThreat, Piece[][] arr, int x, int y) {
        lineRook(mapThreat, arr, x, y, 1, 0);
        lineRook(mapThreat, arr, x, y, 0, 1);
        lineRook(mapThreat, arr, x, y, -1, 0);
        lineRook(mapThreat, arr, x, y, 0, -1);
    }

    // все координаты башни
    public static List<Move> listCoordinatesRook(Piece[][] arr, int x, int y) {
        List<Move> listMove = new ArrayList<>();

        listMove.addAll(listLineRook(arr, x, y, 1, 0));
        listMove.addAll(listLineRook(arr, x, y, 0, 1));
        listMove.addAll(listLineRook(arr, x, y, -1, 0));
        listMove.addAll(listLineRook(arr, x, y, 0, -1));

        return listMove;
    }

    // координаты слона
    public static void coordinatesBishop(boolean[][] mapThreat, Piece[][] arr, int x, int y) {
        lineRook(mapThreat, arr, x, y, 1, 1);
        lineRook(mapThreat, arr, x, y, -1, -1);
        lineRook(mapThreat, arr, x, y, 1, -1);
        lineRook(mapThreat, arr, x, y, -1, 1);
    }

    // все координаты слона
    public static List<Move> listCoordinatesBishop(Piece[][] p, int x, int y) {
        List<Move> listMove = new ArrayList<>();

        listMove.addAll(listLineRook(p, x, y, 1, 1));
        listMove.addAll(listLineRook(p, x, y, -1, -1));
        listMove.addAll(listLineRook(p, x, y, 1, -1));
        listMove.addAll(listLineRook(p, x, y, -1, 1));

        return listMove;
    }

    // координаты королевы
    public static void coordinatesQueen(boolean[][] mapThreat, Piece[][] arr, int x, int y) {
        coordinatesRook(mapThreat, arr, x, y);
        coordinatesBishop(mapThreat, arr, x, y);
    }

    // все координаты королевы
    public static List<Move> listCoordinatesQueen(Piece[][] p, int x, int y) {
        List<Move> listMove = new ArrayList<>();

        listMove.addAll(listCoordinatesRook(p, x, y));
        listMove.addAll(listCoordinatesBishop(p, x, y));

        return listMove;
    }

    // координаты белой пешки
    public static void coordinatesPawnWhite(boolean[][] mapThreat, Piece[][] arr, int x, int y) throws Exception {
        if (checkBoundary(y + 1, x + 1)) {
            mapThreat[y + 1][x + 1] = true;
        }

        if (checkBoundary(y + 1, x - 1)) {
            mapThreat[y + 1][x - 1] = true;
        }
    }

    // координаты черной пешки
    public static void coordinatesPawnBlack(boolean[][] mapThreat, Piece[][] arr, int x, int y) throws Exception {
        if (checkBoundary(y - 1, x + 1)) {
            mapThreat[y - 1][x + 1] = true;
        }

        if (checkBoundary(y - 1, x - 1)) {
            mapThreat[y - 1][x - 1] = true;
        }
    }

    // карта всех угроз
    public static void allThreatMap(Piece[][] p, boolean[][] mapThreat, ColorPiece color) throws Exception {
        for (int x1 = 0; x1 < 8; x1++) { // перебираем доску
            for (int y1 = 0; y1 < 8; y1++) {

                if (p[y1][x1] != Piece.EMPTY && colorPiece(p[y1][x1]) == color) {
                    if (p[y1][x1] == Piece.ROOK_WHITE) {
                        coordinatesRook(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.KNIGHT_WHITE) {
                        coordinatesKnight(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.BISHOP_WHITE) {
                        coordinatesBishop(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.QUEEN_WHITE) {
                        coordinatesQueen(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.KING_WHITE) {
                        coordinatesKing(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.PAWN_WHITE) {
                        coordinatesPawnWhite(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.ROOK_BLACK) {
                        coordinatesRook(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.KNIGHT_BLACK) {
                        coordinatesKnight(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.BISHOP_BLACK) {
                        coordinatesBishop(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.QUEEN_BLACK) {
                        coordinatesQueen(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.KING_BLACK) {
                        coordinatesKing(mapThreat, p, x1, y1);
                    } else if (p[y1][x1] == Piece.PAWN_BLACK) {
                        coordinatesPawnBlack(mapThreat, p, x1, y1);
                    }
                }
            }
        }
    }

    // все хода
    public static List<Move> allMoves(Piece[][] p, ColorPiece color) throws Exception {
        List<Move> allMoves = new ArrayList<>();

        for (int y1 = 0; y1 < 8; y1++) { // перебираем доску
            for (int x1 = 0; x1 < 8; x1++) {
                if (p[y1][x1] != Piece.EMPTY && colorPiece(p[y1][x1]) == color) {
                    if (p[y1][x1] == Piece.ROOK_WHITE) {
                        allMoves.addAll(listCoordinatesRook(p, x1, y1));
                    } else if (p[y1][x1] == Piece.KNIGHT_WHITE) {
                        allMoves.addAll(knightMoves(p, x1, y1));
                    } else if (p[y1][x1] == Piece.BISHOP_WHITE) {
                        allMoves.addAll(listCoordinatesBishop(p, x1, y1));
                    } else if (p[y1][x1] == Piece.QUEEN_WHITE) {
                        allMoves.addAll(listCoordinatesQueen(p, x1, y1));
                    } else if (p[y1][x1] == Piece.KING_WHITE) {
                        allMoves.addAll(kingMoves(p, x1, y1));
                    } else if (p[y1][x1] == Piece.PAWN_WHITE) {
                        allMoves.addAll(pawnMovesWhite(p, x1, y1));
                    } else if (p[y1][x1] == Piece.ROOK_BLACK) {
                        allMoves.addAll(listCoordinatesRook(p, x1, y1));
                    } else if (p[y1][x1] == Piece.KNIGHT_BLACK) {
                        allMoves.addAll(knightMoves(p, x1, y1));
                    } else if (p[y1][x1] == Piece.BISHOP_BLACK) {
                        allMoves.addAll(listCoordinatesBishop(p, x1, y1));
                    } else if (p[y1][x1] == Piece.QUEEN_BLACK) {
                        allMoves.addAll(listCoordinatesQueen(p, x1, y1));
                    } else if (p[y1][x1] == Piece.KING_BLACK) {
                        allMoves.addAll(kingMoves(p, x1, y1));
                    } else if (p[y1][x1] == Piece.PAWN_BLACK) {
                        allMoves.addAll(pawnMovesBlack(p, x1, y1));
                    }
                }
            }
        }
        return allMoves;
    }
}

