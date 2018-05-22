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
    private Users user;


    private SqlSession getSession(){
        sqlSession = SqlSessionFactoryUtils.getSqlSessionFactory().openSession();
        return sqlSession;
    }

    /**
     * 查询全部用户
     * @return
     */
    public List<Users>getAllUsers(){
        try {
            list  =  getSession().selectList("findUsers");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return list;
    }

    /**
     * 查询单个用户根据编号
     * @return
     */
    public Users getUserById(Integer id){

        try {
//         return getSession().selectOne("findUserById",id);
//         if或when标签是针对JAVABEAN或者MAP的
           user = getSession().selectOne("findUsers",new Users(id));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
        return user;
    }

    public void addUser(Users users){
        try {
            // 返回值：是insert执行过程中影响的行数
            getSession().insert("addUsers", users);
            sqlSession.commit();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            sqlSession.close();
        }
    }




}
