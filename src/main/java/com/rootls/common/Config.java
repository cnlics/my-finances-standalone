package com.rootls.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

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
public class Config implements ServletContextListener {

    public static String properties_fileName = getConfigPath();


    public static Integer pageSize = 20;
    public static String data_daytips = "data/daytips.txt";
    public static String encoding="UTF-8";
    public static String date_pattern = "yyyy-MM-dd";
    public static String time_pattern = "yyyy-MM-dd HH:mm:dd";
    public static String note_url = "";

    private void setFields(Map<String, String> map) {
        Integer _pageSize = Integer.valueOf(map.get("pageSize"));
        pageSize = (_pageSize != null && _pageSize >= 0) ? _pageSize : pageSize;

        String _data_daytips = map.get("data_daytips");
        data_daytips = (_data_daytips != null && _data_daytips !="")?_data_daytips:data_daytips;

        String _encoding = map.get("encoding");
        encoding = (_encoding != null && _encoding !="")?_encoding:encoding;

        String _date_pattern = map.get("date_pattern");
        date_pattern = (_date_pattern != null && _date_pattern !="")?_date_pattern:date_pattern;

        String _time_pattern = map.get("time_pattern");
        time_pattern = (_time_pattern != null && _time_pattern !="")?_time_pattern:time_pattern;

        String _note_url = map.get("note_url");
        note_url = (_note_url != null && _note_url !="")?_note_url:note_url;
    }

    private static String getConfigPath() {
        String configFilePath = Config.class.getClassLoader().getResource("config.properties").getPath().substring(1);
        // 判断系统 linux，windows
        if ("\\".equals(File.separator)) {
            configFilePath = configFilePath.replace("%20", " ");
        } else if ("/".equals(File.separator)) {
            configFilePath = "/" + configFilePath.replace("%20", " ");
        }
        return configFilePath;
    }

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        Map<String, String> map = PropertiesUtil.getAllProperty();
        if (map == null || map.isEmpty()) {
            return;
        }
        setFields(map);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }

    /**
     * 读取properties配置文件.
     * User: luowei
     * Date: 13-2-5
     * Time: 下午2:39
     * To change this template use File | Settings | File Templates.
     */
    public abstract static class PropertiesUtil {

        static Logger logger = LoggerFactory.getLogger(PropertiesUtil.class);

        private static Properties props;
        private static String fileName = properties_fileName;

        private static void readProperties() {
            FileInputStream fis = null;
            try {
                if (props == null) {
                    props = new Properties();
                }
                fis = new FileInputStream(fileName);
                InputStreamReader is = new InputStreamReader(fis,"UTF-8");
                props.load(is);
            } catch (Exception e) {
                logger.error(e.getMessage(), e);
            } finally {
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        }

        /**
         * 获取某个属性
         */
        public static String getProperty(String key) {
            readProperties();
            return props.getProperty(key);
        }

        /**
         * 获取所有属性，返回一个map,不常用
         * 可以试试props.putAll(t)
         */
        public static Map<String, String> getAllProperty() {
            Map<String, String> map = new HashMap<String, String>();
            readProperties();
            Enumeration enu = props.propertyNames();
            while (enu.hasMoreElements()) {
                String key = (String) enu.nextElement();
                String value = props.getProperty(key);
                map.put(key, (value!=null?value.trim():"") );
            }
            return map;
        }

        /**
         * 在控制台上打印出所有属性，调试时用。
         */
        public static void printProperties() {
            props.list(System.out);
        }

        /**
         * 写入properties信息
         */
        public static Boolean writeProperties(String key, String value) {
            OutputStream fos = null;
            try {
                fos = new FileOutputStream(fileName);
                props.setProperty(key, value);
                // 将此 Properties 表中的属性列表（键和元素对）写入输出流
                props.store(fos, "『comments』Update key：" + key);
                return true;
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
                return false;
            } finally {
                if (fos != null) {
                    try {
                        fos.close();
                    } catch (IOException e) {
                        logger.error(e.getMessage(), e);
                    }
                }
            }
        }
        //    public static void main(String[] args) {
        //        PropertiesUtil util=new PropertiesUtil("config.properties");
        //        System.out.println("ip=" + util.getProperty("ip"));
        //        util.writeProperties("key", "value0");
        //    }
    }
}
