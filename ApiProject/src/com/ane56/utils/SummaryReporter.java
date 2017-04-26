package com.ane56.utils;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.hssf.usermodel.HSSFBorderFormatting;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;

public class SummaryReporter {
		//Define some global constants.
		private static final String PORTAL_FOLDER_PATH = "\\TestReport\\Test_Report_Portal\\";
		private static final String CASH_FOLDER_PATH = "\\TestReport\\Test_Report_Cash\\";
		private static final String ORDER_FOLDER_PATH = "\\TestReport\\Test_Report_Order\\";
		private static final String TAKEAWAY_FOLDER_PATH = "\\TestReport\\Test_Report_TakeAway\\";
		private static final String TEST_SUMMARY_REPORT_ALL_MODULES = "\\TestReport\\Test_Report_Summary\\";
		private static final String TEST_REPORT_PARENT_RELATIVE_PATH = "\\TestReport\\";
		private static final String SYSTEM_DIR_PATH = System.getProperty("user.dir");
		private static int intRowNumber = 1;
		
		//Define the FileFilter instance and its filtering criteria we use.
			private static final FileFilter filter = new FileFilter(){
				public boolean accept(File file){
						String name = file.getName().trim().toLowerCase();
						if(name.endsWith(".xls"))
						{
							if(name.equals("Test_Result_Summary.xls"))
							{
								return false;
							}
							else
							{
								return true;
							}
						}
						else
						{
							return false;
						}
					}
			};
		
		/**
		 * Get the folder path.
		 * @param folderPath  the relative path of the module. 
		 * @return	it will return the absolute path of the module.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-23]
		 * Usage: String absoluteFolderPath = SummaryReporter.getFolderPath(SummaryReporter.PORTAL_FOLDER_PATH);
		 */
		public static String getFolderPath(String folderPath) throws Exception
		{
			if(Reporter.isNull(folderPath))
			{
				throw new Exception("folderPath is null");
			}
			
			return SummaryReporter.SYSTEM_DIR_PATH+folderPath;
		}	
		/**
		 * Delete all files under a specific folder path.
		 * @param path  the path of the folder.
		 * @return     true/false
		 * 				true means that all those sub-files under a given folder path have been deleted successfully.
		 * 				false means that they haven't been yet deleted successfully.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-24]
		 * Usage:  SummaryReporter.deleteFile("C:\\Users\\techie_zhu\\Desktop\\test\\");
		 */
		public static boolean deleteFile(String path) throws Exception
		{
			boolean blnDeleteSuccess = false;
			
			if(Reporter.isNull(path))
			{
				throw new Exception("Path is null");
			}
			
			File file = new File(path);
			//Check if the passed path is a directory or file.
			if(file.isFile())
			{
				throw new Exception("The path is the file path,not a directory path.");
			}
			
			for(File temp:file.listFiles())
			{
				if(temp.isFile())
				{
					temp.delete();
				}
			}
			
			blnDeleteSuccess = true;
			
			return blnDeleteSuccess;
		}
		
		/**
		 * Delete the fiels under one specific folder path.
		 * @param path   the path of the folder.
		 * @return		none.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-24]
		 * Usage:  SummaryReporter.deleteFileUsingFilter("C:\\test\\");
		 */
		public static void deleteFileUsingFilter(String path) throws Exception
		{
			//Check if the two parameters are null.
			//If they two are null, just throw the corresponding exceptions.
			if(Reporter.isNull(path))
			{
				throw new Exception("The path is null.");
			}
			
			if(Reporter.isNull(filter))
			{
				throw new Exception("The FileFilter object is null");
			}
			
			File file = new File(path);
			for(File temp:file.listFiles(SummaryReporter.filter))
			{
				if(temp.isDirectory())
				{
					SummaryReporter.deleteFile(temp.getPath());
				}
				else
				{
					temp.delete();
				}
			}
		}
		
