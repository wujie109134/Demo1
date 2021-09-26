import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TextTest {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();
        String name = "团长吴杰.cvs";
        //循环添加数据
        for (int i = 0; i <= 100; i++) {
            map.put("第" + i + "个团长id:", i + "");
        }
//        // 遍历map
//        for (String key : map.keySet()) {
//            String value = map.get(key);
//            System.out.println(key + value);
//        }
        String[] data = new String[500001];
        for (int i = 0; i <= 500000; i++) {
            data[i] = i + "\n";
        }


        // new一个工具类
        WritreDartaTool writer = new WritreDartaTool();
        //调用工具类方法写入数据
//        writer.textwritre(name, data);
//        writer.textwritre(name, map);

        writer.cvswriter(name,data);


    }
}

