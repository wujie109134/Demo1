import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Excel<JxlExcelReader> {
    @Test
    public void writerRows(){
        // 读取attend.xls的第一张工作表（排班表）的从第3行起的8行数据
        Map<Integer, String[]> datas = new HashMap<>();
        // 创造map数据
       String[] a = {"1","32","12","23","23212","121","234"};
       String[] b = new String[50001];

        for (int i = 0; i <= 50000; i++){
            b[i] = i+"" ;
//            if (i / 65536){
//
//            }
          int l =   i / 65536;
        }

       // System.out.println(Arrays.toString(b));
        datas.put(0,b);
        //将数据写入谢数据.xls文件中 写入一列/一行
        JxlExcelWritre.JxlExcelWriter excelWriter=new JxlExcelWritre.JxlExcelWriter(new File("/Users/sht/Desktop/团长id.xls"));
        excelWriter.write(datas,0 );
        //此方法flush（）一定得调用，否则无法真正写入数据
        excelWriter.flush();

    }
}
