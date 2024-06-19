/*package ExcelExport;

import org.testng.annotations.DataProvider;

import java.io.FileInputStream;
import java.io.InvalidObjectException;

public class XSSWorkbook extends XSSFWorkbook {
    public XSSWorkbook(FileInputStream fileInputStream) {
    }

    @DataProvider(name="excel-data")
    public Object[][] excelDP() throws InvalidObjectException {
        Object [][] arrObj;
        arrObj = getExcelData("./src/test/resources/test.xlsx", "Sheet1");
        return arrObj;
    }
}*/
