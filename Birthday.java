public class Birthday {
  // public static final int MAX_PERSONS = 50;
  // public static final int MAX_PERSONS_1 = MAX_PERSONS - 1;

  public static void main(String[] args) {
    final int MAX_PERSONS = 50;
    final int MAX_PERSONS_1 = MAX_PERSONS - 1;
    if (args.length != 2) {
      System.out.println("Provide n dates and m trials!");
      return;
    }
    int n = Integer.parseInt(args[0]);
    int trials = Integer.parseInt(args[1]);
    // vector times store in position i the number of times the i-th person
    // who entered in the room shared birthday with someone else in the room
    int[] times = new int[MAX_PERSONS];
    int count;
    // loop in trials
    for (int i = 0; i < trials; i++) {
      // vector birthdays stores the birthday of the i-th person who entered the room
      // in the position birthday
      boolean[] birthdays = new boolean[n];
      /*
       * System.out.println("Birthdays are initialized");
       * for (int j = 0; j < n; j++) {
       * System.out.println(birthdays[j]);
       * }
       */
      // loop until someone enters the room and shares the same birthday of someone
      // else
      boolean shared = false;
      // the number of persons --> starts negatively as device to store from i=0 in
      // vector times
      count = -1;
      while (!shared && count < MAX_PERSONS) {
        // get one more person in the room
        ++count;
        // System.out.println((count + 1) + " person in the room");
        // pick a birthday uniformly from 0 to n
        int birthday = (int) (Math.random() * n);
        // System.out.println("Birthday is " + birthday);
        // check if birthday has already someone there, if so stops, else mark the date
        if (birthdays[birthday]) {
          shared = true;
        } else {
          birthdays[birthday] = true;
        }
        /*
         * System.out.println("Shared? " + shared);
         * System.out.println("Birthdays vector so far");
         * for (int j = 0; j < n; j++) {
         * System.out.println(birthdays[j]);
         * }
         */
      }
      // add 1 more case where count + 1 number of persons were needed to get one
      // birthday in commmon - record the total cases so far in position count of
      // vector times
      times[Math.min(count, MAX_PERSONS_1)]++;
      // System.out.println("Number of persons in the room: " + (count + 1));
      // System.out.println("Count vector so far...");
      /*
       * for (int j = 0; j < MAX_PERSONS; j++) {
       * System.out.println((j + 1) + " " + times[j]);
       * }
       */
    }
    // print results
    count = 0;
    double fraction = 0;

    do {
      fraction += ((double) times[count]) / trials;
      System.out.println((count + 1) + " " + times[count] + " " + fraction);
      count++;
    } while ((fraction < 0.5) && (count < MAX_PERSONS));
  }
}
