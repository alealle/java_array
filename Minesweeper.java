public class Minesweeper {
  public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    int m = Integer.parseInt(args[1]);
    int k = Integer.parseInt(args[2]);
    // initialize mines in the map
    int N = n * m;
    int[] mine_positions = new int[N];
    for (int i = 0; i < N; i++) {
      mine_positions[i] = i;
    }
    // swap mine positions
    for (int i = 0; i < N; i++) {
      int change = i + (int) (Math.random() * (N - i));
      int tmp = mine_positions[i];
      mine_positions[i] = mine_positions[change];
      mine_positions[change] = tmp;
    }
    // choose the k first positions in array mine position to put the k mines
    // for (int i = 0; i < k; i++) {
    // System.out.print(mine_positions[i] + " ");
    // }
    // System.out.println();
    // initialize maps
    boolean[][] map = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // check in vector mine_positions
        int pos = m * i + j;
        for (int l = 0; l < k; l++) {
          if (pos == mine_positions[l]) {
            map[i][j] = true;
          }
        }
        // System.out.print((map[i][j] ? 1 : 0) + " ");
      }
      // System.out.println();
    }
    // System.out.println();
    // System.out.println();
    // print the grid pointing the number of neighbors with mines
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // aux variables
        if (map[i][j]) {
          System.out.print("*  ");
        } else {
          int p_line = i - 1;
          p_line = ((p_line > 0) ? p_line : 0);
          int n_line = i + 2;
          n_line = ((n_line < n) ? n_line : n);
          int p_col = j - 1;
          p_col = ((p_col > 0) ? p_col : 0);
          int n_col = j + 2;
          n_col = ((n_col < m) ? n_col : m);
          int count = 0;
          for (int il = p_line; il < n_line; il++) {
            for (int jl = p_col; jl < n_col; jl++) {
              count += (map[il][jl] ? 1 : 0);
            }
          }
          System.out.print(count + "  ");
        }
      }
      System.out.println();
    }
  }
}
