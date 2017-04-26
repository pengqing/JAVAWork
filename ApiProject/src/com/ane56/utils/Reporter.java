package com.ane56.utils;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFBorderFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.CellRangeAddress;

public class Reporter {
	
	//Define the relative path for the different module.
	//The global step number used to record the current operation.
	public static int intStepNO = 1;
	public static int intRowInfo = 4;
	public static String packageName;

	//The relative path of the 'Cash' module's report.
	@SuppressWarnings("unused")
	private final static String CASH_RELATIVE_TEST_RESULT_PATH = "\\TestReport\\";
	@SuppressWarnings("unused")
	private static final String TAKEAWAY_TEST_PICTURE_PATH = "\\TestReport\\TestPicture\\";
	private static final String SYSTEM_DIR_PATH = System.getProperty("user.dir");
	
	/**
	 * Define one method used to get the current name of the test script.
	 * @param packageName	the name of the package.
	 * @return				it will return the name of the current script.
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: 		String packageName = new Object(){
	 * 					public String getClassName()
	 * 				{
	 * 					String temp = this.getClassName();
	 * 					return temp.subString(0,temp.indexOf("$"));
	 * 				}
	 * 				};
	 * 				Reporter.getCurrentTestScriptName(packageName);
	 */
	public static String getCurrentTestScriptName() throws Exception
	{
		String tempScriptName = "";
		String packageName = Reporter.getPackageName();
		if(packageName == null)
		{
			throw new Exception("No such package name.");
		}
		else
		{
			if(packageName.contains("."))
			{
				tempScriptName = packageName.substring(packageName.lastIndexOf(".")+1);
				
			}
			else
			{
				throw new Exception("No . char");
			}
		}
		return tempScriptName;
	}
	
