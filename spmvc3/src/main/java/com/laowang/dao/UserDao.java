package com.laowang.dao;

import com.laowang.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

    public void save(User user){
        System.out.println("save");
    }
    public void delete(Integer id){
        System.out.println("delete");
    }
    public void update(Integer id){
        System.out.println("update");
    }
    public void query(){
        System.out.println("query");
    }
}
