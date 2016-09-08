package tests;
import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;



public class testxl {
	int xRows, xCols;
	private HSSFWorkbook myWB;
	
	@Test
	public void xlRead() throws Exception{
		System.out.println("This is running before test");
		//Read Each Set Of Data from the following path:
		String xlpath = "C:/Selenium/trainingtest.xls";
		String[][] myXL = readXL(xlpath, "Testcases");
		//System.out.println("Some data is " + myXL[2][2]);
		for (int i=0; i<xRows; i++){
			for (int j=0; j<xCols; j++){
				System.out.println(myXL[i][j]);
			}
		}
	}
	public String[][] readXL(String sPath, String iSheet) throws Exception{
		
//		String[][] myXL = null;
		
		String[][] xData;
		File myxl = new File(sPath);
		
		FileInputStream fis = new FileInputStream(myxl);
		myWB = new HSSFWorkbook(fis);
		HSSFSheet sheet = myWB.getSheet(iSheet);
		xRows = sheet.getLastRowNum()+1;
		xCols = sheet.getRow(0).getLastCellNum();
		xData = new String[xRows][xCols];
		
		for (int i = 0; i<xRows; i++){
			HSSFRow row = sheet.getRow(i);
			for (int j=0; j< xCols; j++){
				HSSFCell cell = row.getCell(j);
				String value = cellToString(cell);
				xData[i][j] = value;
				
			}
		}
		return xData;
		
		
		
	}
	
	//Change cell Type
	public static String cellToString(HSSFCell cell){
		//This function will convert an object to type excel cell to a string value
		int type = cell.getCellType();
		Object result;
		switch (type){
		case HSSFCell.CELL_TYPE_NUMERIC://0
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_STRING://1
			result = cell.getStringCellValue();
			break;
		case HSSFCell.CELL_TYPE_FORMULA://2
			throw new RuntimeException("We Can't Evaluate Formulas In Java");
		case HSSFCell.CELL_TYPE_BLANK://3
			result = "*";
			break;
		case HSSFCell.CELL_TYPE_BOOLEAN://4
			result = cell.getBooleanCellValue();
			break;
		case HSSFCell.CELL_TYPE_ERROR://5
			throw new RuntimeException ("This cell has an error");
			default:
				throw new RuntimeException("We don't support this cell type: " + type);
			
			
		}
		return result.toString();
		
	}
	

}