	/**
	 * Define one method used to write the test result into the external Excel file.
	 * @param stepDescription		the step description which is defined in the test case.
	 * @param expectedResult		the expected result.
	 * @param actualResult			the actual result.
	 * @param blnTestResult			the test result
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  	Reporter.setPackageName("com.ao.DEMO");
	 * 			UtilTool.writeTestExecutionResult("Check if the login is displaying","The login screen is displaying","The login screen is displaying",true);
	 */
	@SuppressWarnings({ "static-access" })
	public static void writeTestExecutionResult(String stepDescription,String expectedResult,String actualResult,boolean blnTestResult) throws Exception
	{
		boolean blnFlag = true;
		
		//Start to write the below items one by one.
		//Test Step NO, Step Description,Expected Result,Actual Result,Test Result
		if(Reporter.isNull(stepDescription))
		{
			throw new Exception("stepDescription is null");
		}
		
		if(Reporter.isNull(expectedResult))
		{
			throw new Exception("expectedResult is null");
		}
		
		if(Reporter.isNull(actualResult))
		{
			throw new Exception("actualResult is null");
		}

		String strDestinationPictUUID = UUID.randomUUID().toString();
		String strDestinationPictPath = null;
		
		//Initialize the test report template.
		File file = new File(Reporter.getTestReportFullPath());
		if(!file.exists())
		{
			file = Reporter.initializeReport();
		}
		
		String strTestScriptName = file.getName().trim();
		if(Reporter.isNull(strTestScriptName))
		{
			throw new Exception("the test script's name is null.");
		}
		
		String imagePath = Reporter.SYSTEM_DIR_PATH + "\\TestReport\\TestPicture\\" +
 						strTestScriptName.substring(0, strTestScriptName.indexOf(".")) + "_" + 
							strDestinationPictUUID + ".png";
		
		strDestinationPictPath = Reporter.SYSTEM_DIR_PATH + "\\TestReport\\"+
					 				strTestScriptName.substring(0, strTestScriptName.indexOf(".")) + "_" + 
					 				strDestinationPictUUID;		 				
		
		InputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		CreationHelper helper = workbook.getCreationHelper();
		
		HSSFSheet sheet = workbook.getSheetAt(0);
		//Set the style for the cell
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
		cellStyle.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
		cellStyle.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
		cellStyle.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
		
		//设置单元格背景色
		//cellStyle.setFillForegroundColor(HSSFColor.PINK.index);
		//cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
				
		//字符居中设置
		cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
						
		//单元格垂直设置
		cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				
		//设置字体格式
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体"); 
		font.setFontHeightInPoints((short)14); 
		if(!blnTestResult)
		{
			font.setColor(HSSFColor.RED.index); 
		}
		else
		{
			font.setColor(HSSFColor.GREEN.index);
		}
		font.setBoldweight(font.BOLDWEIGHT_BOLD); 
		font.setItalic(false);
						
		//将字体格式设置到HSSFCellStyle上 style.setFont(font);
		cellStyle.setFont(font);
		
		sheet.setAutobreaks(true);
		sheet.autoSizeColumn((short)0);
		sheet.autoSizeColumn((short)1);
		sheet.autoSizeColumn((short)2);
		sheet.autoSizeColumn((short)3);
		sheet.autoSizeColumn((short)4);
		
		//Write the data passed from the script.
		Row row_info = sheet.getRow(Reporter.intRowInfo);
		if(row_info == null)
		{
			row_info = sheet.createRow(Reporter.intRowInfo);
		}
		
		//Set the Test Step NO
		Cell cell_1 = row_info.getCell(0);
		if(cell_1 == null)
		{
			cell_1 = row_info.createCell(0);
		}
		cell_1.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell_1.setCellStyle(cellStyle);
		cell_1.setCellValue(String.valueOf(Reporter.intStepNO));
		
		//Set the Step Description
		Cell cell_2 = row_info.getCell(1);
		if(cell_2 == null)
		{
			cell_2 = row_info.createCell(1);
		}
		cell_2.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell_2.setCellStyle(cellStyle);
		cell_2.setCellValue(stepDescription);
		
		//Set the Expected Result
		Cell cell_3 = row_info.getCell(2);
		if(cell_3 == null)
		{
			cell_3 = row_info.createCell(2);
		}
		cell_3.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell_3.setCellStyle(cellStyle);
		cell_3.setCellValue(expectedResult);
		
		//Set the Actual Result
		Cell cell_4 = row_info.getCell(3);
		if(cell_4 == null)
		{
			cell_4 = row_info.createCell(3);
		}
		cell_4.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell_4.setCellStyle(cellStyle);
		cell_4.setCellValue(actualResult);
		
		//Set the Test Result
		Cell cell_5 = row_info.getCell(4);
		if(cell_5 == null)
		{
			cell_5 = row_info.createCell(4);
		}
		cell_5.setCellType(HSSFCell.CELL_TYPE_STRING);
		cell_5.setCellStyle(cellStyle);
		if(blnTestResult)
		{
			cell_5.setCellValue("Pass");
		}
		else
		{
			cell_5.setCellValue("Fail");
			//Start to capture the bitmap for the current step.
			//meanwhile we should create a hyper link which could connect to the external captured picture.
			GUICamera.snapShot(imagePath);
			//FileUtil.deleteFile(strImageFullPath);
			//Create the hyper link to the external captured picture.
			Hyperlink link = helper.createHyperlink(Hyperlink.LINK_FILE);
			link.setAddress(imagePath);
			cell_5.setHyperlink((org.apache.poi.ss.usermodel.Hyperlink)link);
		}
		
		//Add the value of the row by one.
		Reporter.intRowInfo++;
		Reporter.intStepNO++;
		
		//Set the height of the currently-operated row.
		row_info.setHeight((short)(15.625*20));
		row_info.setHeightInPoints((float)20);	
		
		//Continue to write the test total result till the current step.
		//Compare the value in the column named 'Test Result'
		for(int i=4;i<=sheet.getLastRowNum();i++)
		{
			Cell cell = sheet.getRow(i).getCell(4);
			String testResult = cell.getStringCellValue();
			//System.out.println(testResult); //Fail Fail Pass
			if(testResult.trim().toLowerCase().equals("pass"))
			{
				blnFlag = blnFlag && true;
			}
			else
			{
				blnFlag = blnFlag && false;
			}
			//System.out.println("blnFlag: " + blnFlag);
		}
				
		//Write the value.
		sheet.getRow(2).getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
		if(blnFlag)
		{
			//Write the test total result.
			sheet.getRow(2).getCell(1).setCellValue("Pass");
		}
		else
		{
			sheet.getRow(2).getCell(1).setCellValue("Fail");
		}
		
		OutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);	
		
