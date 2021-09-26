public class Test004 {

    public static void main(String[] args) {
    // ==  和 equals的区别
        String a = "你好";
        String b = "你好1";
        String d = "你好";

        if (a == d){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        if (a == b){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        String c = new String("你好");
        if (a.equals(c)){
            System.out.println(true);
        }else{
            System.out.println(false);
        }

        if (a == c){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
    }
}
