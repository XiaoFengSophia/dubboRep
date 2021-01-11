package com.zxf.service;

import java.io.IOException;
import java.util.List;

public interface IBookService {
	String getBook(String name);

    byte[] downloadModel() throws IOException;

    int recordRejectInf(String data);

    byte[] readdExcelContext(String excelId) throws IOException;

}
