package com.zcx.talentrecruitmentsystem.service.impl;
/*
    用个人用户基本信息Service实现类
 */

import com.zcx.talentrecruitmentsystem.entity.UserInfo;
import com.zcx.talentrecruitmentsystem.mapper.UserInfoMapper;
import com.zcx.talentrecruitmentsystem.service.UserInfoService;
import jakarta.annotation.Resource;
import org.apache.catalina.User;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Service  //告诉Spring：这个类是业务层，会自动创建这个类的对象，放在Spring容器里，想用就用
public class UserInfoServiceImpl implements UserInfoService {

    @Resource   //告诉Spring 把下面的接口拿过来用，因为mapper注解使得MyBatis自动生成了实现类，Spring把它放进了容器，这个注解直接从容器内拿出来用
    private UserInfoMapper userInfoMapper;

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    // 缓存 Key 前缀（统一管理）
    private static final String USER_KEY = "user:";
    private static final String USER_LIST_KEY = "user:list";
    private static final String USER_ACCOUNT_KEY = "user:account:";


    @Override   //重写接口
    public int addUser(UserInfo userInfo){
        //新增用户，清空列表缓存
        int rows = userInfoMapper.insertUser(userInfo);
        if (rows > 0) {
            redisTemplate.delete(USER_LIST_KEY);
        }
        return rows;   //直接return就行是因为当前没有业务逻辑直接就是数据库操作
    }

    @Override
    public int deleteUser(Long id){
        //删除用户 删除缓存，因为登录时还存了account数据，但是这个方法没传入整体的对象
        //所以需要先查一遍，拿到用户信息，再把三个缓存都删了
        UserInfo user = userInfoMapper.selectUserById(id);

        int rows = userInfoMapper.deleteUserById(id);
        if (rows > 0 && user != null) {
            redisTemplate.delete(USER_KEY + id);
            redisTemplate.delete(USER_LIST_KEY);
            redisTemplate.delete(USER_ACCOUNT_KEY + user.getAccount());
        }
        return rows;
    }

    @Override
    public int updateUser(UserInfo userInfo){
        //修改用户时，删除该用户原先存储在Redis中的信息
        int rows = userInfoMapper.updateUser(userInfo);
        if(rows>0){
            //删除该用户的缓存
            String key = USER_KEY + userInfo.getId();
            redisTemplate.delete(key);

            //删除账号缓存
            redisTemplate.delete(USER_ACCOUNT_KEY + userInfo.getAccount());

            //删除用户列表缓存
            redisTemplate.delete(USER_LIST_KEY);
        }
        return rows;
    }

    @Override
    public UserInfo getUserById(Long id){
        //拼接Redis Key
        String key = USER_KEY + id;

        //先查缓存
        UserInfo user = (UserInfo) redisTemplate.opsForValue().get(key);
        if(user != null){
            return user;  //命中缓存，直接返回
        }

        //缓存未命中，查数据库
        user = userInfoMapper.selectUserById(id);

        //查到了就存入Redis(10分钟过期)
        if(user != null){
            redisTemplate.opsForValue().set(key,user,600, TimeUnit.SECONDS);
        }
        return user;
    }

    @Override
    public List<UserInfo> getAllUsers(){
        String key = USER_LIST_KEY;

        //查缓存
        List<UserInfo> list = (List<UserInfo>) redisTemplate.opsForValue().get(key);
        if(list != null){
            return list;
        }

        //查数据库
        list = userInfoMapper.selectAllUsers();

        if(list != null && !list.isEmpty()){
            redisTemplate.opsForValue().set(key, list, 300, TimeUnit.SECONDS);
        }
        return list;
    }

    //个人用户登录方法，即查账号
    @Override
    public UserInfo getByAccount(String account, String password){
        String key = USER_ACCOUNT_KEY + account;

        // 查缓存
        UserInfo user = (UserInfo) redisTemplate.opsForValue().get(key);

        if(user != null){
            //缓存里有，直接校验密码
            if(user.getPassword().equals(password)){
                return user;
            }
            return null;
        }

        //缓存没有，查数据库

        user = userInfoMapper.selectByAccount(account);
        if (user == null) {
            return null;
        }
        // 密码不正确
        if (!user.getPassword().equals(password)) {
            return null;
        }

        // 登录成功，放入缓存（10分钟）
        redisTemplate.opsForValue().set(key, user, 600, TimeUnit.SECONDS);

        return user;
    }

}
