package Testautomation.Testautomation;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_excel {
	
	public String[][]read_sheet() throws InvalidFormatException, IOException   {

		File myfile=new File(".\\Test_Data\\Book1.xlsx");
		
		 XSSFWorkbook wb = new XSSFWorkbook(myfile);
		 
			XSSFSheet mysheet=wb.getSheet("sheet1");
			int num_of_rows=mysheet.getPhysicalNumberOfRows();
			int num_of_columns=mysheet.getRow(0).getLastCellNum();
			String myarray[][]=new String[num_of_rows-1][ num_of_columns];
			for (int i=1;i<num_of_rows;i++) {
				for (int x=0;x<num_of_columns;x++) {
					 XSSFRow row= mysheet.getRow(i);
					myarray[i-1][x]=row.getCell(x).getStringCellValue();
				}
			}
			return myarray;
		}
		

}