		/**
		 * Get the detailed test execution information in a HashMap.
		 * @param folderPath   the path of the folder.
		 * @return			   it will a HashMap<String,String> containing the test result of each script. 
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-24]
		 * Usage: HashMap<String,String> map = SummaryReporter.getDetailedTestExecutionResult(SummaryReporter.PORTAL_FOLDER_PATH);
		 */
		public static Map<String,String> getDetailedTestExecutionResult(String folderPath) throws Exception
		{
			Map<String,String> map = new TreeMap<String,String>();
			String absolutePath = "";
			String systemDir = SummaryReporter.SYSTEM_DIR_PATH;
			//Check if the passed variable is null
			if(Reporter.isNull(folderPath))
			{
				throw new Exception("folderPath is null.");
			}
			
			//Get the absolute folder path for the passed folder path according to its name.
			if(folderPath.equals(SummaryReporter.PORTAL_FOLDER_PATH))
			{
				absolutePath = systemDir + SummaryReporter.PORTAL_FOLDER_PATH;
			}
			else if(folderPath.equals(SummaryReporter.CASH_FOLDER_PATH))
			{
				absolutePath = systemDir + SummaryReporter.CASH_FOLDER_PATH;
			}
			else if(folderPath.equals(SummaryReporter.ORDER_FOLDER_PATH))
			{
				absolutePath = systemDir + SummaryReporter.ORDER_FOLDER_PATH;
			}
			else if(folderPath.equals(SummaryReporter.TAKEAWAY_FOLDER_PATH))
			{
				absolutePath = systemDir + SummaryReporter.TAKEAWAY_FOLDER_PATH;
			}
			else
			{
				throw new Exception("the folder path of the module is incorrect.");
			}
			
			File file = new File(absolutePath);
			if(!file.exists())
			{
				throw new Exception("The file is not existent.");
			}
			else
			{
				if(file.isFile())
				{
					throw new Exception("absolutePath is not a directory.");
				}
			}

			for(File temp : file.listFiles(filter))
			{
				if(temp.getName().contains("Summary"))
				{
					continue;
				}
				String testResult = SummaryReporter.getTestResult4SingleScript(temp.getName().trim());
				map.put(temp.getName(), testResult);
			}
			
			return map;
		}
		
		/**
		 * Get the real test result for a single test script.
		 * @param fileName   the name of the file. 
		 * @return			 it will return the real test result. 
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-24]
		 * Usage: String testResult = SummaryReporter.getTestResult4SingleScript("....");
		 */
		public static String getTestResult4SingleScript(String fileName) throws Exception
		{
			//Define one variable used to get the real test result.
			String testResult = "";
			String strFileAbsoluatePath = null;
			//Check if the current file is null.
			if(Reporter.isNull(fileName))
			{
				throw new Exception("fileName is null");
			}
			else
			{
				if(!fileName.endsWith(".xls"))
				{
					throw new Exception("the format of the test file is not correct.");
				}
			}
			
			//Start to get the value of the column named 'Test Total Result'.
			//According to the passed parameter, we can get its absolute path.
			String filePath = SummaryReporter.getModuleRelativePathByFileName(fileName);
			//System.out.println("filepath is :"+filePath);
			
			if(filePath.trim().toLowerCase().equals("cash"))
			{
				strFileAbsoluatePath = SummaryReporter.SYSTEM_DIR_PATH + SummaryReporter.CASH_FOLDER_PATH + fileName;
			}
			else if(filePath.trim().toLowerCase().equals("order"))
			{
				strFileAbsoluatePath = SummaryReporter.SYSTEM_DIR_PATH + SummaryReporter.ORDER_FOLDER_PATH + fileName;
			}
			else if(filePath.trim().toLowerCase().equals("portal"))
			{
				strFileAbsoluatePath = SummaryReporter.SYSTEM_DIR_PATH + SummaryReporter.PORTAL_FOLDER_PATH + fileName;
			}
			else if(filePath.trim().toLowerCase().equals("takeaway"))
			{
				strFileAbsoluatePath = SummaryReporter.SYSTEM_DIR_PATH + SummaryReporter.TAKEAWAY_FOLDER_PATH + fileName;
			}
			else
			{
				throw new Exception("the absolute path of the test report file is not existent.");
			}
			
			//System.out.println("strFileAbsoluatePath:="+strFileAbsoluatePath);
			
			File file = new File(strFileAbsoluatePath);
			InputStream inputStream = new FileInputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook(inputStream);
			HSSFSheet sheet = workbook.getSheetAt(0);
			
			//Get the value.
			testResult = sheet.getRow(2).getCell(1).getStringCellValue().trim();
			
			//Close the inputStream.
			inputStream.close();
			
			//Return the value.
			return testResult;
		}
		
