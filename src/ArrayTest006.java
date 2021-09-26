import org.junit.Test;

import java.util.Arrays;

public class ArrayTest006 {
    @Test
    public void ArrayTest(){
        int[] a = new int[101];
        for (int i = 0; i <= 100; i++ ){
            a[i] = i;
        }
        System.out.println(Arrays.toString(a));
    }
}
