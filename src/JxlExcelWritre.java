import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

public class JxlExcelWritre {
    /**
     * 数据写入Excel工具类
     *
     * @author 小伍
     */
    public static final class JxlExcelWriter
    {
        // 可写的工作薄
        private WritableWorkbook workbook;

        // 只读工作薄
        private Workbook book;

        /**
         * 构造方法
         * @param excel Excel文件对象，允许其文件本身不存在<br/>
         *  若excel文件不存在，构造方法将自动创建一个文件对象对应的磁盘文件
         */
        public JxlExcelWriter(File excel)
        {
            try
            {
                // Excel文件不存在时，初始化一个可写入的工作薄
                if (!excel.exists())
                {
                    File parentFile = excel.getParentFile();
                    parentFile.mkdirs();
                    workbook = Workbook.createWorkbook(excel);
                }

                /**
                 * Excel文件存在时，表明Excel中至少有一个工作表，
                 * 初始化一个可向工作表追加数据且能写入新数据的工作薄
                 */
                else
                {
                    /**
                     * 此静态方法通过传入两个参数，Excel文件对象excel、只读工作工作薄对象book，<br/>
                     * 来创建初始化一个可追加数据的工作薄对象
                     */
                    book = Workbook.getWorkbook(excel);
                    workbook = Workbook.createWorkbook(excel, book);
                }

            }
            catch (IOException | BiffException e)
            {
                e.printStackTrace();
            }
        }

        /**
         * 将多行数据写入到Excel缓冲区
         *
         * @param contents 要写入到Excel的数据（映射表），其key值表示行索引，<br/>
         *            其value值表示一行所有的单元格内容，字符串数组的每个元素对应一个单元格内容
         * @param sheetIndex 要写入到Excel的工作表索引
         * @see [类、类#方法、类#成员]
         */
        public void write(Map<Integer, String[]> contents, int sheetIndex)
        {
            String sheetName = generateSheetName(sheetIndex);
            write(contents, sheetName, sheetIndex);
        }

        /**
         * 将多列数据写入Excel
         *  public void write(Map<Integer, String[]> contents, int sheetIndex)
         *         {
         *             String sheetName = generateSheetName(sheetIndex);
         *             write(contents, sheetName, sheetIndex);
         *         }
         *
         *
         * */

        /**
         * 将多行数据写入到Excel缓冲区
         *
         * @param contents 要写入到Excel的数据（映射表），其key值表示行索引，<br/>
         *            其value值表示一行所有的单元格内容，字符串数组的每个元素对应一个单元格内容
         * @param sheetName 要写入到Excel的工作表名
         * @param sheetIndex 要写入到Excel的工作表索引
         */
        public void write(Map<Integer, String[]> contents, String sheetName, int sheetIndex)
        {
            if (contents == null || contents.isEmpty())
                throw new IllegalArgumentException("参数contents不包含任何内容或为空指针");
            // 得到工作表
            WritableSheet sheet = getWritableSheet(sheetName, sheetIndex);
            // 将数据添加到工作表的缓冲区中
            try
            {
                Set<Integer> keys = contents.keySet();
                for (int rowIndex : keys)
                {
                    String[] rowContent = contents.get(rowIndex);
                    for (int i = 0; i < rowContent.length; i++)
                    {
                        // 文本内容为空时，sheet表增加一个Blank
                        if (rowContent[i] == null)
                        {
                            // 将内写入一行
                            // jxl.write.Blank blank = new jxl.write.Blank(i, rowIndex);
                            // 将内容写入一列
                            jxl.write.Blank blank = new jxl.write.Blank(rowIndex, i);
                            sheet.addCell(blank);
                        }
                        else
                        {
                            // 将内写入一行
                            // jxl.write.Label lable = new jxl.write.Label(i, rowIndex, rowContent[i]);
                            // 将内容写入一列
                            jxl.write.Label lable = new jxl.write.Label(rowIndex, i, rowContent[i]);
                            sheet.addCell(lable);
                        }
                    }
                }
            }
            catch (WriteException e)
            {
                e.printStackTrace();
            }
        }