		/**
		 * Get the relative path of the module by a given test report file name.
		 * @param fileName   the file's name.
		 * @return			 it will return a relative path of the module.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-26]
		 * Usage: String moduleRelativePath = SummaryReporter.getModuleRelativePathByFileName("TC_Cash_01_VerifyLogin.xls");
		 */
		public static String getModuleRelativePathByFileName(String fileName) throws Exception
		{
			String relativePath = "";
			
			if(Reporter.isNull(fileName))
			{
				throw new Exception("fileName is null.");
			}
			else
			{
				if(!fileName.endsWith(".xls"))
				{
					throw new Exception("The format of the file is incorrect.");
				}
				else
				{
					//Filter the summary file.
					if(!fileName.equals("Test_Result_Summary.xls"))
					{
						//Start to parse the module name from the file name.
						String[] arrTemp = fileName.split("_");
						relativePath = arrTemp[1];
					}
				}
			}
			
			//Return the value.
			return relativePath;
		}
		
		/**
		 * Generate the test result summary file. 
		 * @param folderPath   the path of the folder where we want to generate the summary file. 
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-24]
		 * Usage: SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.PORTAL_FOLDER_PATH);
		 */
		@SuppressWarnings("deprecation")
		public static void generateTestResultSummaryReport4EachModule(String folderPath) throws Exception
		{
			if(Reporter.isNull(folderPath))
			{
				throw new Exception("folderPath is null.");
			}
			String moduleName = "";
			if(folderPath.trim().toLowerCase().contains("cash"))
			{
				moduleName = "收银模块";
			}
			else if(folderPath.trim().toLowerCase().contains("portal"))
			{
				moduleName = "壳子模块";
			}
			else if(folderPath.trim().toLowerCase().contains("order"))
			{
				moduleName = "订单";
			}
			else if(folderPath.trim().toLowerCase().contains("takeaway"))
			{
				moduleName = "外卖";
			}
			else
			{
				throw new Exception("the module name is incorrect.");
			}
			
			Map<String,String> map = SummaryReporter.sortMapByKey(SummaryReporter.getDetailedTestExecutionResult(folderPath));
			if(Reporter.isNull(map))
			{
				throw new Exception("Map is null.");
			}

			File file = new File(SummaryReporter.SYSTEM_DIR_PATH+folderPath+"Test_Result_Summary.xls");
			if(file.exists())
			{
				file.delete();
			}
			
			FileUtil.createFile(SummaryReporter.SYSTEM_DIR_PATH + folderPath+"Test_Result_Summary.xls");
			OutputStream outputStream = new FileOutputStream(file);
			HSSFWorkbook workbook = new HSSFWorkbook();
			CreationHelper helper = workbook.getCreationHelper();
			HSSFSheet sheet = workbook.createSheet("Test_Result_Summary");
			sheet.setAutobreaks(true);
			sheet.autoSizeColumn((short)0);
			sheet.autoSizeColumn((short)1);
			sheet.autoSizeColumn((short)2);
			
			sheet.setColumnWidth((short)0, (short)10000);
			sheet.setColumnWidth((short)1, (short)20000);
			sheet.setColumnWidth((short)2, (short)10000);
			//Start to create the title of the file.
			//'Test Script Name' and 'Test Result'
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell_title_01 = row.createCell(0);
			cell_title_01.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_title_01.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook));
			cell_title_01.setCellValue("Test Module");
			
		
			HSSFCell cell_title_02 = row.createCell(1);
			cell_title_02.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_title_02.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook));
			cell_title_02.setCellValue("Test Script Name");
			
			HSSFCell cell_title_03 = row.createCell(2);
			cell_title_03.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_title_03.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook));
			cell_title_03.setCellValue("Test Result");
			
			//Start to write each script's test reuslt parsing from a map. 
			Set<String> key = map.keySet();
			Object[] objKey = key.toArray();
			int intTestScriptNumber = key.size();
			for(int i=0;i<intTestScriptNumber;i++)
			{
				HSSFRow row_TestResult = sheet.createRow(i+1);
				if(i==0)
				{
					HSSFCell cell_module = row_TestResult.createCell(0);
					cell_module.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook,(short)0,HSSFColor.GREEN.index));
					cell_module.setCellType(HSSFCell.CELL_TYPE_STRING);
					cell_module.setCellValue(moduleName);
				}
				else
				{
					HSSFCell cell_module = row_TestResult.createCell(0);
					cell_module.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook,(short)0,HSSFColor.GREEN.index));
					cell_module.setCellType(HSSFCell.CELL_TYPE_STRING);
				}
				
				HSSFCell cell_TestScriptName = row_TestResult.createCell(1);			
				cell_TestScriptName.setCellType(HSSFCell.CELL_TYPE_STRING);
				//Remove the extension of the file.
				String scriptName = ((String)objKey[i]).replace(".xls", "");
				cell_TestScriptName.setCellValue(scriptName);
				
				//Get the full path of the test script.
				String strFullPath4TestReport = "";
				String strModuleName = scriptName.split("_")[1];
				if(strModuleName.trim().toLowerCase().equals("cash"))
				{
					strFullPath4TestReport = SummaryReporter.SYSTEM_DIR_PATH + 
											 SummaryReporter.CASH_FOLDER_PATH +
											 scriptName + ".xls";
				}
				else if(strModuleName.trim().toLowerCase().equals("portal"))
				{
					strFullPath4TestReport = SummaryReporter.SYSTEM_DIR_PATH + 
							 SummaryReporter.PORTAL_FOLDER_PATH +
							 scriptName + ".xls";
				}
				else if(strModuleName.trim().toLowerCase().equals("order"))
				{
					strFullPath4TestReport = SummaryReporter.SYSTEM_DIR_PATH + 
							 SummaryReporter.ORDER_FOLDER_PATH +
							 scriptName + ".xls";
				}
				else if(strModuleName.trim().toLowerCase().equals("takeaway"))
				{
					strFullPath4TestReport = SummaryReporter.SYSTEM_DIR_PATH + 
							 SummaryReporter.TAKEAWAY_FOLDER_PATH +
							 scriptName + ".xls";
				}
				else
				{
					throw new Exception("No such module name.");
				}
				
				HSSFCell cell_TestResult = row_TestResult.createCell(2);
				cell_TestResult.setCellType(HSSFCell.CELL_TYPE_STRING);
				String strTestResult = map.get((String)objKey[i]);
				if(strTestResult.trim().toLowerCase().equals("pass"))
				{
					cell_TestResult.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.GREEN.index));
					cell_TestScriptName.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.GREEN.index));
				}
				else
				{
					cell_TestScriptName.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.RED.index));
					cell_TestResult.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.RED.index));
					Hyperlink link = helper.createHyperlink(Hyperlink.LINK_FILE);
					link.setAddress(strFullPath4TestReport);
					cell_TestResult.setHyperlink((org.apache.poi.ss.usermodel.Hyperlink) link);
				}
				cell_TestResult.setCellValue(strTestResult);
			}
			
			//Merge the first column.
			CellRangeAddress cellRange = new CellRangeAddress(1,intTestScriptNumber,0,0);
			sheet.addMergedRegion(cellRange);
			
			
			//output the file into the target folder path. 
			workbook.write(outputStream);
			
			//close the OutputStream.
			outputStream.close();
		}
		
		/**
		 * setup the HSSFCellStyle for the cell.
		 * @param workbook			HSSFWorkbook object.
		 * @param foregroundColor	the color of the foreground part of a cell.
		 * @param fontColor			the color of the font used in the cell.
		 * @return					it will return a HSSFCellStyle object.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-26]
		 * Usage: HSSFCellStyle cellStyle = SummaryReporter.createHSSFCellStyle(workbook,HSSFColor.PINK.index,HSSFColor.RED.index);
		 */
		public static HSSFCellStyle createHSSFCellStyle(HSSFWorkbook workbook,short foregroundColor,short fontColor) throws Exception
		{
			//Check if the current object is null.
			if(Reporter.isNull(workbook))
			{
				throw new Exception("workbook is null.");
			}
			
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			//设置上下左右四个边框宽度
			cellStyle.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
			cellStyle.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
			cellStyle.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
			
			//设置单元格背景色
			if(foregroundColor == 0)
			{
				//Do nothing
			}
			else
			{
				cellStyle.setFillForegroundColor(foregroundColor);
				cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
			}
			
			
			//字符居中设置
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
							
			//单元格垂直设置
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
					
			//设置字体格式
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体"); 
			font.setFontHeightInPoints((short)14); 
			font.setColor(fontColor); 
			font.setBoldweight(Font.BOLDWEIGHT_BOLD); 
			font.setItalic(false);
							
			//将字体格式设置到HSSFCellStyle上 style.setFont(font);
			cellStyle.setFont(font);
			
			//Return the cellStyle
			return cellStyle;
		}
		
		/**
		 * Create the desired cell style for the file.
		 * @param workbook   HSSFWorkbook object.
		 * @return           it will return a HSSFCellStyle object.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-24]
		 * Usage: HSSFCellStyle cellStyle = SummaryReporter.createHSSFCellStyle(workbook);
		 */
		@SuppressWarnings("static-access")
		public static HSSFCellStyle createHSSFCellStyle(HSSFWorkbook workbook) throws Exception
		{
			if(Reporter.isNull(workbook))
			{
				throw new Exception("workbook is null.");
			}
			
			HSSFCellStyle cellStyle = workbook.createCellStyle();
			//设置上下左右四个边框宽度
			cellStyle.setBorderTop(HSSFBorderFormatting.BORDER_THIN);
			cellStyle.setBorderBottom(HSSFBorderFormatting.BORDER_THIN);
			cellStyle.setBorderLeft(HSSFBorderFormatting.BORDER_THIN);
			cellStyle.setBorderRight(HSSFBorderFormatting.BORDER_THIN);
			
			//设置单元格背景色
			cellStyle.setFillForegroundColor(HSSFColor.PINK.index);
			cellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
					
			//字符居中设置
			cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
							
			//单元格垂直设置
			cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
					
			//设置字体格式
			HSSFFont font = workbook.createFont();
			font.setFontName("宋体"); 
			font.setFontHeightInPoints((short)14); 
			font.setColor(HSSFColor.RED.index); 
			font.setBoldweight(font.BOLDWEIGHT_BOLD); 
			font.setItalic(false);
							
			//将字体格式设置到HSSFCellStyle上 style.setFont(font);
			cellStyle.setFont(font);
			
			//Return the cellStyle
			return cellStyle;
		}
		
		/**
		 * This function is used to generate the summary report for all modules. 
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-25]
		 * Modified By Techie Zhu [2014-11-28] Add one new function that's each listed script could open its corresponding original test report once clicking it.
		 * Usage: SummaryReporter.generateTestResultSummaryReport4AllModules()
		 */
		@SuppressWarnings("deprecation")
		public static void generateTestResultSummaryReport4AllModules() throws Exception
		{
			//Firstly we have to get the root path for the 'TestReport' folder.
			String strTestReportRelativePath = SummaryReporter.SYSTEM_DIR_PATH + SummaryReporter.TEST_REPORT_PARENT_RELATIVE_PATH ;
			//Check if there exists the folder named 'TestReport'.
			if(Reporter.isNull(strTestReportRelativePath))
			{
				throw new Exception("There doesn't exist the folder named 'TestReport'");
			}
			
			File fileTestReport = new File(strTestReportRelativePath);
			//Check if the 'Test_Report_Summary.xls' file is existent.
			String strTestReportSummaryPath = SummaryReporter.SYSTEM_DIR_PATH + SummaryReporter.TEST_SUMMARY_REPORT_ALL_MODULES+"Test_Report_Summary.xls";
			File file_TestReportSummary = new File(strTestReportSummaryPath);
			
			if(file_TestReportSummary.exists())
			{
				file_TestReportSummary.delete();
			}
			
			//Create a new file.
			FileUtil.createFile(strTestReportSummaryPath);
			OutputStream outputStream = new FileOutputStream(file_TestReportSummary);
			HSSFWorkbook workbook = new HSSFWorkbook();
			CreationHelper helper = workbook.getCreationHelper();
			
			HSSFSheet sheet = workbook.createSheet("StatisticsReport");
			
			sheet.setAutobreaks(true);
			sheet.setColumnWidth((short)0, (short)8000);
			sheet.setColumnWidth((short)1, (short)20000);
			sheet.setColumnWidth((short)2, (short)10000);
			HSSFRow row = sheet.createRow(0); //Create the tile. 'Module Name','Test Script Name' and 'Test Total Result'
			row.setHeight((short)(15.625*20));
			row.setHeightInPoints((float)20);
			HSSFCell cell_Title_01 = row.createCell(0);
			cell_Title_01.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook));
			cell_Title_01.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_Title_01.setCellValue("Module Name");
			
			HSSFCell cell_Title_02 = row.createCell(1);
			cell_Title_02.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook));
			cell_Title_02.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_Title_02.setCellValue("Test Script Name");
			
			HSSFCell cell_Title_03 = row.createCell(2);
			cell_Title_03.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook));
			cell_Title_03.setCellType(HSSFCell.CELL_TYPE_STRING);
			cell_Title_03.setCellValue("Test Total Result");
			
			for(File file: fileTestReport.listFiles())
			{
				//Check if the child file is a directory or a file. 
				if(file.isFile())
				{
					continue;
				}
				else if(file.isDirectory())
				{
					//Get its name of the current directory. 
					String strModuleName = file.getName().trim();
					//Check if the current direcotry's name is 'Test_Report_Summary'
					if(strModuleName.trim().equals("Test_Report_Summary"))
					{
						continue;
					}
					
					int intSize = file.listFiles(filter).length;
					if(intSize == 0)
					{
						continue;
					}
					
					//Need to filter the sub-files.
					for(File fileTestReportFile:file.listFiles(filter))
					{
						//Filter the Test_Result_Summary.xls file which is distributed in each module.
						if(fileTestReportFile.getName().trim().equals("Test_Result_Summary.xls"))
						{
							//Skip this step.
							continue;       
						}
						else
						{
							//Get the name of each script.
							String strTestReportFileName = fileTestReportFile.getName().trim();
							String strTestResult = SummaryReporter.getTestResult4SingleScript(strTestReportFileName);
							
							HSSFRow row_data = sheet.createRow(intRowNumber);
							row_data.setHeight((short)(15.625*20));
							row_data.setHeightInPoints((float)20);
							
							HSSFCell cell_data_0 = row_data.createCell(0);
							HSSFCell cell_data_1 = row_data.createCell(1);
							HSSFCell cell_data_2 = row_data.createCell(2);
							cell_data_0.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell_data_1.setCellType(HSSFCell.CELL_TYPE_STRING);
							cell_data_2.setCellType(HSSFCell.CELL_TYPE_STRING);
							String scriptName = strTestReportFileName.substring(0, strTestReportFileName.indexOf("."));
							cell_data_1.setCellValue(scriptName);
							
							String moduleName = strModuleName.split("_")[2].trim().toUpperCase();
							cell_data_0.setCellValue(moduleName);
							
							if(Reporter.isNull(strTestResult))
							{
								throw new Exception("The test result is null.");
							}
							
							if(strTestResult.trim().toLowerCase().equals("pass"))
							{
								cell_data_0.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.GREEN.index));
								cell_data_1.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.GREEN.index));
								cell_data_2.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.GREEN.index));

								//Set the values.
								cell_data_2.setCellValue("Pass");
							}
							else
							{
								cell_data_0.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.RED.index));
								cell_data_1.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.RED.index));
								cell_data_2.setCellStyle(SummaryReporter.createHSSFCellStyle(workbook, (short)0, HSSFColor.RED.index));

								//Set the values.
								cell_data_2.setCellValue("Fail");
								
								Hyperlink link = helper.createHyperlink(Hyperlink.LINK_FILE);
								//System.out.println(fileTestReportFile.getAbsolutePath());
								link.setAddress(fileTestReportFile.getAbsolutePath());
								cell_data_2.setHyperlink((org.apache.poi.ss.usermodel.Hyperlink) link);
							}
							
							intRowNumber++;
						}
					}
				}
			}
			workbook.write(outputStream);
			
			//Close the OutputStream. 
			outputStream.close();			
		} 
		
		/**
		 * Sort the treeMap by its key value.
		 * @param map		the treeMap object.
		 * @return			the treeMap object which has been sorted by a criteria.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-26]
		 * Usage: Map<String,String> map = SummaryReporter.sortMapByKey(map);
		 */
		public static Map<String,String> sortMapByKey(Map<String,String> map) throws Exception
		{
			if(map == null || map.isEmpty())
			{
				return null;
			}
			
			//Define one treemap object to sort the map by its key value using the comparator interface.
			Map<String,String> sortMap = new TreeMap<String,String>(new Comparator<String>(){
				public int compare(String key1, String key2) {
					int intKey1 = 0, intKey2 = 0;  
		            try {  
		                	intKey1 = getInt(key1);  
		                	intKey2 = getInt(key2);  
		            	} catch (Exception e) 
		            	{  
		            		intKey1 = 0;   
		            		intKey2 = 0;  
		            	}  
		            	return intKey1 - intKey2;  
				}
			});
			
			sortMap.putAll(map);
			return sortMap;
		}
		
		/**
		 * Transfer a string into an integer value.
		 * @param str   the string value to be transferred.
		 * @return      it will return an integer value based on a given string value.
		 * @author techie_zhu
		 * Created By Techie Zhu [2014-11-26]
		 * Usage: int intValue = getInt("TC_Cash_01_VerifyLogin.xls");
		 */
		private static int getInt(String str) 
		{  
		    int i = 0;  
		    try {  
		    		String[] arrTemp = str.split("_");
		    		String strTemp = arrTemp[2];
		    		String strFinalValue = "";
		    		
		    		//Check if the first position's character is 0.
		    		if(strTemp.length() >= 2)
		    		{
		    			//Get the character of the first position.
		    			char chr = strTemp.charAt(0);
		    			if(String.valueOf(chr).equals("0"))
		    			{
		    				strFinalValue = strTemp.substring(1);
		    			}
		    		}
		    		
		        	if ((strFinalValue != null) && (!strFinalValue.equals(""))) 
		        	{  
		        		i = Integer.valueOf(strFinalValue);  
		        	}  
		    	} catch (NumberFormatException e)
		    	{  
		    		e.printStackTrace();  
		    	}  
		    return i;  
		}  
		
		/**
		 * Generate the summary test report for the portal module.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie [2014-11-24]
		 * Usage: SummaryReporter.generateSummaryReport4PortalFolder();
		 */
		public static void generateSummaryReport4PortalFolder() throws Exception
		{
			SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.PORTAL_FOLDER_PATH);
		}
		
		/**
		 * Generate the summary report for the 'Cash' module.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie [2014-11-24]
		 * Usage: SummaryReporter.generateSummaryReport4CashFolder();
		 */
		public static void generateSummaryReport4CashFolder() throws Exception
		{
			SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.CASH_FOLDER_PATH);
		}
		
		/**
		 * Generate the summary report for the 'TakeAway' module.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie [2014-11-24]
		 * Usage: SummaryReporter.generateSummaryReport4TakeAwayFolder()
		 */
		public static void generateSummaryReport4TakeAwayFolder() throws Exception
		{
			SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.TAKEAWAY_FOLDER_PATH);
		}
		
		/**
		 * Generate the summary report for the 'Order' module.
		 * @throws Exception
		 * @author techie_zhu
		 * Created By Techie [2014-11-24]
		 * Usage: SummaryReporter.generateSummaryReport4OrderFolder()
		 */
		public static void generateSummaryReport4OrderFolder() throws Exception
		{
			SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.ORDER_FOLDER_PATH);
		}
		
		
//		public static void main(String[] args) throws Exception {
//			//Generate a total test result for the below module.
//			SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.CASH_FOLDER_PATH);
//			//SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.ORDER_FOLDER_PATH);
//			//SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.PORTAL_FOLDER_PATH);
//			//SummaryReporter.generateTestResultSummaryReport4EachModule(SummaryReporter.TAKEAWAY_FOLDER_PATH);
//			
//			//Generate a total test result for all the modules.
//			//SummaryReporter.generateTestResultSummaryReport4AllModules();
//		}

}
