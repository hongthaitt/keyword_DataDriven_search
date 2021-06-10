
package ReadFileExel;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

    public class ReadExel {

        public Sheet readExcel(String filePath,String fileName,String sheetName) throws IOException{
            File file =	new File(filePath+"\\"+fileName);
            FileInputStream inputStream = new FileInputStream(file);
            Workbook workbook = null;
            String fileExtensionName = fileName.substring(fileName.indexOf("."));
            if(fileExtensionName.equals(".xlsx")){
                workbook = new XSSFWorkbook(inputStream);
            }
            else if(fileExtensionName.equals(".xls")){
                workbook = new HSSFWorkbook(inputStream);
            }
            Sheet  guru99Sheet = workbook.getSheet(sheetName);
            return guru99Sheet;
        }
    }


