package com.rootls.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created with IntelliJ IDEA.
 * User: luowei
 * Date: 13-1-11
 * Time: 下午1:56
 * To change this template use File | Settings | File Templates.
 */
//@WebListener
@Component
public class Config implements Serializable,ServletContextListener {

    @Value("${config.pageSize}")
    private Integer _pageSize = 20;

    @Value("${config.data_daytips}")
    private String _data_daytips = "data/daytips.txt";

    @Value("${config.encoding}")
    private String _encoding="UTF-8";

    @Value("${config.date_pattern}")
    private String _date_pattern = "yyyy-MM-dd";

    @Value("${config.time_pattern}")
    private String _time_pattern = "yyyy-MM-dd HH:mm:dd";

    @Value("${config.note_url}")
    private String _note_url = "";

    //--------------------

    public static Integer pageSize = 20;
    public static String data_daytips = "data/daytips.txt";
    public static String encoding="UTF-8";
    public static String date_pattern = "yyyy-MM-dd";
    public static String time_pattern = "yyyy-MM-dd HH:mm:dd";
    public static String note_url = "";

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getData_daytips() {
        return data_daytips;
    }

    public void setData_daytips(String data_daytips) {
        this.data_daytips = data_daytips;
    }

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public String getDate_pattern() {
        return date_pattern;
    }

    public void setDate_pattern(String date_pattern) {
        this.date_pattern = date_pattern;
    }

    public String getTime_pattern() {
        return time_pattern;
    }

    public void setTime_pattern(String time_pattern) {
        this.time_pattern = time_pattern;
    }

    public String getNote_url() {
        return note_url;
    }

    public void setNote_url(String note_url) {
        this.note_url = note_url;
    }


    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        pageSize = _pageSize;
        data_daytips = _data_daytips;
        encoding = _encoding;
        date_pattern = _date_pattern;
        time_pattern = _time_pattern;
        note_url = _note_url;
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }


}
