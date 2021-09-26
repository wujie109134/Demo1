import java.io.*;
import java.util.Iterator;
import java.util.Map;

public class WritreDartaTool {
    public void textwritre(String name, Map<String, String> data) {
        // 定义文件路径
        String filepath = "/Users/sht/Desktop/";
        // 定义文件的绝对路径和名字
        String filename = filepath + name;
        // 创建一个文件夹
        File textfile = null;
        // 创建写入文件的流
        BufferedWriter textwriter = null;
        try {
            textfile = new File(filename);
            // 得到文件的绝对地址
            File parent = textfile.getParentFile();
            // 判断文件是否存在如果没有就创建 ！parent.exists()判断文件是否存在
            if (parent != null && !parent.exists()) {
                // 生产目录  mkdirs方法创建目录，生成所有目录，mkdir方法必须在A目录存在才能生产B目录
                parent.mkdir();

            }
            // 判断文件夹返回boolean表示是否创建文件成功
            textfile.createNewFile();
            // 创建写入流
            // 因为地址不对这里报错java.io.FileNotFoundException 拒绝访问
            textwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));

            // 遍历map
            Iterator iterator = data.entrySet().iterator();
            String key;
            String value;
            while (iterator.hasNext()) {
                Map.Entry entry = (Map.Entry) iterator.next();
                key = entry.getKey().toString();
                value = entry.getValue().toString();
                textwriter.write(key + value+"\n");
            }
            //关闭流
            textwriter.flush();
            textwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void textwritre(String name, String[] data) {
        // 定义文件路径
        String filepath = "/Users/sht/Desktop/";
        // 定义文件的绝对路径和名字
        String filename = filepath + name;
        // 创建一个文件夹
        File textfile = null;
        // 创建写入文件的流
        BufferedWriter textwriter = null;
        try {
            //创建文件
            textfile = new File(filename);
            System.out.println(textfile.getName() + "11111");
            // 得到文件的绝对地址
            File parent = textfile.getParentFile();
            // 判断文件是否存在如果没有就创建 ！parent.exists()判断文件是否存在
            if (parent != null && !parent.exists()) {
                // 生产目录  mkdirs方法创建目录，生成所有目录，mkdir方法必须在A目录存在才能生产B目录
                parent.mkdir();
            }
            // 判断文件夹返回boolean表示是否创建文件成功
            textfile.createNewFile();

            // 因为地址不对这里报错java.io.FileNotFoundException 拒绝访问
            // 创建写入流
            textwriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));

            // 遍历数组写入数据
            for (int i = 0; i < data.length; i++) {
                textwriter.write(data[i]);
            }
            //管理流
            textwriter.flush();
            textwriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void cvswriter(String name,String[] datas){
        // 定义文件路径
        String filepath = "/Users/sht/Desktop/";
        // 定义文件的绝对路径和名字
        String filename = filepath + name;
        // 创建一个文件夹
        File cvsfile = null;
        // 创建写入文件的流
        BufferedWriter cvswriter = null;
        try {
            // 创建文件
            cvsfile = new File(filename);
            // 得到文件的路径
            File path = cvsfile.getParentFile();
            // 判断文件是否存在，path.exists（）
            if (path != null && !path.exists()){
                // 生产目录  mkdirs方法创建目录，生成所有目录，mkdir方法必须在A目录存在才能生产B目录
                path.mkdir();
            }
            //创建流
            cvswriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)));
            //遍历写入数据 增强for循环
            for (String data : datas){
                cvswriter.write(data);
            }
            //关闭流
            cvswriter.flush();
            cvswriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
