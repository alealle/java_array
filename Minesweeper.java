public class Minesweeper {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int m = Integer.parseInt(args[1]);
    int k = Integer.parseInt(args[2]);
    // initialize maps
    int[][] map = new int[n][m];
    // initialize mines in the map
    int N = n * m;
    int[] mine_positions = new int[N];
    for (int i = 0; i < N; i++) {
      mine_positions[i] = i;
    }
    // swap mine positions
    for (int i = 0; i < N; i++) {
      int change = (int) (Math.random() * N);
      int tmp = mine_positions[i];
      mine_positions[i] = mine_positions[change];
      mine_positions[change] = tmp;
    }
    // choose the k first positions in array mine position to put the k mines
    for (int i = 1; i < k; i++) {
      System.out.print(mine_positions[i] + "  ");
    }
    System.out.println();
    // print the grid
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // check in vector mine_positions
        System.out.print(map[i][j] + "  ");
      }
      System.out.println();
    }
  }
}
