package com.ane56.lbtest.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class HtmlReport
{
	private final static String DATE = new SimpleDateFormat("yyyyMMdd").format(new Date());
	private final static String DIR = System.getProperty("user.dir") + "/HtmlReport/" + DATE;
	private final static String DETAIL_REPORT_PATH = DIR + "/Detail_Report_" + DATE + ".html";
	private final static String SUMMARY_REPORT_PATH = DIR + "/Summary_Report_" + DATE + ".html";
	private static StringBuilder sb;
	private static RandomAccessFile htmlfile;
	private final static Logger logger = Logger.getLogger(HtmlReport.class);

	/**
	 * html文件尾部追加内容
	 * 
	 * @author wangHui
	 * @param path
	 */
	public static void writeContentToHtml(String path)
	{
		try
		{
			File f = new File(DIR);
			if (!f.exists())
				f.mkdirs();
			htmlfile = new RandomAccessFile(path, "rw");
			// 文件长度，字节数
			long fileLength = htmlfile.length();
			// 将写文件指针移到文件尾。
			htmlfile.seek(fileLength);
			htmlfile.write(sb.toString().getBytes());
			htmlfile.close();
		} catch (Exception e)
		{
			logger.info("html追加内容失败");
			e.printStackTrace();
		}

	}

	/**
	 * 初始化Detail报告内容(添加必要的CSS和JS)
	 * 
	 * @author wangHui
	 */
	public static void initializeDetailReporter()
	{
		File file = new File(DETAIL_REPORT_PATH);
		if (file.exists())
			file.delete();
		sb = new StringBuilder();
		sb.append("<html>\n");
		sb.append("<head><meta http-equiv=Content-Type content=text/html; charset=gbk>\n");
		sb.append("<title>鲁班系统自动化测试详细报告</title>\n");
		// 添加CSS样式
		sb.append("<style type=\"text/css\" media=\"screen\">\n");
		sb.append("h1{font-size: 22pt;color: #5B5B5B;font-family: 楷体;margin-left:1.5ex;}\n");
		sb.append(".heading {margin-top: 0ex;margin-bottom: 1ex;}\n");
		sb.append(".top {margin-top: 2ex;margin-bottom: 0;}\n");
		sb.append(".top1 {margin-top: 2ex;margin-bottom: 0;}\n");
		sb.append(".middle {margin-left:165ex;margin-top: 1ex;}\n");
		sb.append(".bottom {margin-top: 0;margin-bottom: 1.5ex;}\n");
		sb.append("body {margin-left:1ex;}\n");
		sb.append("div {margin-left:4ex;font-family: Cambria;color: #4F4F4F;}\ntable {margin-left:5ex;}\n");
		sb.append(
				".modelPic {position: fixed;display: none;z-index: 99;top:0 ;left:0;width: 100%;height: 100%;background-color: rgba(0,0,0,.8);}\n");
		sb.append(".modelCon {position: absolute;top: 15%;left: 15%;right: 15%;width: 1400px;height: 1400px;}\n");
		sb.append(".modelCon img {width: 100%;height: auto;}\n");
		sb.append("</style>\n</head>\n");
		sb.append("<body bgcolor=snow>\n");
		// 添加JavaScript
		sb.append("<script type=\"text/javascript\">\n");
		sb.append(
				"function openModel(imgsrc){document.getElementById(\"MymodelPic\").style.display=\"block\";document.getElementById(\"failPic\").src = \"\";document.getElementById(\"failPic\").src = imgsrc;}\n");
		sb.append(
				"function closeModel(){document.getElementById(\"MymodelPic\").style.display=\"none\";document.getElementById(\"failPic\").src = \"\";}\n");
		sb.append("</script>\n");
		sb.append("<p class='heading'><h1>鲁班系统自动化测试Detail报告 </h1></p>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
		logger.info("Detail Report_" + DATE + ".html已生成");
	}

	/**
	 * 生成Detail测试报告头
	 * 
	 * @author wangHui
	 * @param date
	 * @param testName
	 * @param className
	 */
	public static void appendOnStart(String date, String testName, String className)
	{
		sb = new StringBuilder();
		sb.append("<div class='top' id='" + className
				+ "' style='font-size:16px;'><strong style='font-size:18px;'>FinalResult:</strong><font size=4 color=black><b>&nbsp;&nbsp;Status</b></font></div>\n");
		sb.append("<div style='font-size:16px;'><strong style='font-size:18px;'>StartTime:</strong>&nbsp;&nbsp;" + date
				+ "</div>\n");
		sb.append(
				"<div style='font-size:16px;'><strong style='font-size:18px;'>Duration&nbsp;&nbsp;:</strong>&nbsp;&nbsp;00:00:00</div>\n");
		sb.append("<div style='font-size:16px;'><strong style='font-size:18px;'>ClassName:</strong>&nbsp;&nbsp;"
				+ className + "</div>\n");
		sb.append(
				"<div style='font-size:16px;' class='bottom'><strong style='font-size:18px;'>ProcessName:</strong>&nbsp;&nbsp;"
						+ testName + "</div>\n");

		sb.append("<table border=1 width=1300 cellpadding=3 frame=border>\n<tbody>\n");
		sb.append("<tr align=center bgcolor=#46A3FF height=50>\n");
		sb.append("<th nowrap><font color=#272727 size=5 face=calibri>Step No.</font></th>\n");
		sb.append("<th nowrap><font color=#272727 size=5 face=calibri>Method Name</font></th>\n");
		sb.append("<th nowrap><font color=#272727 size=5 face=calibri>Expected Result</font></th>\n");
		sb.append("<th nowrap><font color=#272727 size=5 face=calibri>Actual Result</font></th>\n");
		sb.append("<th nowrap><font color=#272727 size=5 face=calibri>Test Result</font></th>\n</tr>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	/**
	 * Detail报告添加MethodName列
	 * 
	 * @author wangHui
	 * @param caseNo
	 * @param methodName
	 * @param description
	 */
	public static void appendOnTestStart(int caseNo, String methodName, String description)
	{
		sb = new StringBuilder();
		sb.append("<tr>\n<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>"
				+ String.valueOf(caseNo) + "</font></td>\n");
		sb.append("<td nowrap bgcolor=F0F0F0 align=left><font color=black size=3 face=微软雅黑>" + methodName + "：<br>"
				+ description + "</br></font></td>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	/**
	 * Detail报告添加Test Result列
	 * 
	 * @author wangHui
	 */
	public static void appendOnTestSuccess()
	{
		sb = new StringBuilder();
		sb.append(
				"<td nowrap bgcolor=F0F0F0 align=center><font color=#46A3FF size=4 face=calibri><b>Pass</b></font></td>\n</tr>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	/**
	 * 方法失败时添加Detail报告内容
	 * 
	 * @author wangHui
	 * @param throwable
	 * @param errorPicPath
	 */
	public static void appendOnTestFailure(Throwable throwable, String errorPicPath)
	{
		sb = new StringBuilder();
		String exceptionName = throwable.getClass().getSimpleName();
		String exceptionInfo = throwable.toString();
		if (exceptionName.equals("AssertionError"))
		{
			sb.append("<td nowrap bgcolor=F0F0F0 align=center onclick=\"openModel('" + errorPicPath
					+ "')\"><font color=red size=4 face=calibri><b>Fail</b></font></td>\n");
			sb.append("<div class=\"modelPic\" id=\"MymodelPic\">\n");
			sb.append("<div class=\"modelCon\" onclick=\"closeModel()\">\n");
			sb.append("<img id=\"failPic\" src=\"\"/>\n</div>\n</div>\n</tr>\n");
		} else if (exceptionName.equals("NoSuchElementException"))
		{
			String key = exceptionInfo.substring(exceptionInfo.indexOf("key\":") + 5, exceptionInfo.indexOf("}"));
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=red size=4 face=calibri>NULL</font></td>\n");
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=red size=3 face=微软雅黑>" + "元素" + key + "未找到"
					+ "</font></td>\n");
			sb.append("<td nowrap bgcolor=F0F0F0 align=center onclick=\"openModel('" + errorPicPath
					+ "')\"><font color=red size=4 face=calibri><b>Fail</b></font></td>\n");
			sb.append("<div class=\"modelPic\" id=\"MymodelPic\">\n");
			sb.append("<div class=\"modelCon\" onclick=\"closeModel()\">\n");
			sb.append("<img id=\"failPic\" src=\"\"/>\n</div>\n</div>\n</tr>\n");
		} else
		{
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=red size=4 face=calibri>NULL</font></td>\n");
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=red size=4 face=calibri>NULL</font></td>\n");
			sb.append("<td nowrap bgcolor=F0F0F0 align=center onclick=\"openModel('" + errorPicPath
					+ "')\"><font color=red size=4 face=calibri><b>Fail</b></font></td>\n");
			sb.append("<div class=\"modelPic\" id=\"MymodelPic\">\n");
			sb.append("<div class=\"modelCon\" onclick=\"closeModel()\">\n");
			sb.append("<img id=\"failPic\" src=\"\"/>\n</div>\n</div>\n</tr>\n");
		}
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	/**
	 * 方法跳过时添加Detail报告内容
	 * 
	 * @author wangHui
	 * @param caseNo
	 * @param methodName
	 * @param description
	 */
	public static void appendOnTestSkipped(int caseNo, String methodName, String description)
	{
		sb = new StringBuilder();
		sb.append("<tr>\n<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>"
				+ String.valueOf(caseNo) + "</font></td>\n");
		sb.append("<td nowrap bgcolor=F0F0F0 align=left><font color=black size=3 face=微软雅黑>" + methodName + "：<br>"
				+ description + "</br></font></td>\n");
		sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=9D9D9D size=4 face=calibri>NULL</font></td>\n");
		sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=9D9D9D size=4 face=calibri>NULL</font></td>\n");
		sb.append(
				"<td nowrap bgcolor=F0F0F0 align=center><font color=FF8000 size=4 face=calibri><b>Skip</b></font></td>\n</tr>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	public static void appandOnFinish(String className)
	{
		sb = new StringBuilder();
		sb.append("</tbody>\n</table>\n");
		sb.append("<div class='middle'><a href='Summary_Report_" + DATE + ".html#" + className
				+ "'>back to summary</a></div>\n");
		sb.append("\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	public static void appandOnSuiteFinish()
	{
		sb = new StringBuilder();
		sb.append("<br></br>\n<br></br>\n");
		sb.append("</body>\n</html>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	/**
	 * Detail报告添加断言信息
	 * 
	 * @author wangHui
	 * @param expectedResult
	 * @param actualResult
	 * @param face
	 *            字体
	 */
	public static void appendResult(String expectedResult, String actualResult, String face)
	{
		sb = new StringBuilder();
		if (face.equals("1"))
		{
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=3 face=微软雅黑>" + expectedResult
					+ "</font></td>\n");
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=3 face=微软雅黑>" + actualResult
					+ "</font></td>\n");
		} else if (face.equals("2"))
		{
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>" + expectedResult
					+ "</font></td>\n");
			sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>" + actualResult
					+ "</font></td>\n");
		} else
			throw new RuntimeException("face error,please choise for [1、2]");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	public static void appendResult(boolean expectedResult, boolean actualResult)
	{
		sb = new StringBuilder();
		sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>"
				+ String.valueOf(expectedResult) + "</font></td>\n");
		sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>"
				+ String.valueOf(actualResult) + "</font></td>\n");
		writeContentToHtml(DETAIL_REPORT_PATH);
	}

	/**
	 * 替换html报告内容
	 * 
	 * @author wangHui
	 * @param path
	 * @param replace
	 * @param target
	 */
	public static void modifyHtmlReport(String path, String replace, String target)
	{
		String encoding = "GBK";
		String html = "";
		String lineTxt = null;
		File file = new File(path);
		InputStreamReader read;
		try
		{
			read = new InputStreamReader(new FileInputStream(file), encoding);
			BufferedReader bufferedReader = new BufferedReader(read);
			while ((lineTxt = bufferedReader.readLine()) != null)
			{
				html = html + lineTxt + "\n";
			}
			read.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			String targetHtml = html.replace(replace, target);
			writer.write(targetHtml);
			writer.close();
		} catch (Exception e)
		{
			logger.info("html替换内容失败");
			e.printStackTrace();
		}
	}

	/**
	 * 初始化Summary测试报告内容
	 * 
	 * @author WangHui
	 * @param startTime
	 */

	public static void initializeSummaryReport(String startTime)
	{
		File file = new File(SUMMARY_REPORT_PATH);
		if (file.exists())
			file.delete();
		sb = new StringBuilder();
		sb.append("<html>\n<head><meta http-equiv=Content-Type content=text/html; charset=gbk>\n");
		sb.append("<title>鲁班系统自动化测试概要报告</title>\n</head>\n<body bgcolor=snow>\n");
		sb.append(
				"<script type='text/javascript' src='http://sandbox.runjs.cn/uploads/rs/146/73fi1rab/amcharts.js'></script>\n");
		sb.append("<style type='text/css' media='screen'>\n");
		sb.append("h1{font-size: 22pt;color: #5B5B5B;font-family: 楷体;}\n");
		sb.append(".heading {margin-bottom: 1ex;}\nbody {margin-left:1ex;}\n");
		sb.append(
				".top {margin-left:2ex;margin-top: 0ex;margin-bottom: 1ex;font-size: 17pt;color: #272727;font-family: Cambria;}\n");
		sb.append(".middle {margin-left:2ex;margin-bottom: 0.2ex;font-family: Cambria;color: #272727;}\n");
		sb.append(
				".chartdiv {margin-top: 2ex;margin-left:10ex; width: 50%; height: 350px }\ntable {margin-left:6ex;margin-bottom: 4ex;}\n</style>\n");
		sb.append("<script type='text/javascript'>\nvar chart;var legend;\n");
		sb.append(
				"var chartData = [{result: 'Passed',value: xx,color: '#46A3FF'},{result: 'Failed',value: yy,color: '#FF0000'},{result: 'Skipped',value: 0,color: '#FF9224'}];\n");
		sb.append(
				"AmCharts.ready(function() {chart = new AmCharts.AmPieChart();chart.dataProvider = chartData;chart.titleField = 'result';chart.valueField = 'value';chart.colorField = 'color';\n");
		sb.append(
				"chart.fontFamily = '微软雅黑';chart.outlineColor = '';chart.outlineAlpha = 0.8;chart.outlineThickness = 2;chart.depth3D = 20;chart.angle = 30;chart.write('chartdiv');});\n");
		sb.append("</script>\n<p class='heading'><h1>鲁班系统自动化测试Summary报告</h1></p>\n");
		sb.append(
				"<div class='middle' style='font-size:18px;'><strong>Start Time&nbsp;:</strong><span style='font-size:16px;'>&nbsp;&nbsp;"
						+ startTime + "</span></div>\n");
		writeContentToHtml(SUMMARY_REPORT_PATH);
		logger.info("Summary Report_" + DATE + ".html已生成");
	}

	/**
	 * 添加Summary测试报告内容
	 * 
	 * @author WangHui
	 * @param endTime
	 */
	public static void appendSummaryReport(String endTime)
	{
		int passAmount = 0;
		int failAmount = 0;
		int passStep = 1;
		int failStep = 1;
		String fileContent = TxtUtil.parseFile(DETAIL_REPORT_PATH);
		Pattern passPattern = Pattern.compile(
				"<div class='top' id='(.*?)'.*?FinalResult.*?Duration&nbsp;&nbsp;:</strong>&nbsp;&nbsp;(.*?)</div>.*?ProcessName:</strong>&nbsp;&nbsp;(.*?)</div>");
		Matcher passMatcher = passPattern.matcher(fileContent);
		while (passMatcher.find())
			passAmount++;
		passMatcher.reset();
		Pattern failPattern = Pattern.compile(
				"<div class='top1' id='(.*?)'.*?FinalResult.*?Duration&nbsp;&nbsp;:</strong>&nbsp;&nbsp;(.*?)</div>.*?ProcessName:</strong>&nbsp;&nbsp;(.*?)</div>");
		Matcher failMatcher = failPattern.matcher(fileContent);
		while (failMatcher.find())
			failAmount++;
		failMatcher.reset();
		int totalAmount = passAmount + failAmount;
		String passRate = StrUtil.formatToString((double) passAmount / totalAmount);
		String failRate = StrUtil.formatToString((double) failAmount / totalAmount);
		modifyHtmlReport(SUMMARY_REPORT_PATH, "'Passed',value: xx,color: '#46A3FF'},{result: 'Failed',value: yy",
				"'Passed',value: " + passRate + ",color: '#46A3FF'},{result: 'Failed',value: " + failRate);
		sb = new StringBuilder();
		sb.append(
				"<div class='middle' style='font-size:18px;'><strong>FinishTime:</strong><span style='font-size:16px;'>&nbsp;"
						+ endTime + "</span></div>\n");
		sb.append(
				"<div class='middle' style='font-size:18px;'><strong>Totals&nbsp;:</strong><b style='font-size:18px;color:#000000'>&nbsp;&nbsp;"
						+ totalAmount + "</b></font></div>\n");
		sb.append(
				"<div class='middle' style='font-size:18px;'><strong>Failed&nbsp;:</strong><b style='font-size:18px;color:red'>&nbsp;&nbsp;"
						+ failAmount + "</b></font></div>\n");
		sb.append(
				"<div class='middle' style='font-size:18px;'><strong>Passed&nbsp;:</strong><b style='font-size:18px;color:#46A3FF'>&nbsp;&nbsp;"
						+ passAmount + "</b></font></div>\n");
		sb.append(
				"<div class='middle' style='font-size:18px;'><strong>Skipped&nbsp;:</strong><b style='font-size:18px;color:orange'>&nbsp;&nbsp;0</b></font></div>\n");
		sb.append("<div id='chartdiv' class='chartdiv'></div>\n");
		if (failAmount > 0)
		{
			sb.append("<div class='top'><b>Failed Lists:</b></div>\n");
			sb.append("<table border=1 width=1000 cellpadding=3 frame=border>\n<tbody>\n");
			sb.append(
					"<tr align=center bgcolor=#46A3FF height=30>\n<th nowrap><font color=#272727 size=4 face=Cambria>Step No.</font></th>\n");
			sb.append("<th nowrap><font color=#272727 size=4 face=Cambria>ProcessName</font></th>\n");
			sb.append("<th nowrap><font color=#272727 size=4 face=Cambria>Duration</font></th>\n");
			sb.append("<th nowrap><font color=#272727 size=4 face=Cambria>LinkToDetail</font></th>\n</tr>\n");
			while (failMatcher.find())
			{
				sb.append("<tr>\n<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>"
						+ failStep + "</font></td>\n");
				sb.append("<td id='" + failMatcher.group(1)
						+ "' nowrap bgcolor=F0F0F0 align=left><font color=black size=3 face=微软雅黑>&emsp;"
						+ failMatcher.group(3) + "</font></td>\n");
				sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=3 face=微软雅黑>"
						+ failMatcher.group(2) + "</font></td>\n");
				sb.append("<td nowrap bgcolor=F0F0F0 align=center><a href='Detail_Report_" + DATE + ".html#"
						+ failMatcher.group(1) + "'><font color=red size=4 face=calibri>link</font></a></td>\n</tr>\n");
				failStep++;
			}
			sb.append("</table>\n</tbody>\n");
		}
		if (passAmount > 0)
		{
			sb.append("<div class='top'><b>Passed Lists:</b></div>\n");
			sb.append("<table border=1 width=1000 cellpadding=3 frame=border>\n<tbody>\n");
			sb.append(
					"<tr align=center bgcolor=#46A3FF height=30>\n<th nowrap><font color=#272727 size=4 face=Cambria>Step No.</font></th>\n");
			sb.append("<th nowrap><font color=#272727 size=4 face=Cambria>ProcessName</font></th>\n");
			sb.append("<th nowrap><font color=#272727 size=4 face=Cambria>Duration</font></th>\n");
			sb.append("<th nowrap><font color=#272727 size=4 face=Cambria>LinkToDetail</font></th>\n</tr>\n");
			while (passMatcher.find())
			{
				sb.append("<tr>\n<td nowrap bgcolor=F0F0F0 align=center><font color=black size=4 face=calibri>"
						+ passStep + "</font></td>\n");
				sb.append("<td id='" + passMatcher.group(1)
						+ "' nowrap bgcolor=F0F0F0 align=left><font color=black size=3 face=微软雅黑>&emsp;"
						+ passMatcher.group(3) + "</font></td>\n");
				sb.append("<td nowrap bgcolor=F0F0F0 align=center><font color=black size=3 face=微软雅黑>"
						+ passMatcher.group(2) + "</font></td>\n");
				sb.append("<td nowrap bgcolor=F0F0F0 align=center><a href='Detail_Report_" + DATE + ".html#"
						+ passMatcher.group(1)
						+ "'><font color=blue size=4 face=calibri>link</font></a></td>\n</tr>\n");
				passStep++;
			}
			sb.append("</table>\n</tbody>\n");
		}
		sb.append("<br></br>\n<br></br>\n");
		sb.append("</body>\n</html>\n");
		writeContentToHtml(SUMMARY_REPORT_PATH);
	}

	public static void main(String[] args) throws Exception
	{
		String endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		appendSummaryReport(endTime);
	}
}
