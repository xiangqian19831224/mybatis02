package cn.java.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.java.entity.Computer;

public class ComputerDaoImpl {
    private static SqlSession session = null;

    @Before
    public void init() {
        try {
            // 1、得到SqlSession
            SqlSessionFactoryBuilder sfb = new SqlSessionFactoryBuilder();
            InputStream ins = Resources.getResourceAsStream("mybatis.xml");
            SqlSessionFactory ssf = sfb.build(ins);
            session = ssf.openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // 查询所有电脑信息(不带条件查询)
    @Test
    public void selectAll() throws Exception {
        // 2、调用SqlSession这个类中的selectList方法
        List<Computer> lists = session.selectList("cn.java.dao.impl.ComputerDaoImpl.selectAll");
        System.out.println(lists);
    }

    // 通过id查询
    @Test
    public void selectById() {
        Computer com = session.selectOne("cn.java.dao.impl.ComputerDaoImpl.selectById", 2L);
        System.out.println(com);
    }

    // 通过多个条件查询
    @Test
    public void selectByConditions() {
        Map<String, Object> paramter = new HashMap<String, Object>();
        paramter.put("a", "联想");
        paramter.put("memory_size", 4F);
        List<Computer> lists = session.selectList("cn.java.dao.impl.ComputerDaoImpl.selectByConditions", paramter);
        System.out.println(lists);
    }

    // --------------------------------------------------------------------------------------
    // 添加数据
    @Test
    public void addComputer() {
        // 1、将多个参数封装到map集合中去
        Map<String, Object> parameter = new HashMap<String, Object>();
        parameter.put("brand", "戴尔");
        parameter.put("computer_name", "dell");
        parameter.put("price", 8000F);
        // 2、调用SqlSession中相关方法
        int flag = session.insert("cn.java.dao.impl.ComputerDaoImpl.addComputer", parameter);
        // 3、提交事务
        session.commit();
        if (flag >= 1) {
            System.out.println("数据添加成功");
        } else {
            System.out.println("数据添加失败，请重新添加");
        }

    }
}
