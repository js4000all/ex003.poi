package exam.poi;

import java.io.File;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class PoiDemo {
	private static void out(Object ... vs) {
		for(Object v : vs) {
			System.out.print(v);
		}
		System.out.println();
	}
	
	public static void main(String[] args) throws Exception{
		File f = new File(args[0]);
		try(Workbook book = WorkbookFactory.create(f)){
			Sheet sh = book.getSheet("Sheet1");
			out(sh.getRow(0).getCell(6));
		}
	}
	

}
