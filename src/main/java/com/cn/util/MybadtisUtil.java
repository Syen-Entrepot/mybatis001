package com.cn.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Syen
 * @date 2019/7/21 0021-下午 14:25
 */
public class MybadtisUtil {
    private  static SqlSessionFactory sqlSessionFactory;

    static {
        String resource="mybatis.cfg.xml";
        InputStream inputStream=null;
        try{
            inputStream = Resources.getResourceAsStream(resource);
            /*SqlSessionFactoryBuilder负责生成sqlSessionFactory的接口*/
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if(inputStream!=null){
                try{
                    inputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    /*SqlSession是一个既可以发送Sql去执行并返回结果，也可以获取Mapper接口*/
    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
