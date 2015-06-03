import java.io.Console;
public class counter {
    public static void main(String[] args) {
      Console c = System.console();
        if (c == null) {
            System.err.println("No console.");
            System.exit(1);
        }

        String t = c.readLine("Enter line: ");
        int len = t.length();
        char[] m =new char[len];
        m = t.toCharArray ();
        int spaces;
        int i=0;
        for(int i=0;i<len;i++)                           //
        {
         if(arrays.equals(m[i], " "))
          // if(!Arrays.equals(m[i-1], " "))
          //   spaces++;
        }
        i--;
        if(!Arrays.equals(m[i], " "))
         spaces++;
        System.out.println(spaces);                       //
    }
}
