package top.lixiang007;

import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import top.lixiang007.po.Customer;
import top.lixiang007.po.Orders;
import top.lixiang007.utils.MybatisUtils;

public class MybatisTest {
    //一对一关系 根据用户id查看会员卡号
   @Test
    public void test1(){
       System.out.println("嵌套结果方式");
       SqlSession sqlSession=MybatisUtils.getSession();
       Customer customer=sqlSession.selectOne("top.lixiang007.mapper.CustomerMapper.findPersonById2",1);
       System.out.println(customer);
       System.out.println(customer.getCard());
       sqlSession.close();
    }
    @Test
    public void test2(){
        System.out.println("嵌套查询方式");
        SqlSession sqlSession=MybatisUtils.getSession();
        Customer customer=sqlSession.selectOne("top.lixiang007.mapper.CustomerMapper.findPersonById1",1);
        System.out.println(customer);
        System.out.println(customer.getCard());
        sqlSession.close();
    }
    @Test
    public void test3(){
        System.out.println("1:n,嵌套结果方式");
        SqlSession sqlSession=MybatisUtils.getSession();
        Customer customer=sqlSession.selectOne("top.lixiang007.mapper.CustomerMapper.findUserWithOrders",1);
        System.out.println(customer.toString());
        sqlSession.close();
    }
    @Test
    public void test4(){
        System.out.println("1:n,嵌套查询方式");
        SqlSession sqlSession=MybatisUtils.getSession();
        Customer customer=sqlSession.selectOne("top.lixiang007.mapper.CustomerMapper.findUserWithOrders2",1);
        System.out.println(customer);
        System.out.println(customer.getOrdersList().toString());
        sqlSession.close();
    }
    @Test
    public void test5(){
        System.out.println("n:n,嵌套结果方式");
        SqlSession sqlSession=MybatisUtils.getSession();
        Orders orders =sqlSession.selectOne("top.lixiang007.mapper.OrdersMapper.findOrdersWithPorduct2",1);
        System.out.println(orders);
        System.out.println(orders.getProductList().toString());
        sqlSession.close();
    }
    @Test
    public void test6(){
        System.out.println("n:n,嵌套查询方式");
        SqlSession sqlSession=MybatisUtils.getSession();
        Orders orders =sqlSession.selectOne("top.lixiang007.mapper.OrdersMapper.findOrdersWithPorduct",1);
        System.out.println(orders);
        System.out.println(orders.getProductList().toString());
        sqlSession.close();
    }

}
