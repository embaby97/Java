import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {

    // Complete the closestNumbers function below.

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a[] = new int[n];
        ArrayList<Integer> arr = new ArrayList<Integer>();

        for(int i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
        }
        Arrays.sort(a);
        int d =a[1]-a[0],id=0;
        for(int i=1;i<n;i++)
        {
            if(d>Math.abs(a[i]-a[i-1]))
            {
                d = Math.abs(a[i]-a[i-1]);
                id = i-1;
                arr = new ArrayList<Integer>();
                arr.add(a[i-1]);
                arr.add(a[i]);
            }
            else if (d==Math.abs(a[i]-a[i-1]))
            {
                arr.add(a[i-1]);
                arr.add(a[i]);
            }
        }
        for(int i=0;i<arr.size();i++)
        {
            
              System.out.print(arr.get(i)+" ");
        }
        
        
    }
}
