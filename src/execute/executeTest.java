package execute;

import Operation.UIOperation;
import ReadFileExel.ReadExel;
import org.apache.poi.ss.usermodel.Sheet;
import org.junit.Before;
import org.junit.Test;
import org.apache.poi.ss.usermodel.Row;


public class executeTest {
    @Before
    public void init(){
        System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
    }
    @Test
    public void search() throws Exception {

        ReadExel file = new ReadExel();
        UIOperation operation = new UIOperation();
        Sheet sheet = file.readExcel("D:\\autotest\\Code\\KeywordDriven"+"\\","Search.xlsx" , "Sheet1");
        int rowCount = sheet.getLastRowNum()-sheet.getFirstRowNum();
        for (int i = 1; i < rowCount; i++) {
            Row row = sheet.getRow(i);
            if(row.getCell(3).toString().length()!=0){
                operation.perform(row.getCell(3).toString(), row.getCell(4).toString(), row.getCell(5).toString(),
                        row.getCell(6).toString());
            }
            else {
                System.out.println("testcase done ");
            }

        }
    }

}
