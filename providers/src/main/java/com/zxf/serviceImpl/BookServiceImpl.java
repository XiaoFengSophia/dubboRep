package com.zxf.serviceImpl;

import com.alibaba.dubbo.common.logger.Logger;
import com.alibaba.dubbo.common.logger.LoggerFactory;
import com.zxf.service.IBookService;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.*;

//@Service
@Service("bookService")
public class BookServiceImpl implements IBookService {
	private static Logger log = LoggerFactory.getLogger(BookServiceImpl.class);

	public static final String XLS = "XLS";
	public static final String XLSx = "XLSX";

	@Value("${server.port}")
	private String providePort;

	@Override
	public String getBook(String name) {
		// TODO Auto-generated method stub
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("<<<<<<<<<<<<<<<<<接受到的name为" + name);
		return "接受到的参数name=" + name + "------端口号：" + providePort;
	}

	@Override
	public byte[] downloadModel() throws IOException {
		// 获取模板路劲
		Workbook workbook = null;
		FileInputStream inputStream = null;
		ByteArrayOutputStream out = null;
		String modelName = "supplierTemplate.XLSX";
		ClassPathResource resource = new ClassPathResource("excelModels/supplierTemplate.XLSX");
		File targetFile = new File(modelName);
		try {
			InputStream is = resource.getInputStream();
			FileUtils.copyInputStreamToFile(is, targetFile);
			String excelName= targetFile.getName();
			log.info("<<<<<<<<<<<<<<<<<<<<<<excelName:" + excelName);
			// 获取Excel后缀名
			String fileType = excelName.substring(excelName.lastIndexOf(".") + 1, excelName.length());
			log.info("<<<<<<<<<<<<<<<<<<<<<<fileType:" + fileType);
			// 获取Excel工作簿
			inputStream = new FileInputStream(targetFile);
			if (fileType.equalsIgnoreCase(BookServiceImpl.XLS)) {
				workbook = new HSSFWorkbook(inputStream);
			} else if (fileType.equalsIgnoreCase(BookServiceImpl.XLSx)) {
				workbook = new XSSFWorkbook(inputStream);
			}
			out = new ByteArrayOutputStream();
			workbook.write(out);
			return out.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(targetFile.exists()){
				FileUtils.deleteQuietly(targetFile);
				log.info(">>>>>>>>>>>>>>>>>>删除临时文件成功<<<<<<<<<<<<<<<<<<<<");
			}
			if(workbook != null){
				workbook.close();
			}
			if(out != null){
				out.close();
			}
		}
	}

	@Override
	public int recordRejectInf(String data) {
		JSONObject jsonObject = JSONObject.fromObject(data);
		String[] applicationTcsIds = jsonObject.getString("applicationTcsIds").split(",");
		String temp = "";
		for (String applicationTcsId : applicationTcsIds) {
			if(temp == "") {
				temp = "'" + applicationTcsId + "'";
			}
			temp = temp + "," + "'" + applicationTcsId +"'";
		}
		String rejectReson = jsonObject.getString("reivewDesc");
		return applicationTcsIds.length;
	}

	@Override
	public byte[]  readdExcelContext(String excelId) throws IOException {
		// 获取模板路劲
		Workbook workbook = null;
		FileInputStream inputStream = null;
		ByteArrayOutputStream out = null;
		String modelName = "supplierTemplate.XLSX";
		ClassPathResource resource = new ClassPathResource("excelModels/supplierTemplate.xlsx");
		File targetFile = new File(modelName);
		try {
			InputStream is = resource.getInputStream();
			FileUtils.copyInputStreamToFile(is, targetFile);
			String excelName= targetFile.getName();
			log.info("<<<<<<<<<<<<<<<<<<<<<<excelName:" + excelName);
			// 获取Excel后缀名
			String fileType = excelName.substring(excelName.lastIndexOf(".") + 1, excelName.length());
			log.info("<<<<<<<<<<<<<<<<<<<<<<fileType:" + fileType);
			// 获取Excel工作簿
			inputStream = new FileInputStream(targetFile);
			if (fileType.equalsIgnoreCase(BookServiceImpl.XLS)) {
				workbook = new HSSFWorkbook(inputStream);
			} else if (fileType.equalsIgnoreCase(BookServiceImpl.XLSx)) {
				workbook = new XSSFWorkbook(inputStream);
			}
			// 讀取excel內容
			Sheet sheet = workbook.getSheetAt(0);
			// 行數
			int rows = sheet.getPhysicalNumberOfRows();
			for (int i = 0; i < rows; i++) {
				Row row = sheet.getRow(i);
				int cells = row.getPhysicalNumberOfCells();
				for (int j = 0; j < cells; j++) {
					if(row.getCell(j) != null && row.getCell(j).getCellType() != Cell.CELL_TYPE_BLANK){
						String cellValue = row.getCell(j).getStringCellValue();
						System.out.println("rowIndex = " + i + "-----" + "cellIndex = " + j + "--------->>" +cellValue);
					}
				}
			}
			out = new ByteArrayOutputStream();
			workbook.write(out);
			return out.toByteArray();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} finally {
			if(targetFile.exists()){
				FileUtils.deleteQuietly(targetFile);
				log.info(">>>>>>>>>>>>>>>>>>删除临时文件成功<<<<<<<<<<<<<<<<<<<<");
			}
			if(workbook != null){
				workbook.close();
			}
			if(out != null){
				out.close();
			}
		}
	}

}
