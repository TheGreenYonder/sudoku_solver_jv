class Starter {
    public static void main(String[] args) {

        Solver mysolver = new Solver();
        String[][] sudoku = mysolver.generate_grid();
        mysolver.print_grid(sudoku);
    }
}
