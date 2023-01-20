package org.Base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public static WebDriver driver;

	public static void launchBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void WindowMaximize() {
		driver.manage().window().maximize();
	}

	public static void launchUrl(String Url) {
		driver.get(Url);
	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void pageUrl() {
		String url = driver.getCurrentUrl();
		System.out.println(url);
	}

	public static void passText(String txt, WebElement ele) {
		ele.sendKeys(txt);
	}

	public static void closeEntireBrowser() {
		driver.quit();
	}

	public static void clickBtn(WebElement ele) {
		ele.click();

	}

	public static void screenShot(String imgName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File image = ts.getScreenshotAs(OutputType.FILE);
		File f = new File("location +imgName.png");
		FileUtils.copyDirectory(image, f);
	}

	public static Actions a;

	public static void moveTheCursor(WebElement tarWebElement) {
		a = new Actions(driver);
		a.moveToElement(tarWebElement).perform();
	}

	public static void dragDrop(WebElement dragWebElement, WebElement dropWebElement) {
		a = new Actions(driver);
		a.dragAndDrop(dragWebElement, dropWebElement).perform();
	}

	public static JavascriptExecutor js;

	public static void scrollThePage(WebElement tarWebElement) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true)", tarWebElement);
	}

	public static void scroll(WebElement element) {
		js.executeScript("arguments[0].scrollIntoView(false)", element);
	}

	public static void excelRead(String SheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet mySheet = wb.getSheet("Data");
		Row r = mySheet.getRow(rowNum);
		org.apache.poi.ss.usermodel.Cell c = r.getCell(cellNum);
		int cellType = c.getCellType();

		String value = " ";
		if (cellType == 1) {
			String value2 = c.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(c)) {
			Date dd = c.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat(value);
			String value1 = s.format(dd);

		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			String valueOf = String.valueOf(l);
		}
	}

	public static void createNewExcelFile(int rowNum, int cellNum, String writeData) throws IOException {
		File f = new File("Excel location.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet newSheet = w.createSheet("Datas");
		Row newRow = newSheet.createRow(rowNum);
		org.apache.poi.ss.usermodel.Cell newCell = newRow.createCell(cellNum);
		newCell.setCellValue(writeData);
		FileOutputStream fos = new FileOutputStream(f);
		w.write(fos);

	}

	public static void createCell(int getRow, int creCell, String newData) throws IOException {
		File f = new File("Excel location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(getRow);
		org.apache.poi.ss.usermodel.Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void createRow(int creRow, int creCell, String newData) throws IOException {
		File f = new File("Excel file.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook();
		Sheet s = wb.getSheet("Datas");
		Row r = s.createRow(creRow);
		org.apache.poi.ss.usermodel.Cell c = r.createCell(creCell);
		c.setCellValue(newData);
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

	public static void updateDataToParticularCell(int gettheRow, int gettheCell, String existingData,
			String writeNewData) throws IOException {
		File f = new File("Excel Location.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheet("Datas");
		Row r = s.getRow(gettheRow);
		org.apache.poi.ss.usermodel.Cell c = r.getCell(gettheCell);
		String str = c.getStringCellValue();
		if (str.equals(existingData)) {
			c.setCellValue(writeNewData);
		}
		FileOutputStream fos = new FileOutputStream(f);
		wb.write(fos);

	}

}
