package com.cn;

import com.cn.mapper.AddressesMapper;
import com.cn.pojo.Addresses;
import com.cn.util.MybadtisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Syen
 * @date 2019/7/21 0021-下午 14:31
 */
public class Test1 {
@Test
    public void m1(){
    SqlSession sqlSession=MybadtisUtil.getSession();
    AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
    List<Addresses> addresses= mapper.queryByCountryCity("china","");
    System.out.println(addresses);

    sqlSession.close();
}
    @Test
    public void updata(){
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        Addresses addresses=new Addresses();
        addresses.setAddrId(2);
        addresses.setCity("杭州");
        addresses.setCountry("中国");
        addresses.setState("浙江省");
        addresses.setStreet("朝阳街");
        /*addresses.setZip("450821");*/
        mapper.updata(addresses);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void check(){
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        Addresses addresses=new Addresses();

        addresses.setCountry("");
        addresses.setState("fd");

        List<Addresses> query=mapper.query(addresses);

       System.out.println(query);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void Trim(){
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        Addresses addresses=new Addresses();

        addresses.setCountry("");
        addresses.setState("fd");

        List<Addresses> queryTrim=mapper.queryTrim(addresses);

        System.out.println(queryTrim);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void fore(){
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        List<Integer> t=new ArrayList<>();
        t.add(1);
        t.add(2);
        t.add(3);
        List<Addresses> y=mapper.queryFor(t);
        System.out.println(y);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void lik(){
        /*模糊查询解决方案一：在应用程序层面加入%%拼接*/
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);

        List<Addresses> y=mapper.querylik("%s%");

        System.out.println(y);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void lik2(){
        /*模糊查询解决方案二：通过mysql的函数完成concat也可以*/
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);

        List<Addresses> y=mapper.querylik("s");

        System.out.println(y);
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void lik3(){
        /*模糊查询解决方案二：通过bind标签，对我们的变量进行绑定，
        然后通过新绑定的变量绑定变量进行引用*/
        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);

        List<Addresses> y=mapper.querylik("s");

        System.out.println(y);
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void sql_listAll(){

        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);

        List<Addresses> y=mapper.listAll();
        System.out.println(y);

        /*
        一级缓存是会话级别的，言下之意就是要在同一个会话当中才有效
        *如果开启了二级缓存，
        * 先去二级缓存中尝试命中
        * 如果也无法命中
        * 尝试去一级缓存当中命中
        * 还不命中就去数据库查询
        *
        * */


        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void cache1(){

        SqlSession sqlSession=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);

        List<Addresses> y=mapper.listAll();
        System.out.println(y);
       /*
       *缓存失效一:如果查询之后进行了增删改的行为，将导致缓存失效
       *缓存失效二:sqlSession.clearCache();强制清空缓存,清空所有
       *缓存失效三:
       *
       * */


        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void cache2(){
        /*
         *二级缓存实验
         * */
        SqlSession sqlSession=MybadtisUtil.getSession();
        SqlSession sqlSession2=MybadtisUtil.getSession();

        AddressesMapper mapper=sqlSession.getMapper(AddressesMapper.class);
        AddressesMapper mapper2=sqlSession.getMapper(AddressesMapper.class);

        mapper.listAll();
        //sqlSession.close();
        mapper2.listAll();
        sqlSession2.close();

    }
}
