
//package Tamrin;
//Rambod
import java.util.*;
import java.lang.Math;

public class countCorrectChessMove {
    boolean a, z, sS;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] pieces = new String[n];

        int kingC = 0, queenC = 0, bishopC = 0, knightC = 0, rockC = 0, pawnC = 0;

        String[][] obj = new String[n][3];

        for (int i = 0; i < n; i++) {
            pieces[i] = input.next();
            char[] sideOf = { pieces[i].charAt(0) };
            obj[i][0] = new String(sideOf);
            char[] noe = { pieces[i].charAt(1) };
            obj[i][1] = new String(noe);
            char[] a = { pieces[i].toCharArray()[2], pieces[i].toCharArray()[3] };
            obj[i][2] = new String(a);

            if (obj[i][1].equals("K"))
                kingC++;
            else if (obj[i][1].equals("Q"))
                queenC++;
            else if (obj[i][1].equals("B"))
                bishopC++;
            else if (obj[i][1].equals("N"))
                knightC++;
            else if (obj[i][1].equals("R"))
                rockC++;
            else if (obj[i][1].equals("P"))
                pawnC++;

        }
        Board.fillBoard(obj, n);
        K[] kings = new K[kingC];
        Q[] queens = new Q[queenC];
        B[] bishops = new B[bishopC];
        N[] knights = new N[knightC];
        R[] rooks = new R[rockC];
        P[] pawns = new P[pawnC];
        for (int i = 0; i < n; i++) {
            if (obj[i][1].equals("K"))
                kings[kings.length - kingC--] = new K(obj[i][0], obj[i][1], obj[i][2]);
            else if (obj[i][1].equals("Q"))
                queens[queens.length - queenC--] = new Q(obj[i][0], obj[i][1], obj[i][2]);
            else if (obj[i][1].equals("B"))
                bishops[bishops.length - bishopC--] = new B(obj[i][0], obj[i][1], obj[i][2]);
            else if (obj[i][1].equals("N"))
                knights[knights.length - knightC--] = new N(obj[i][0], obj[i][1], obj[i][2]);
            else if (obj[i][1].equals("R"))
                rooks[rooks.length - rockC--] = new R(obj[i][0], obj[i][1], obj[i][2]);
            else if (obj[i][1].equals("P"))
                pawns[pawns.length - pawnC--] = new P(obj[i][0], obj[i][1], obj[i][2]);
        }

        int m = input.nextInt();
        String[] questions = new String[m];
        for (int i = 0; i < m; i++) {
            questions[i] = input.next();
        }

        int[] answer = new int[m];

        for (int i = 0; i < m; i++) {
            int j, Shomaresh = 0;
            for (j = 0; j < n; j++) {
                if (questions[i].equals(obj[j][2])) {
                    for (int k = 0; k < j; k++) {
                        if (obj[k][1].equals(obj[j][1]))
                            Shomaresh++;
                    }
                    break;
                }
            }

            for (int x = 0; x < Board.n; x++) {
                for (int y = 0; y < Board.n; y++) {
                    char[] target0 = { (char) ('A' + x), (char) ('1' + y) };
                    String target1 = new String(target0);

                    if (target1.charAt(0) > 'H' || target1.charAt(1) > '8') {
                        break;
                    } else if (obj[j][1].equals("K")) {
                        if (!kings[Shomaresh].movable(target1).equals("NO"))
                            answer[i]++;
                    } else if (obj[j][1].equals("Q")) {
                        if (!queens[Shomaresh].movable(target1).equals("NO"))
                            answer[i]++;
                    } else if (obj[j][1].equals("B")) {
                        if (!bishops[Shomaresh].movable(target1).equals("NO"))
                            answer[i]++;
                    } else if (obj[j][1].equals("N")) {
                        if (!knights[Shomaresh].movable(target1).equals("NO"))
                            answer[i]++;
                    } else if (obj[j][1].equals("R")) {
                        if (!rooks[Shomaresh].movable(target1).equals("NO"))
                            answer[i]++;
                    } else if (obj[j][1].equals("P")) {
                        if (!pawns[Shomaresh].movable(target1).equals("NO"))
                            answer[i]++;
                    }

                }
            }

            // if (j < n) {
            // char[] tar = { questions[i].charAt(2), questions[i].charAt(3) };
            // String target1 = new String(target0);
            // if(target1.charAt(0) > 'H' || target1.charAt(1) > '8')
            // answer[i] = "NO";
            // else if (obj[j][1].equals("K")) {
            // answer[i] = kings[Shomaresh].movable(target1);
            // } else if (obj[j][1].equals("Q")) {
            // answer[i] = queens[Shomaresh].movable(target1);
            // } else if (obj[j][1].equals("B")) {
            // answer[i] = bishops[Shomaresh].movable(target1);
            // } else if (obj[j][1].equals("N")) {
            // answer[i] = knights[Shomaresh].movable(target1);
            // } else if (obj[j][1].equals("R")) {
            // answer[i] = rooks[Shomaresh].movable(target1);
            // } else if (obj[j][1].equals("P")) {
            // answer[i] = pawns[Shomaresh].movable(target1);
            // }
            // } else
            // answer[i] ="NO";

        }

        for (int i = 0; i < m; i++) {
            if (i == m - 1)
                System.out.print(answer[i]);
            else
                System.out.println(answer[i]);
        }
        input.close();

    }

    public static class Board {
        final static int n = 8;
        static String[][] fulled_Board = new String[n][n];

        public static boolean checking_The_Position(char first, char second) {
            if (first - 'A' < n && second - '1' < n)
                return true;
            else
                return false;
        }

        public static void fillBoard(String[][] obj, int n) {
            for (int i = 0; i < n; i++) {
                char[] x = { obj[i][0].charAt(0), obj[i][1].charAt(0) };
                fulled_Board[Board.n - (obj[i][2].charAt(1) - 49) - 1][obj[i][2].charAt(0) - 65] = new String(
                        x);
            }
            for (int i = 0; i < Board.n; i++)
                for (int j = 0; j < Board.n; j++)
                    if (fulled_Board[i][j] == null) {
                        fulled_Board[i][j] = "None";
                    }
        }
    }

    public static class K {
        String sideOf;
        String noe;
        String position;

        public K(String sideOf, String noe, String position) {
            this.sideOf = sideOf;
            this.noe = noe;
            this.position = position;
        }

        public String movable(String target1) {
            boolean a = sideOf.charAt(
                    0) != Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].charAt(0);
            if ((Board.checking_The_Position(position.charAt(0), position.charAt(1))
                    && Board.checking_The_Position(target1.charAt(0), target1.charAt(1))) && a)
                if (Math.abs(target1.charAt(0) - position.charAt(0)) <= 1
                        && (Math.abs(target1.charAt(1) - position.charAt(1))) <= 1)
                    return Taked(target1);
            return "NO";
        }

        public String Taked(String target1) {
            if (Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].equals("None"))
                return "YES";
            return "TAKE";
        }

    }

    public static class Q {
        String sideOf;
        String noe;
        String position;

        public Q(String sideOf, String noe, String position) {
            this.sideOf = sideOf;
            this.noe = noe;
            this.position = position;
        }

        public String movable(String target1) {
            B biq = new B(sideOf, noe, position);
            R rooq = new R(sideOf, noe, position);

            if (biq.movable(target1).equals("TAKE") || rooq.movable(target1).equals("TAKE"))
                return "TAKE";

            else if ((biq.movable(target1).equals("YES") || rooq.movable(target1).equals("YES")))
                return "YES";

            else
                return "NO";
        }

    }

    public static class B {
        String sideOf;
        String noe;
        String position;

        public B(String sideOf, String noe, String position) {
            this.sideOf = sideOf;
            this.noe = noe;
            this.position = position;
        }

        public String movable(String target1) {
            boolean a = sideOf.charAt(
                    0) != Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].charAt(0);

            if ((Board.checking_The_Position(position.charAt(0), position.charAt(1))
                    && Board.checking_The_Position(target1.charAt(0), target1.charAt(1))
                    && a)) {
                int diff = target1.charAt(0) - position.charAt(0);
                diff = (diff < 0) ? -diff : diff;
                if (target1.charAt(0) - position.charAt(0) == target1.charAt(1) - position.charAt(1)) {
                    boolean z = true;
                    boolean sS = target1.charAt(1) > position.charAt(1);
                    for (char i = 1; i < diff; i++) {
                        char[] mid = new char[2];
                        if (sS) {
                            mid[0] = (char) (position.charAt(0) + i);
                            mid[1] = (char) (position.charAt(1) + i);
                        } else {
                            mid[0] = (char) (target1.charAt(0) + i);
                            mid[1] = (char) (target1.charAt(1) + i);
                        }

                        if (Taked(new String(mid))) {
                            z = false;
                            break;
                        }
                    }

                    if (z) {
                        if (Taked(target1))
                            return "TAKE";
                        else
                            return "YES";
                    }
                } else if (target1.charAt(0) - position.charAt(0) == -(target1.charAt(1) - position.charAt(1))) {
                    boolean z = true;
                    boolean sS = target1.charAt(0) > position.charAt(0);
                    for (char i = 1; i < diff; i++) {
                        char[] mid = new char[2];
                        if (sS) {
                            mid[0] = (char) (position.charAt(0) + i);
                            mid[1] = (char) (position.charAt(1) - i);
                        } else {
                            mid[0] = (char) (target1.charAt(0) + i);
                            mid[1] = (char) (target1.charAt(1) - i);
                        }

                        if (Taked(new String(mid))) {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        if (Taked(target1))
                            return "TAKE";
                        else
                            return "YES";
                    }
                }
            }

            return "NO";
        }

        public boolean Taked(String target1) {
            if (Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].equals("None"))
                return false;
            else
                return true;
        }

    }

    public static class N {
        String sideOf;
        String noe;
        String position;

        public N(String sideOf, String noe, String position) {
            this.sideOf = sideOf;
            this.noe = noe;
            this.position = position;
        }

        public String movable(String target1) {
            int convar1 = Math.abs(target1.charAt(0) - position.charAt(0));
            int convar2 = Math.abs((target1.charAt(1)) - position.charAt(1));
            boolean a = sideOf.charAt(
                    0) != Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].charAt(0);

            if ((Board.checking_The_Position(position.charAt(0), position.charAt(1))
                    && Board.checking_The_Position(target1.charAt(0), target1.charAt(1))
                    && a))
                if (convar1 != 3 && convar1 != 0 && convar1 + convar2 == 3)
                    return Taked(target1);
            return "NO";
        }

        public String Taked(String target1) {
            if (Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].equals("None"))
                return "YES";
            return "TAKE";
        }

    }

    public static class R {
        String sideOf;
        String noe;
        String position;

        public R(String sideOf, String noe, String position) {
            this.sideOf = sideOf;
            this.noe = noe;
            this.position = position;
        }

        public String movable(String target1) {
            boolean z = true;
            boolean a = sideOf.charAt(
                    0) != Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].charAt(0);

            if ((Board.checking_The_Position(position.charAt(0), position.charAt(1))
                    && Board.checking_The_Position(target1.charAt(0), target1.charAt(1))
                    && a)) {
                if (target1.charAt(0) == position.charAt(0)) {
                    for (char j = (char) (((target1.charAt(1) > position.charAt(1)) ? position.charAt(1)
                            : target1.charAt(1)) + 1); j < ((target1.charAt(1) > position.charAt(1))
                                    ? target1.charAt(1)
                                    : position.charAt(1)); j++) {
                        if (!Board.fulled_Board[Board.n - ((j) - 49) - 1][target1.charAt(0) - 'A'].equals("None")) {
                            z = false;
                            break;
                        }
                    }
                    if (z)
                        return Taked(target1);
                } else if (target1.charAt(1) == position.charAt(1)) {
                    for (char i = (char) (((target1.charAt(0) > position.charAt(0)) ? position.charAt(0)
                            : target1.charAt(0)) + 1); i < ((target1.charAt(0) > position.charAt(0))
                                    ? target1.charAt(0)
                                    : position.charAt(0)); i++) {
                        if (!Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][i - 'A'].equals("None")) {
                            z = false;
                            break;
                        }
                    }
                    if (z)
                        return Taked(target1);
                }
            }
            return "NO";
        }

        public String Taked(String target1) {
            if (Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].equals("None"))
                return "YES";
            return "TAKE";
        }

    }

    public static class P {
        String sideOf;
        String noe;
        String position;

        public P(String sideOf, String noe, String position) {
            this.sideOf = sideOf;
            this.noe = noe;
            this.position = position;
        }

        public String movable(String target1) {
            boolean a = sideOf.charAt(
                    0) != Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].charAt(0);

            if ((Board.checking_The_Position(position.charAt(0), position.charAt(1))
                    && Board.checking_The_Position(target1.charAt(0), target1.charAt(1))
                    && a)) {
                if (target1.charAt(0) == position.charAt(0)) {
                    if (sideOf.equals("W")) {
                        if (target1.charAt(1) - position.charAt(1) == 1) {
                            if (!Taked(target1))
                                return "YES";
                        } else if (target1.charAt(1) - position.charAt(1) == 2 && position.charAt(1) == '2') {
                            char[] mid = { position.charAt(0), (char) (position.charAt(1) + 1) };
                            if (!Taked(new String(mid)))
                                if (!Taked(target1))
                                    return "YES";
                        }
                    } else if (sideOf.equals("B")) {
                        if (target1.charAt(1) - position.charAt(1) == -1) {
                            if (!Taked(target1))
                                return "YES";
                        } else if (target1.charAt(1) - position.charAt(1) == -2 && position.charAt(1) == '7') {
                            char[] mid = { position.charAt(0), (char) (position.charAt(1) - 1) };
                            if (!Taked(new String(mid)))
                                if (!Taked(target1))
                                    return "YES";
                        }
                    }

                } else if (Math.abs(target1.charAt(0) - position.charAt(0)) == 1) {
                    if (sideOf.equals("W")) {
                        if (target1.charAt(1) - position.charAt(1) == 1) {
                            if (Taked(target1))
                                return "TAKE";
                        }
                    }

                    else if (sideOf.equals("B")) {
                        if (target1.charAt(1) - position.charAt(1) == -1) {
                            if (Taked(target1))
                                return "TAKE";
                        }
                    }
                }
            }

            return "NO";
        }

        public boolean Taked(String target1) {
            if (Board.fulled_Board[Board.n - (target1.charAt(1) - 49) - 1][target1.charAt(0) - 'A'].equals("None"))
                return false;
            else
                return true;
        }

    }

}
