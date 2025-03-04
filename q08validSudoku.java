// 36. Valid Sudoku (Med)

import java.util.*;

class Solution {
    public static boolean isValidSudoku(int[][] board) {
        HashMap<Integer, ArrayList<Integer>> rows = new HashMap<>();
        HashMap<Integer, ArrayList<Integer>> cols = new HashMap<>();
        HashMap<List<Integer>, ArrayList<Integer>> boxes = new HashMap<>();

        for (int i = 0; i < 9; i++) {
            rows.put(i, new ArrayList<>());
            cols.put(i, new ArrayList<>());
        }

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int num = board[i][j];

                // Ignore empty cells
                if (num == 0) continue;

                // Calculate box key
                List<Integer> boxKey = Arrays.asList(i / 3, j / 3);

                // Initialize the box if not present
                boxes.putIfAbsent(boxKey, new ArrayList<>());

                // Check if number already exists in row, column, or box
                if (rows.get(i).contains(num) ||
                    cols.get(j).contains(num) ||
                    boxes.get(boxKey).contains(num)) {
                    return false;
                }

                // Insert number into respective data structures
                rows.get(i).add(num);
                cols.get(j).add(num);
                boxes.get(boxKey).add(num);
            }
        }

        return true;
    }
}