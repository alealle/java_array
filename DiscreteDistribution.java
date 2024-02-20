public class DiscreteDistribution {
  public static void main(String[] args) {

    int n = args.length - 1;
    if (n < 1) {
      System.out.println("You must provide at least 2 arguments.");

    } else {
      int m = Integer.parseInt(args[0]);
      int[] a = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(args[i + 1]);
      }

      // check input
      /*
       * for (int i = 0; i < n; i++) {
       * System.out.println(a[i]);
       * }
       */
      // generate cumulative sum
      int[] s = new int[n];
      s[0] = a[0];
      for (int i = 1; i < n; i++) {
        s[i] = s[i - 1] + a[i];
      }
      // check cumulative sum
      /*
       * String outS = "";
       * for (int i = 0; i < n; i++) {
       * outS += s[i] + " ";
       * }
       * System.out.println(outS);
       */
      int totalSum = s[n - 1];

      // System.out.println("total: " + totalSum);
      // generate output
      StringBuilder out = new StringBuilder();
      for (int i = 0; i < m; i++) {
        long probToIndex = (long) ((Math.random()) * totalSum);
        // System.out.println("prob_to_index = " + prob_to_index);
        int j = 0;
        while (probToIndex > s[j]) {
          // System.out.format(
          // "probability_to_idx: %d - i: %d - s[%d]: %d%n", prob_to_index, j, j, s[j]);
          j++;
        }
        int index = j + 1;
        out.append(index + " ");
      }
      System.out.println(out);
    }
  }
}
