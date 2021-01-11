package com.zxf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.zxf.service.IBookService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class BookController {
    private static final String content = "Content-disposition";
    private static final String attachment = "attachment; filename=";
    private static final String code = "gb2312";
    private static final String codeNum = "ISO8859-1";
	//@Reference(check = false)
    @Autowired
    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping(value = "/getRpc", method = RequestMethod.GET)
    @ResponseBody
    public String getRpc(String name){
        System.out.println("name=" + name);
        return bookService.getBook(name);
    }

    @RequestMapping(value = "/downloadModel", method = RequestMethod.GET,  produces = "application/vnd.ms-excel")
    public byte[] downloadModel(HttpServletResponse response) throws IOException {
        byte[] arr = new byte[] {};
        String exportName = "再发防止检查表&供应商答复模板%s.xlsx";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        arr = bookService.downloadModel();
        response.setHeader(content, attachment + new String(String.format(exportName, sdf.format(date)).getBytes(code), codeNum));
        return arr;
    }

    @RequestMapping(value = "/recordRejectInf", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    public String recordRejectInf(@RequestBody String data) {
        int num = bookService.recordRejectInf(data);
	    return data;
    }

    @RequestMapping(value = "/readdExcelContext", method = RequestMethod.GET,  produces = "application/vnd.ms-excel")
    public byte[] readdExcelContext(HttpServletResponse response, String excelId) throws IOException {
        byte[] arr = new byte[] {};
        String exportName = "再发防止检查表&供应商答复模板%s.xlsx";
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        arr = bookService.downloadModel();
        response.setHeader(content, attachment + new String(String.format(exportName, sdf.format(date)).getBytes(code), codeNum));
        return arr;
    }

}