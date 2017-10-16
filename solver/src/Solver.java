import java.util.*;

class Solver {

    private String[][] sudoku = new String[9][9];
    private String[][][] possible_numbers = new String[9][9][9];

    Solver() {
    }

    String[][] generate_grid() {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                this.sudoku[y][x] = " ";
            }
        }
        return this.sudoku;
    }

    void print_grid(String[][] grid) {
        StringBuilder line;

        for (int y = 0; y < 9; y++) {
            line = new StringBuilder();

            for (int x = 0; x < 9; x++) {
                if (x % 3 == 0) {
                    line.append(" |");
                }
                line.append(" ").append(grid[y][x]);
            }

            if (y % 3 == 0) {
                System.out.println(" -------------------------");
            }

            System.out.println(line + " |");
        }

        System.out.println(" -------------------------");
    }

    String[][] fill_sudoku(String[][] grid) {
        this.sudoku = grid;
        boolean valid = false;

        try (Scanner sc = new Scanner(System.in)) {
            while (!valid) {
                System.out.print("Top-Down, Left-Right: \n");
                String input = sc.nextLine();

                if (input.length() != 81) {
                    System.out.print("Invalid Input\n");
                } else {
                    valid = true;

                    int i = 0;
                    for (int y = 0; y < 9; y++) {
                        for (int x = 0; x < 9; x++) {
                            this.sudoku[y][x] = Character.toString(input.charAt(i++));
                        }
                    }
                }
            }
        }

        return this.sudoku;
    }

    String[][][] find_possible_numbers(String[][] grid) {
        String[] tmp = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9"};
        List lst_tmp;

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (grid[y][x].equals(" ")) {
                    lst_tmp = List.of(grid[y]);
                    this.possible_numbers[y][x] = tmp.clone();

                    for (int i = 0; i < 9; i++) {
                        if (lst_tmp.contains(this.possible_numbers[y][x][i])) {
                            this.possible_numbers[y][x][i] = " ";
                        }
                    }
                }
            }
        }
        return this.possible_numbers;
    }

    String[][] rnd_solve(String[][] grid, String[][][] poss) {
        String[][] solved = deepcopy(grid);
        Random rnd = new Random();
        int z = -1;
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                if (solved[y][x].equals(" ")) {
                    while (solved[y][x].equals(" ")) {
                        solved[y][x] = poss[y][x][rnd.nextInt(9)];
                    }
                }
            }
            //System.out.println(new HashSet<>(Arrays.asList(solved[y])).size());
            if (new HashSet<>(Arrays.asList(solved[y])).size() != 9) {
                solved = deepcopy(grid);
                y = z;
            } else {
                grid = deepcopy(solved);
                z++;
            }
        }

        return solved;
    }

    private void pnt(String[][][] test) {
        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                for (int i = 0; i < 9; i++) {
                    System.out.print(test[y][x][i] + " ");
                }
                System.out.print(" | ");
            }
            System.out.print(" \n ");
        }
    }

    private String[][] deepcopy(String[][] old) {
        String[][] neu = new String[9][9];
        for (int y = 0; y < 9; y++) {
            System.arraycopy(old[y], 0, neu[y], 0, 9);
        }

        return neu;
    }

}