		//Close the stream
		outputStream.close();
		inputStream.close();
	}
	
	/**
	 * Write the total test result into the existing file
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-25]
	 * Usage: Reporter.writeTestTotalResult();
	 */
	public static void writeTestTotalResult() throws Exception
	{
		boolean blnFlag = false;
		
		//Within this function, we should check if the current cell's value is pass or fail in the column 'Test Result'.
		File file = new File(Reporter.getTestReportFullPath());
		if(!file.exists())
		{
			throw new Exception("No such test result file.");
		}
		
		//Get the inputstream from the existing test result file. 
		InputStream inputStream = new FileInputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
		HSSFSheet sheet = workbook.getSheetAt(0);
		
		//Compare the value in the column named 'Test Result'
		for(int i=4;i<=sheet.getLastRowNum();i++)
		{
			Cell cell = sheet.getRow(i).getCell(4);
			String testResult = cell.getStringCellValue();
			if(testResult.trim().toLowerCase().equals("pass"))
			{
				blnFlag = blnFlag && true;
			}
			else
			{
				blnFlag = blnFlag && false;
			}
		}
		
		//Write the value.
		sheet.getRow(2).getCell(1).setCellType(HSSFCell.CELL_TYPE_STRING);
		if(blnFlag)
		{
			//Write the test total result.
			sheet.getRow(2).getCell(1).setCellValue("Pass");
		}
		else
		{
			sheet.getRow(2).getCell(1).setCellValue("Fail");
		}
		
		//Output the file.
		OutputStream outputStream = new FileOutputStream(file);
		workbook.write(outputStream);
		
		//Close the stream.
		outputStream.close();
		inputStream.close();
	}
	
	/**
	 * Initialize the report 
	 * @return	it will return a HSSFWorkbook object.
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage:  HSSFWorkbook workbook = Reporter.initializeReport();
	 */
	public static File initializeReport() throws Exception
	{
		//Following are the operations of adding the test information into the file.
		//Firstly we have to write the test script name.
		File file = Reporter.createTestReportTemplate();
		OutputStream outputStream = new FileOutputStream(file);
		HSSFWorkbook workbook = new HSSFWorkbook();
		//Create one new sheet.
		Sheet sheet = workbook.createSheet("Test Result");
		sheet.setColumnWidth((short)0, (short)8000);
		sheet.setColumnWidth((short)1, (short)10000);
		sheet.setColumnWidth((short)2, (short)10000);
		sheet.setColumnWidth((short)3, (short)10000);
		sheet.setColumnWidth((short)4, (short)10000);
		
		sheet.setAutobreaks(true);
		sheet.autoSizeColumn((short)0);
		sheet.autoSizeColumn((short)1);
		sheet.autoSizeColumn((short)2);
		sheet.autoSizeColumn((short)3);
		sheet.autoSizeColumn((short)4);
		
		//Create one new row.
		Row row = sheet.createRow(0);
		Cell cell_TestScriptName = row.createCell(0);
		cell_TestScriptName.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestScriptName.setCellValue("Test Script Name");				
		row.setHeight((short)(15.625*20));
		row.setHeightInPoints((float)20);
		
		//Set the style.
		Cell cell_TestScriptName_01 = row.createCell(1);
		Cell cell_TestScriptName_02 = row.createCell(2);
		Cell cell_TestScriptName_03 = row.createCell(3);
		Cell cell_TestScriptName_04 = row.createCell(4);
		
		cell_TestScriptName_01.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestScriptName_02.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestScriptName_03.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestScriptName_04.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestScriptName_01.setCellValue(Reporter.getCurrentTestScriptName());
				
		//合并单元格
		CellRangeAddress region = new CellRangeAddress(0, 0, 1, 4);
		sheet.addMergedRegion(region);
				
				
		//Start to write the 'Test Execution Time' item.
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String strDateTime = format.format(date);
		Row row_TestExecutionTime = sheet.createRow(1);
		Cell cell_TestExecutionTime_1 = row_TestExecutionTime.createCell(0);
		cell_TestExecutionTime_1.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestExecutionTime_1.setCellValue("Test Execution Time");
		row_TestExecutionTime.setHeight((short)(15.625*20));
		row_TestExecutionTime.setHeightInPoints((float)20);
		
		Cell cell_TestExecutionTime_2 = row_TestExecutionTime.createCell(1);
		Cell cell_TestExecutionTime_3 = row_TestExecutionTime.createCell(2);
		Cell cell_TestExecutionTime_4 = row_TestExecutionTime.createCell(3);
		Cell cell_TestExecutionTime_5 = row_TestExecutionTime.createCell(4);
		
		cell_TestExecutionTime_2.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestExecutionTime_3.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestExecutionTime_4.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestExecutionTime_5.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestExecutionTime_2.setCellValue(strDateTime);
				
		//合并单元格
		CellRangeAddress region_testExecutionTime = new CellRangeAddress(1,1,1,4);
		sheet.addMergedRegion(region_testExecutionTime);
		
		//Set the 'Test Total Result'
		Row rowTestTotalResult = sheet.createRow(2);
		rowTestTotalResult.setHeight((short)(15.625*20));
		rowTestTotalResult.setHeightInPoints((float)20);
		Cell cell_TestTotalResult = rowTestTotalResult.createCell(0);
		cell_TestTotalResult.setCellValue("Test Total Result");
		cell_TestTotalResult.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		
		Cell cell_TestTotalResult_1 = rowTestTotalResult.createCell(1);
		Cell cell_TestTotalResult_2 = rowTestTotalResult.createCell(2);
		Cell cell_TestTotalResult_3 = rowTestTotalResult.createCell(3);
		Cell cell_TestTotalResult_4 = rowTestTotalResult.createCell(4);
		
		cell_TestTotalResult_1.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestTotalResult_2.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestTotalResult_3.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestTotalResult_4.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestTotalResult_1.setCellValue(false);
				
		//合并单元格
		CellRangeAddress region_testTotalResult = new CellRangeAddress(2,2,1,4);
		sheet.addMergedRegion(region_testTotalResult);
				
		//添加Test Step NO，Step Description，Expected Result，Actual Result，Test Result
		Row row_title = sheet.createRow(3);
		row_title.setHeight((short)(15.625*20));
		row_title.setHeightInPoints((float)20);
				
		Cell cell_StepNo = row_title.createCell(0);
		Cell cell_Description = row_title.createCell(1);
		Cell cell_ExpectedResult = row_title.createCell(2);
		Cell cell_ActualResult = row_title.createCell(3);
		Cell cell_TestResult = row_title.createCell(4);
				
		cell_StepNo.setCellValue("Test Step NO");
		cell_Description.setCellValue("Step Description");
		cell_ExpectedResult.setCellValue("Expected Result");
		cell_ActualResult.setCellValue("Actual Result");
		cell_TestResult.setCellValue("Test Result");
				
		cell_StepNo.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_Description.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_ExpectedResult.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_ActualResult.setCellStyle(Reporter.createSimpleCellStyle(workbook));
		cell_TestResult.setCellStyle(Reporter.createSimpleCellStyle(workbook));
				
		//output the file
		workbook.write(outputStream);
		
		//Close the stream.
		//outputStream.close();
		
		//Return the workbook
		return file;
	}
	
	/**
	 * create the test report template.
	 * @return	it will return one File object.
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage:  File file = Reporter.createTestReportTemplate();
	 */
	public static File createTestReportTemplate() throws Exception
	{
		File file = null;
		//Define one variable used to store the current test result file.
		String destinationTestResultFilePath = null;
		String packageName = Reporter.getPackageName();
		
		//Check if the packageName is null or not.
		if(packageName ==  null)
		{
			throw new Exception("No such package name.");
		}
						
		//Get the current script name.
		String currentScriptName = Reporter.getCurrentTestScriptName();
				
		//Verify which folder is the current script according to the script name.
		String moduleName = currentScriptName.toLowerCase().trim();//split("_")[1].
		if(moduleName == null || moduleName.equals(""))
		{
			throw new Exception("the module name is null.");
		}
				
		//Get the corresponding value for the current test script.
		destinationTestResultFilePath = System.getProperty("user.dir") + "\\TestReport\\" + currentScriptName;
		File destionTestResultFile = new File(destinationTestResultFilePath+".xls");
		//Check if the targrt file is existent.
		if(!destionTestResultFile.exists())
		{
			//Create a new file if not existent.
			file = FileUtil.createFile(destionTestResultFile);
		}		
		
		return file;
	}
	
	/**
	 * Get the test report full path.
	 * @return		it will return a String, that means the test report full path.
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage: String filePath = Reporter.getTestReportFullPath();
	 */
	public static String getTestReportFullPath() throws Exception
	{
		String path = "";
		String destinationTestResultFilePath = null;
		String packageName = Reporter.getPackageName();
		
		//Check if the packageName is null or not.
		if(packageName ==  null)
		{
			throw new Exception("No such package name.");
		}
						
		//Get the current script name.
		String currentScriptName = Reporter.getCurrentTestScriptName();
		
				
		//Verify which folder is the current script according to the script name.
		String moduleName = currentScriptName.toLowerCase().trim();//split(".")[1]
		if(moduleName == null || moduleName.equals(""))
		{
			throw new Exception("the module name is null.");
		}
		
		destinationTestResultFilePath = System.getProperty("user.dir") + "\\TestReport\\"+ currentScriptName;
		path = destinationTestResultFilePath + ".xls";
		
		return path;
	}
	
	/**
	 * create a simple style for the current Cell or Row.
	 * @param workbook   HSSFWorkbook object.
	 * @param shtGroundColor  the background color of the Cell or Row.
	 * @return	  it will return a HSSFCellStyle object.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage: HSSFCellStyle cellStyle = Reporter.createSimpleStyle(workbook,HSSFColor.YELLOW.index);
	 */
	@SuppressWarnings("static-access")
	public static HSSFCellStyle createSimpleStyle(HSSFWorkbook workbook,short shtGroundColor) throws Exception
	{
		HSSFCellStyle style = workbook.createCellStyle();
		//设置上下左右四个边框宽度
		style.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
		
		//设置单元格背景色
		style.setFillForegroundColor(shtGroundColor);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		//字符居中设置
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
						
		//单元格垂直设置
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
				
		//设置字体格式
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体"); 
		font.setFontHeightInPoints((short)14); 
		font.setColor(HSSFColor.RED.index); 
		font.setBoldweight(font.BOLDWEIGHT_BOLD); 
		font.setItalic(false);
						
		//将字体格式设置到HSSFCellStyle上 style.setFont(font);
		style.setFont(font);
		
		return style;
	}
	/**
	 * Create a simple cell style for use.
	 * @param workbook   HSSFWorkbook object.
	 * @return			 it will return HSSFCellStyle object.
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage:  HSSFCellStyle cellStyle = Reporter.createSimpleCellStyle(workbook);
	 */
	@SuppressWarnings("static-access")
	public static HSSFCellStyle createSimpleCellStyle(HSSFWorkbook workbook) throws Exception
	{
		HSSFCellStyle style = workbook.createCellStyle();
		//设置上下左右四个边框宽度
		style.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
		style.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
		
		//设置单元格背景色
		style.setFillForegroundColor(HSSFColor.YELLOW.index);
		style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		
		//字符居中设置
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
				
		//单元格垂直设置
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
		
		//设置字体格式
		HSSFFont font = workbook.createFont();
		font.setFontName("宋体"); 
		font.setFontHeightInPoints((short)14); 
		font.setColor(HSSFColor.RED.index); 
		font.setBoldweight(font.BOLDWEIGHT_BOLD); 
		font.setItalic(false);
				
		//将字体格式设置到HSSFCellStyle上 style.setFont(font);
		style.setFont(font);
		
		return style;
	}
	
	/**
	 * Define one method used to check if the total test execution result is pass or fail.
	 * @param sheet				the sheet object.
	 * @return					true/false;
	 * 							if it returns true,it means that the total result is passed.
	 * 							otherwise, it means that it is failed.
	 * @throws Exception
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  UtilTool.getTotalTestResult(sheet);
	 */
	public static boolean getTotalTestResult(Sheet sheet) throws Exception
	{
		boolean blnTotalResult = false;
		try{
				//Within the column named 'Test Result(Pass/Fail)', we need to check if there exists at least one more cell whose value is false;
				//If there exists one more 'false' value, the total test result should be failed.
			int intColumn_TestResult = Reporter.getColumnIndex(sheet,"Test Result");
			Iterator<Row> iterator = sheet.rowIterator();
			while(iterator.hasNext())
			{
				if(((Row)iterator.next()).getRowNum() >= 4)
				{
					if(Boolean.parseBoolean(((Row)iterator.next()).getCell(intColumn_TestResult).getStringCellValue()))
					{
						blnTotalResult = true;
					}
					else
					{
						blnTotalResult = false;
					}
				}
			}
			
		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		//Return the result.
		return blnTotalResult;
	}
	
	/**
	 * Define one method used to get the index of the column.
	 * @param sheet			sheet object.
	 * @param columnName	the name of the column.
	 * @return				it will return the index of the column 
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intIndex = Reporter.getColumnIndex(sheet,"DEMO");
	 */
	public static int getColumnIndex(Sheet sheet,String columnName) throws Exception
	{
		int index_Column = -1; //Define one variable used to get the index of the column.
		Row row = sheet.getRow(3); //Get the row according to the index.
		int intTotalNumberColumn = row.getLastCellNum(); 
		for(int i=0;i<intTotalNumberColumn;i++)
		{
			Cell cell = row.getCell(i);
			if(cell.getStringCellValue().equals(columnName))
			{
				index_Column = cell.getColumnIndex();
				break;
			}
		}
		
		//Return the column index.
		return index_Column;
	}
	
	/**
	 * Define one method used to validate whether the passed variables is null.
	 * @param temp
	 * @return   true/false;
	 * 			if it's null, it returns false value.
	 * 			Otherwise, it will return true value.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: boolean blnExist = Reporter.isNull(obj);
	 */
	public static boolean isNull(Object temp)
	{
		boolean blnNull = false;
		
		if(temp == null)
		{
			blnNull = true;
		}
		else
		{
			if(temp.equals(""))
			{
				blnNull = true;
			}
			else
			{
				blnNull = false;
			}
		}
		
		return blnNull;
	}
	
	/**
	 * This method is used to get the step number
	 * @return  it will return the step number.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage: int intNO = Reporter.getIntStepNO();
	 */
	public static int getIntStepNO() {
		return intStepNO;
	}

	/**
	 * This method is used to set the step number.
	 * @param intStepNO  the step number.
	 * @return  none
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-19]
	 * Usage:  Reporter.setIntStepNO(2);
	 */
	public static void setIntStepNO(int intStepNO) {
		Reporter.intStepNO = intStepNO;
	}
	
	/**
	 * Get a package name.
	 * @return	it will return a package name.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage: String packageName = Reporter.getPackageName();
	 */
	public static String getPackageName() {
		return packageName;
	}
	
	/**
	 * Set the package name.
	 * @param packageName  the package name.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage: Reporter.setPackageName("com.ao.DEMO");
	 */
	public static void setPackageName(String packageName) {
		Reporter.packageName = packageName;
	}
	
	/**
	 * Get the row number where the detailed test execution will be written down.
	 * @return it will return the row number.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage :  int intRow = Reporter.getIntRowInfo();
	 */
	public static int getIntRowInfo() {
		return intRowInfo;
	}
	
	/**
	 * Set the row number where we will write down the detailed test execution.
	 * @param intRowInfo  the number of the row.
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-23]
	 * Usage: Reporter.setIntRowInfo(2);
	 */
	public static void setIntRowInfo(int intRowInfo) {
		Reporter.intRowInfo = intRowInfo;
	}
	
	/**
	 * Get the cell's value according to its type.
	 * @param cell   HSSFCell object.
	 * @return  it will the value of a cell we want.
	 * @throws Exception
	 * @author techie_zhu
	 * Created By Techie Zhu [2014-11-25]
	 * Usage: String value = Reporter.getCellStringValue(cell);
	 */
	public static String getCellStringValue(HSSFCell cell) throws Exception
	{
		String cellValue = "";
		
		switch(cell.getCellType())
		{
			case HSSFCell.CELL_TYPE_STRING: 
				cellValue = cell.getStringCellValue();
				if(cellValue.trim().equals("") || cellValue.trim().length() <= 0)
				{
					cellValue = "";
				}
				break;
			case HSSFCell.CELL_TYPE_NUMERIC:
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_FORMULA:
				cell.setCellType(HSSFCell.CELL_TYPE_NUMERIC);
				cellValue = String.valueOf(cell.getNumericCellValue());
				break;
			case HSSFCell.CELL_TYPE_ERROR:
				break;
			case HSSFCell.CELL_TYPE_BOOLEAN:
				cellValue = String.valueOf(cell.getBooleanCellValue());
			case HSSFCell.CELL_TYPE_BLANK:
				cellValue = "";
				break;
			default:
				break;
		}
		
		//Return the value.
		return cellValue;
	}
	
//	public static void main(String[] args) throws Exception
//	{
////		/*String packageName = new Object() {  
////		       public String getClassName() {  
////		            String clazzName = this.getClass().getName();  
////		            return clazzName.substring(0, clazzName.lastIndexOf('$'));  
////		        }  
////	    }.getClassName();
////		*/
//	Reporter.setPackageName("com.wiselong.api.B_API_01");
//	Reporter.writeTestExecutionResult("Check if login is displaying", "The login is displaying.", "The login is really displaying.", false);
//	// Reporter.writeTestExecutionResult("Check if logout is displaying.","logout is displaying.","logout is displaying.",false);
//	Reporter.writeTestExecutionResult("Check if login is displaying", "The login is displaying.", "The login is really displaying.", true);
//	Reporter.writeTestExecutionResult("Check if logout is displaying.","logout is displaying.","logout is displaying.",false);
//		
//	}
}