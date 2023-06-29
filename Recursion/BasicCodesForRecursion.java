import java.util.ArrayList;
import java.util.Scanner;

public class BasicCodesForRecursion {
    public static Scanner scn = new Scanner(System.in);
    public static void main(String[] args) {
//        int n = scn.nextInt();
//        System.out.println("Print Decreasing......");
//        printDecreasing(n);
//        System.out.println();
//        System.out.println("Print Increasing......");
//        printIncreasing(n);
//        System.out.println();
//        System.out.println("Print Decreasing Increasing Both Together........");
//        printDecreasingIncreasing(n);
//        System.out.println();
////        System.out.println("Factorial Of Given N.....");
//        int x = factorialOfGivenN(n);
//        System.out.println("Factorial of Given N : " + x);
//        int x = scn.nextInt();
//        int y = powerOfGivenXN(x, n);
//        System.out.println("Power Of 'X' With Respect To Given 'N' : " + y);
//        int z = powerOfGivenXN2(x, n);
//        System.out.println("Power-2-Function Of 'X' With Respect To Given 'N' : " + y);
//        calling2timesFunctionInRecursion(n);
//        System.out.println();
//        int toh1 = scn.nextInt();
//        int toh2 = scn.nextInt();
//        int toh3 = scn.nextInt();
//        towerOfHanoi(n, toh1, toh2, toh3);
//        int[] arr = new int[n];
//        for (int i = 0; i < n; i++) {
//            arr[i] = scn.nextInt();
//        }
//        System.out.println("print array with the help of recursion..........");
//        printArray(arr, n-1);
//        int ans = maxInArray(arr, n-1);
//        System.out.println("maximum value in array : " + ans);
//        int ans = findDataInArrayWithRecursiveProcess(arr, 0, 5);
//        System.out.println("Data In Array With Recursive Process : " + ans);
//        int ans = findDataInArrayWithRecursiveProcess2(arr, 0, 5);
//        System.out.println("Data In Array With Recursive Process : " + ans);
//        int[] ans = findAllIndexesOfGivenData(arr, 0, 5, 0);
//        System.out.println("all indexes of given data......");
//        for (int i = 0; i < ans.length; i++) {
//            System.out.print(ans[i] + " ");
//        }
//        String str = scn.next();
//        ArrayList<String> ans = recursiveSubSequence(str);
//        ArrayList<String> ans = getKeyPadCombination(str);
//        ArrayList<String> ans = getStairsPath(n);
//        System.out.println(ans);
//        int m = scn.nextInt();
//        ArrayList<String> ans = getMazePaths(1, 1, n, m);
//        ArrayList<String> ans = getMazePathsWithJumps(1, 1, n, m);
//        System.out.println(ans);
//        String str = scn.next();
//        printSubSequence(str, "");
//        printKeyPadCombination(str, "");
//        printStairsPath(n, "");
//        printMazePaths(1, 1, n, m, "");
//        printMazePathsWithJumps(1, 1, n, m, "");
//        printPermutations(str, "");
//        printEncoding(str, "");
//        int[] arr = new int[scn.nextInt()];
//        for (int i = 0; i < arr.length; i++){
//            arr[i] = scn.nextInt();
//        }
//        int target = scn.nextInt();
//        printTargetSumSubset(arr, 0, "", 0, target);
//        int n = scn.nextInt();
//        int r = scn.nextInt();
//        int c = scn.nextInt();
//        int[][] chess = new int[n][n];
//        printRecursiveKnightsTour(chess, r, c, 1);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] flood = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                flood[i][j] = scn.nextInt();
            }
        }
        boolean[][] visited = new boolean[n][m];
        printFloodFillInRecursion(flood, 0, 0, "", visited);
    }
    public static void printFloodFillInRecursion(int[][] flood, int row, int col, String s, boolean[][] visited) {
        if (row < 0 || col < 0 || row == flood.length || col == flood[0].length ||
                flood[row][col] == 1 || visited[row][col] == true){
            return;
        } if (row == flood.length - 1 && col == flood.length - 1) {
            System.out.println(s + " ");
            return;
        }
        visited[row][col] = true;
        printFloodFillInRecursion(flood, row - 1, col, s + "t", visited);
        printFloodFillInRecursion(flood, row , col - 1, s + "l", visited);
        printFloodFillInRecursion(flood, row + 1, col, s + "d", visited);
        printFloodFillInRecursion(flood, row, col + 1, s + "r", visited);
        visited[row][col] = false;
    }
    public static void printRecursiveKnightsTour (int[][] chess, int r, int c, int move) {
        if (r < 0 || c < 0 || r >= chess.length || c >= chess.length || chess[r][c] > 0) {
            return;
        } else if (move == (chess.length * chess.length)) {
            chess[r][c] = move;
            displayBoard(chess);
            chess[r][c] = 0;
            return;
        }
        chess[r][c] = move;
        printRecursiveKnightsTour(chess, r - 2, c + 1, move + 1);
        printRecursiveKnightsTour(chess, r - 1, c + 2, move + 1);
        printRecursiveKnightsTour(chess, r + 1, c + 2, move + 1);
        printRecursiveKnightsTour(chess, r + 2, c + 1, move + 1);
        printRecursiveKnightsTour(chess, r + 2, c - 1, move + 1);
        printRecursiveKnightsTour(chess, r + 1, c - 2, move + 1);
        printRecursiveKnightsTour(chess, r - 1, c - 2, move + 1);
        printRecursiveKnightsTour(chess, r - 2, c - 1, move + 1);
        chess[r][c] = 0;
    }
    private static void displayBoard(int[][] chess) {
        for (int i = 0; i < chess.length; i++) {
            for (int j = 0; j < chess[i].length; j++) {
                System.out.print(chess[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isItASafePlaceForTheQueen (int[][] chess, int row, int col) {
        for (int i = row - 1, j = col; i >= 0; i--) {
            if (chess[i][j] == 1)
                return false;
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (chess[i][j] == 1)
                return false;
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < chess.length; i--, j++) {
            if (chess[i][j] == 1)
                return false;
        }
        return true;
    }
    public static void printNQueens (int[][] chess, String ans, int row) {
        if (row == chess.length) {
            System.out.println(ans);
            return;
        }
        for (int col = 0; col < chess.length; col++) {
            if (isItASafePlaceForTheQueen(chess, row, col) == true) {
                chess[row][col] = 1;
                printNQueens(chess, ans + row + "-" + col + ", ", row + 1);
                chess[row][col] = 0;
            }
        }
    }
    public static void printTargetSumSubset(int[] arr, int i, String s, int sum, int target) {
        if (i == arr.length) {
            if (sum == target) System.out.println(s);
            return;
        }
        printTargetSumSubset(arr, i + 1, s + arr[i] + " ", sum + arr[i], target);
        printTargetSumSubset(arr, i + 1, s, sum, target);
    }
    public static void printEncoding(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + ", ");
            return;
        } else if (str.length() == 1) {
            char ch = str.charAt(0);
            if (ch == '0') {
                return;
            } else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                ans = ans + code;
                System.out.print(ans + ", ");
            }

        } else {
            char ch = str.charAt(0);
            String sortPart = str.substring(1);
            if (ch == '0') return;
            else {
                int chv = ch - '0';
                char code = (char) ('a' + chv - 1);
                printEncoding(sortPart, ans + code);
            }
            String chPro = str.substring(0, 2);
            String sortPartPro = str.substring(2);
            int chProInt = Integer.parseInt(chPro);
            if (chProInt <= 26) {
                char code = (char) ('a' + chProInt - 1);
                printEncoding(sortPart, ans + code);
            }
        }
    }
    public static void printPermutations(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans + ", ");
            return;
        }
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            String leftPart = str.substring(0, i);
            String rightPart = str.substring(i + 1);
            String addBoth = leftPart + rightPart;
            printPermutations(addBoth, ans + ch);
        }
    }
    public static void printMazePathsWithJumps(int sr, int sc, int dr, int dc, String ans) {
        //sr - sourceRow, sc - sourceColumn, dr - destinationRow, dc - destinationColumn.
        if (sr == dr && sc == dc) {
            System.out.print(ans + ", ");
            return;
        }
        //horizontal moves
        for (int i = 1; i <= dc - sc; i++) {
            printMazePathsWithJumps(sr, sc + i, dr, dc, ans + "h" + i);
        }
        // vertical moves
        for (int i = 1; i <= dr - sr; i++) {
            printMazePathsWithJumps(sr + i, sc, dr, dc, ans + "v" + i);
        }
        //diagonal moves
        for (int i = 1; i <= dr - sr && i <= dc - sc; i++) {
            printMazePathsWithJumps(sr + i, sc + i, dr, dc, ans + "d" + i);
        }
    }
    public static void printMazePaths(int sr, int sc, int dr, int dc, String ans) {
        //sr - sourceRow, sc - sourceColumn, dr - destinationRow, dc - destinationColumn.
        if (sr == dr && sc == dc) {
            System.out.println(ans + ", ");
            return;
        }
        if (sr < dr) {
            printMazePaths(sr + 1, sc, dr, dc, ans + "h");
        }
        if (sc < dc) {
            printMazePaths(sr, sc + 1, dr, dc, ans + "v");
        }
    }
    public static void printStairsPath(int n, String ans) {
        if (n < 0) return;
        if (n == 0) {
            System.out.print(ans + ", ");
            return;
        }
        printStairsPath(n - 1, ans + "1");
        printStairsPath(n - 2, ans + "2");
        printStairsPath(n - 3, ans + "3");
    }
    public static void printKeyPadCombination(String str, String ans) {
        if (str.length() == 0) {
            System.out.print(ans + ", ");
            return;
        }
        char ch = str.charAt(0);
        String sortAns = str.substring(1);
        String codeForChar = codes[ch - '0'];
        for (int i = 0; i < codeForChar.length(); i++){
            char charOption = codeForChar.charAt(i);
            printKeyPadCombination(sortAns,ans + charOption);
        }
    }
    public static void printSubSequence(String str, String ans) {
        if (str.length() == 0) {
            System.out.println(ans);
            return;
        }
        char ch = str.charAt(0);
        String sortAns = str.substring(1);
        printSubSequence(sortAns ,ans + ch);
        printSubSequence(sortAns, ans + "");
    }
    public static ArrayList<String> getMazePathsWithJumps(int sr, int sc, int dr, int dc) {
        //sr - sourceRow, sc - sourceColumn, dr - destinationRow, dc - destinationColumn.
        if (sr == dr && sc == dc) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        ArrayList<String> paths = new ArrayList<>();
        //horizontal moves
        for (int i = 1; i <= dc - sc; i++) {
            ArrayList<String> hPaths = getMazePathsWithJumps(sr, sc + i, dr, dc);
            for (String str : hPaths) {
                paths.add("h" + i + str);
            }
        }
        // vertical moves
        for (int i = 1; i <= dr - sr; i++) {
            ArrayList<String> vPaths = getMazePathsWithJumps(sr + i, sc, dr, dc);
            for (String str : vPaths) {
                paths.add("v" + i + str);
            }
        }
        //diagonal moves
        for (int i = 1; i <= dr - sr && i <= dc - sc; i++) {
            ArrayList<String> dPaths = getMazePathsWithJumps(sr + i, sc + i, dr, dc);
            for (String str : dPaths) {
                paths.add("d" + i + str);
            }
        }
        return paths;
    }
    public static ArrayList<String> getMazePaths(int sr, int sc, int dr, int dc) {
        //sr - sourceRow, sc - sourceColumn, dr - destinationRow, dc - destinationColumn.
        if (sr == dr && sc == dc) {
            ArrayList<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        ArrayList<String> hPaths = new ArrayList<>();
        ArrayList<String> vPaths = new ArrayList<>();
        if (sr < dr) {
            hPaths = getMazePaths(sr + 1, sc, dr, dc);
        }
        if (sc < dc) {
            vPaths = getMazePaths(sr, sc + 1, dr, dc);
        }
        ArrayList<String> paths = new ArrayList<>();
        for (String str : hPaths) {
            paths.add("h" + str);
        }
        for (String str : vPaths) {
            paths.add("v" + str);
        }
        return paths;
    }
    public static ArrayList<String> getStairsPath (int n) {
        if (n == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        } else if (n < 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            return baseResult;
        }

        ArrayList<String> path1 = getStairsPath(n - 1);
        ArrayList<String> path2 = getStairsPath(n - 2);
        ArrayList<String> path3 = getStairsPath(n - 3);

        ArrayList<String> paths = new ArrayList<>();

        for (String str : path1) {
            paths.add(1 + str);
        }
        for (String str : path2) {
            paths.add(2 + str);
        }
        for (String str : path3) {
            paths.add(3 + str);
        }
        return paths;
    }
    static String[] codes = {".;", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tu", "vwx", "yz"};
    public static ArrayList<String> getKeyPadCombination (String str) {
        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        char ch = str.charAt(0);
        String recSubString = str.substring(1);
        ArrayList<String> recursiveResult = getKeyPadCombination(recSubString);

        ArrayList<String> myResult = new ArrayList<>();
        String codeForChar = codes[ch - '0'];
        for (int i = 0; i < codeForChar.length(); i++) {
            char chCode = codeForChar.charAt(i);
            for (String s : recursiveResult) {
                myResult.add(chCode + s);
            }
        }
        return myResult;
    }
    public static ArrayList<String> recursiveSubSequence (String str) {
        if (str.length() == 0) {
            ArrayList<String> baseResult = new ArrayList<>();
            baseResult.add("");
            return baseResult;
        }
        char ch = str.charAt(0);
        String recSubString = str.substring(1);
        ArrayList<String> recursiveResult = recursiveSubSequence(recSubString);

        ArrayList<String> myResult = new ArrayList<>();
        for (String s : recursiveResult){
            myResult.add("" + s);
        }
        for (String s : recursiveResult){
            myResult.add(ch + s);
        }
        return myResult;
    }
    public static int[] findAllIndexesOfGivenData (int[] arr, int idx, int data, int count) {
        if (idx == arr.length) {
            return new int[count];
        }
        if (arr[idx] == data) {
            int[] ans = findAllIndexesOfGivenData(arr, idx + 1, data, count + 1);
            ans[count] = idx;
            return ans;
        } else {
            int[] ans = findAllIndexesOfGivenData(arr, idx + 1, data, count);
            return ans;
        }
    }
    public static int findDataInArrayWithRecursiveProcess2(int[] arr, int i, int data) {
        if (i == arr.length) {
            return -1;
        }
        int LastTimeOccurData = findDataInArrayWithRecursiveProcess(arr, i + 1, data);
        if (LastTimeOccurData == -1) {
            if(arr[i] == data) {
                return i;
            } else {
                return -1;
            }
        } else {
            return LastTimeOccurData;
        }
    }
    public static int findDataInArrayWithRecursiveProcess(int[] arr, int i, int data) {
        if (arr.length == i) {
            return -1;
        }
        if (arr[i] == data) {
            return i;
        } else {
            int firstTimeOccurData = findDataInArrayWithRecursiveProcess(arr, i + 1, data);
            return firstTimeOccurData;
        }
    }
    public static int maxInArray (int[] arr, int idx) {
        if (idx == 0) {
            return 0;
        }
        int bigger = maxInArray(arr, idx - 1);
        if (arr[idx] > bigger) {
            return arr[idx];
        }
        else {
            return bigger;
        }
    }
    public static void printArray (int[] arr, int idx) {
        if (idx == -1) {
            return;
        }
        System.out.println(arr[idx] + " "); // reverse
        printArray(arr, idx - 1);
        System.out.println(arr[idx] + " "); // normal
    }
    public static void towerOfHanoi(int n, int toh1, int toh2, int toh3) {
        if (n == 0) {
            return;
        }
        towerOfHanoi(n-1, toh1, toh3, toh2);
        System.out.println("[" + toh1 + " -> " + toh2 + "]");
        towerOfHanoi(n-1, toh3, toh2, toh1);
    }
    public static void calling2timesFunctionInRecursion(int n) {
        if (n == 0) {
            return;
        }
        System.out.println("pre : " + n);
        calling2timesFunctionInRecursion(n-1);
        System.out.println("in : " + n);
        calling2timesFunctionInRecursion(n-1);
        System.out.println("post : " + n);
    }
    public static int powerOfGivenXN2(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int power_of_N_divide_half = powerOfGivenXN(x, n / 2);
        int power = power_of_N_divide_half * power_of_N_divide_half;
        if (n % 2 == 1) {
            power = power * x;
        }
        return power;
    }
    public static int powerOfGivenXN(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int power_of_N_minus_one = powerOfGivenXN(x, n - 1);
        int power = x * power_of_N_minus_one;
        return power;
    }
    public static int factorialOfGivenN(int n) {
        if (n == 1) {
            return 1;
        }
        int fact_of_N_minus_one = factorialOfGivenN(n - 1);
        int fact = n * fact_of_N_minus_one;
        return fact;
    }
    public static void printDecreasingIncreasing(int n) {
        if (n == 0) {
//            System.out.println();
            return;
        }
        System.out.print(n + " ");
        printDecreasingIncreasing(n-1);
        System.out.print(n + " ");
    }
    public static void printIncreasing(int n) {
        if (n == 0) {
            return;
        }
        printIncreasing(n-1);
        System.out.print(n + " ");
    }
    public static void printDecreasing(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        printDecreasing(n-1);
    }
}
