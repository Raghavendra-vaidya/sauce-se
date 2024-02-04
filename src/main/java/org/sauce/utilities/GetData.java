package org.sauce.utilities;

import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class GetData {

    public static String fromProperties(String filePath, String KEY){
        String data = null;
        Properties prop = new Properties();
        try{
            FileInputStream fileInputStream = new FileInputStream(new File(filePath));
            prop.load(fileInputStream);
            data = prop.getProperty(KEY);
        }
        catch (SecurityException | IOException e){
            e.printStackTrace();
        }
        return data;
    }

    public static String fromExcel(String filePath, String sheetName, int rIndex, int cIndex){
        String data = null;
        try(FileInputStream fileInputStream = new FileInputStream(filePath)) {
            Workbook wb = WorkbookFactory.create(fileInputStream);
            Sheet sheet = wb.getSheet(sheetName);
            Cell cell = sheet.getRow(rIndex).getCell(cIndex);
            data =  new DataFormatter().formatCellValue(cell);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public static void main(String[] args) {
        String data  = fromExcel("src/main/resources/DataEngine/creds.xlsx","creds", 2,0);
        System.out.println(data);
    }
}
