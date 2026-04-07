package utils;

import org.apache.poi.xssf.usermodel.*;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class FeatureFileGenerator {

    public static void generateFeatureFile() {

        String excelPath = "src/test/resources/testdata/loginData.xlsx";
        String featurePath = "src/test/resources/features/generatedLogin.feature";

        try (FileInputStream file = new FileInputStream(excelPath);
                XSSFWorkbook workbook = new XSSFWorkbook(file);
                BufferedWriter writer = new BufferedWriter(new FileWriter(featurePath))) {

            XSSFSheet sheet = workbook.getSheet("Sheet1");

            // ✅ Check if sheet exists
            if (sheet == null) {
                System.out.println("Sheet not found!");
                return;
            }

            // Write Feature Header
            writer.write("Feature: DemoQA Login\n\n");

            int rows = sheet.getPhysicalNumberOfRows();

            for (int i = 1; i < rows; i++) {

                XSSFRow row = sheet.getRow(i);

                // ✅ Skip null rows
                if (row == null) {
                    System.out.println("Skipping empty row: " + i);
                    continue;
                }

                XSSFCell usernameCell = row.getCell(0);
                XSSFCell passwordCell = row.getCell(1);
                XSSFCell resultCell = row.getCell(2);

                // ✅ Skip null cells
                if (usernameCell == null || passwordCell == null || resultCell == null) {
                    System.out.println("Skipping incomplete row: " + i);
                    continue;
                }

                String username = usernameCell.toString().trim();
                String password = passwordCell.toString().trim();
                String result = resultCell.toString().trim();

                writer.write("Scenario: Login with user " + username + "\n");
                writer.write("  Given user is on login page\n");
                writer.write("  When user enters username \"" + username + "\" and password \"" + password + "\"\n");
                writer.write("  And clicks on login button\n");
                writer.write("  Then login result should be \"" + result + "\"\n\n");
            }

            System.out.println("Feature file generated successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}