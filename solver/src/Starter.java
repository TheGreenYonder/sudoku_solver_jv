class Starter {
    public static void main(String[] args) {

        Solver mysolver = new Solver();
        String[][] empty_sudoku = mysolver.generate_grid();
        mysolver.print_grid(empty_sudoku);
        String[][] filled_sudoku = mysolver.fill_sudoku(empty_sudoku);
        mysolver.print_grid(filled_sudoku);
        String numbers[][][] = mysolver.find_possible_numbers(filled_sudoku);
    }
}
