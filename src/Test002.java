import java.util.Arrays;

public class Test002 {
    public static void main(String[] ags){
    /*
        int[] a = {1,4,6,87,9};
     // 冒泡排序
     for(int i = 0;i < a.length-1; i++){
         for(int j = 0; j < a.length-1-i; j++){
             if(a[j] > a[j+1]) {
                 int temp = a[j];
                 a[j] = a[j + 1];
                 a[j + 1] = temp;
             }
         }
     }
        System.out.println(Arrays.toString(a));

     // 冒泡排序
     int[] b = {12,3,24,873,645,2,3,47,2647,12};
     for (int i = 0; i < b.length-1; i++){
         for (int j = 0; j < b.length-1-i; j++){
             if (b[j] > b[j+1]){
                 int temp = b[j];
                 b[j] = b[j+1];
                 b[j+1] = temp;
             }
         }
     }
        System.out.println(Arrays.toString(b));

     // 数组c
     int[] c = {12,31,1,6,754,87,46,34,79,8};
     // 循环冒泡排序
     for (int i = 0; i < c.length-1; i++){
         for (int j = 0; j < c.length-i-1; j++){
             if (c[j] > c[j+1]){
                 int temp = c[j];
                 c[j] = c[j+1];
                 c[j+1] = temp;
             }
         }
        }
        System.out.println(Arrays.toString(c));
     */
     int[] d = {34,762,3,137,261,92,8,73,91,7,231};
     for (int i = 0; i < d.length-1; i++){
         for (int j = 0; j < d.length-i-1; j++){
             if (d[j]>d[j+1]){
                 int temp = d[j];
                 d[j] = d[j+1];
                 d[j+1] = temp;
             }
         }
     }
     System.out.println(Arrays.toString(d));
    }
}