        /**
         * 创建/获取工作表
         *
         * @param sheetName
         * @param sheetIndex
         * @return
         * @see [类、类#方法、类#成员]
         */
        private WritableSheet getWritableSheet(String sheetName, int sheetIndex)
        {
            WritableSheet sheet = null;
            if (sheetIndex < workbook.getNumberOfSheets())
            {
                sheet = workbook.getSheet(sheetIndex);
                sheet.setName(sheetName);
            }
            else
            {
                sheet = workbook.createSheet(sheetName, sheetIndex);
            }
            return sheet;
        }

        /**
         * 生成工作表表名
         *
         * @param sheetIndex
         * @return
         * @see [类、类#方法、类#成员]
         */
        private String generateSheetName(int sheetIndex)
        {
            String sheetName = "";
            if (sheetIndex < workbook.getNumberOfSheets())
            {
                sheetName = workbook.getSheet(sheetIndex).getName();
            }
            else
            {
                sheetName = "sheet" + sheetIndex;
            }
            return sheetName;
        }

        /**
         * 将单行数据写入到Excel缓冲区
         *
         * @param rowContent 要写入到Excel的数据，数组的每个元素对应一个单元格内容
         * @param rowIndex 写入到Excel的行索引
         * @param sheetIndex 要写入到Excel的工作表索引
         * @see [类、类#方法、类#成员]
         */
        public void writeRow(String[] rowContent, int rowIndex, int sheetIndex)
        {
            String sheetName = generateSheetName(sheetIndex);
            writeRow(rowContent, rowIndex, sheetName, sheetIndex);
        }

        /**
         * 将单行数据写入到Excel缓冲区
         *
         * @param rowContent 要写入到Excel的数据，数组的每个元素对应一个单元格内容
         * @param rowIndex 写入到Excel的行索引
         * @param sheetName 要写入到Excel的工作表名
         * @param sheetIndex 要写入到Excel的工作表索引
         * @see [类、类#方法、类#成员]
         */
        public void writeRow(String[] rowContent, int rowIndex, String sheetName, int sheetIndex)
        {
            // 得到工作表
            WritableSheet sheet = getWritableSheet(sheetName, sheetIndex);
            try
            {
                for (int i = 0; i < rowContent.length; i++)
                {
                    if (rowContent[i] == null)
                    {
                        jxl.write.Blank blank = new jxl.write.Blank(i, rowIndex);
                        sheet.addCell(blank);
                    }
                    else
                    {
                        jxl.write.Label lable = new jxl.write.Label(i, rowIndex, rowContent[i]);
                        sheet.addCell(lable);
                    }
                }
            }
            catch (WriteException e)
            {
                e.printStackTrace();
            }
        }

        /**
         * 写入一个单元内容到Excel缓冲区
         *
         * @param content 要写入的单元格内容
         * @param rowIndex 写入到Excel的行索引
         * @param colIndex 写入到Excel的列索引
         * @param sheetIndex 要写入到Excel的工作表索引
         */
        public void writeCell(String content, int rowIndex, int colIndex, int sheetIndex)
        {
            String sheetName = generateSheetName(sheetIndex);
            writeCell(content, rowIndex, colIndex, sheetName, sheetIndex);

        }

        /**
         * 写入一个单元内容到Excel缓冲区
         *
         * @param content 要写入的单元格内容
         * @param rowIndex 写入到Excel的行索引
         * @param colIndex 写入到Excel的列索引
         * @param sheetName 要写入到Excel的工作表名
         * @param sheetIndex 要写入到Excel的工作表索引
         */
        public void writeCell(String content, int rowIndex, int colIndex, String sheetName, int sheetIndex)
        {
            // 得到工作表
            WritableSheet sheet = getWritableSheet(sheetName, sheetIndex);
            try
            {
                if (content == null)
                {
                    jxl.write.Blank blank = new jxl.write.Blank(colIndex, rowIndex);
                    sheet.addCell(blank);
                }
                else
                {
                    jxl.write.Label lable = new jxl.write.Label(colIndex, rowIndex, content);
                    sheet.addCell(lable);
                }
            }
            catch (WriteException e)
            {
                e.printStackTrace();
            }
        }

        /**
         * 将Excel缓冲区的数据刷新写入到Excel文件中, <br/>
         * 在最后此方法必须被调用，否则数据不能真正写入Excel文件中
         */
        public void flush()
        {
            try
            {
                if (workbook != null)
                {
                    workbook.write();
                    workbook.close();
                }
                if (book != null)
                {
                    book.close();
                }
            }
            catch (WriteException | IOException e)
            {
                e.printStackTrace();
            }
        }
    }
}
