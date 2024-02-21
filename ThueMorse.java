public class ThueMorse {
  public static void main(String[] args) {
    if (args.length != 1) {
      System.out.println("Provide at least 1 argument: the size n of the nxn pattern");
    } else {
      int n = Integer.parseInt(args[0]);
      boolean[] thueMorseSequence = new boolean[n];
      // generate sequence
      thueMorseSequence[0] = false;
      int sizeLastSequence = 1;
      int i = 0, cursor = 1;
      // StringBuilder out = new StringBuilder();
      // out.append((thueMorseSequence[0] ? 1 : 0) + " ");
      // System.out.println(out);
      while (sizeLastSequence < n) {
        for (i = 0; (i < sizeLastSequence) && (cursor < n); i++, cursor++) {
          thueMorseSequence[cursor] = !thueMorseSequence[i];
          // out.append((thueMorseSequence[cursor] ? 1 : 0) + " ");
        }
        sizeLastSequence = cursor;
        // System.out.println("Size last seq = " + sizeLastSequence);
        // System.out.println(out);
      }

      // Use sequence to print matrix
      for (i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
          if (thueMorseSequence[i] == thueMorseSequence[j]) {
            System.out.print("+  ");
          } else {
            System.out.print("-  ");
          }
        }
        System.out.println();
      }
    } // else condition one argumento to program
  }
}
