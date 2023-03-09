package homework01;

import java.util.Random;

public enum Names {
Connie, Amy, Timothy, Daniel, John, Gerald, Thomas, Janet, Ana, Tanya,
Audrey, Hilda, Stephen, Charles, Susan, Oscar, Barbara, George, Marvin;
///
private static final Names[] arr = values();
private static final int len = arr.length;
private static final Random rnd = new Random();

public static String getRandName()  {
  return arr[rnd.nextInt(len)].toString();
}
}

