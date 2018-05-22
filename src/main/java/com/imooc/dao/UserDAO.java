package com.imooc.dao;

import com.imooc.entity.Users;
import com.imooc.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * @author dukunpeng
 * @date 2018/5/18 15:48
 */
public class UserDAO {
    private List<Users> list;
    private SqlSession sqlSession;
    private SqlSession getSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    /**
     * 查询全部用户
     * @return
     */
    public List<Users>getAllUsers(){
        list  =  getSession().selectList("findUsers");
        return list;
    }

    /**
     * 查询单个用户根据编号
     * @return
     */
    public Users getUserById(Integer id){
//        return getSession().selectOne("findUserById",id);
//       if或when标签是针对JAVABEAN或者MAP的
        return getSession().selectOne("findUsers",new Users(id));

    }

}
