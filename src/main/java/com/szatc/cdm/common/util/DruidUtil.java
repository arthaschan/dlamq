package com.szatc.cdm.common.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.log4j.Logger;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidUtil {
	
	private static DataSource dataSource;
	
    private static Logger logger = Logger.getLogger(DruidUtil.class);
    
    static {
        try{
        	InputStream in = DruidUtil.class.getClassLoader().getResourceAsStream("druid-config.properties");
            Properties props = new Properties();
            props.load(in);
			dataSource =  DruidDataSourceFactory.createDataSource(props);
        }catch (Exception e){
        	logger.error("数据库连接池创建失败",e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
    
    public static Connection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
        	logger.error("获取数据库连接失败",e);
            throw new RuntimeException("获取数据库连接失败",e);
        }
    }
    
    public static void execute(String sql)
    {
    	Connection conn = getConnection();
    	Statement stmt = null;
    	try {
    		stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			logger.error("执行SQL失败:" + sql,e);
			throw new RuntimeException("执行SQL失败",e);
		} finally {
			release(conn, stmt);
		}
    	
    }
    
    public static <T> List<T> query(String sql, Class<T> clazz)
    {
    	List<T> list = new ArrayList<T>();
    	Connection conn = getConnection();
    	Statement stmt = null;
    	ResultSet rs = null;
    	try {
    		stmt = conn.createStatement();
    		 rs = stmt.executeQuery(sql);
             //填充模型
             while (rs.next()){
                 T t = BeanUtil.getBeanFromResultSet(clazz, rs);
                 list.add(t);
             }
		} catch (SQLException e) {
			logger.error("执行SQL失败:" + sql,e);
			throw new RuntimeException("执行SQL失败",e);
		} finally {
			release(conn, stmt, rs);
		}
    	return list;
    }
    
    public static void release(Connection conn, Statement stmt, ResultSet rs)
    {
    	try {
    		if (rs != null)
	    	{
    			rs.close();
	    	}
	    	if (stmt != null)
	    	{
				stmt.close();
	    	}
	    	if (conn != null)
	    	{
	    		conn.close();
	    	}
    	} catch (SQLException e) {
    		e.printStackTrace();
    		logger.error("release:" + e.getLocalizedMessage());
    	}
    }
    
    
    public static void release(Connection conn, Statement stmt)
    {
    	try {
	    	if (stmt != null)
	    	{
				stmt.close();
	    	}
	    	if (conn != null)
	    	{
	    		conn.close();
	    	}
    	} catch (SQLException e) {
    		e.printStackTrace();
    		logger.error("release:" + e.getLocalizedMessage());
    	}
    }
    
}
