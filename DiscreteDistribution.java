public class DiscreteDistribution {
  public static void main(String[] args) {

    int n = args.length - 1;
    if (n < 1) {
      System.out.println("You must provide at least 2 arguments.");

    } else {
      int m = Integer.parseInt(args[0]);
      int a[] = new int[n];

      for (int i = 0; i < n; i++) {
        a[i] = Integer.parseInt(args[i + 1]);
      }

      for (int i = 0; i < n; i++) {
        System.out.println(a[i]);
      }
    }
  }
}
