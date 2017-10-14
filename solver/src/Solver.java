import java.util.Scanner;

class Solver {


    private String[][] sudoku = new String[9][9];

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


}
