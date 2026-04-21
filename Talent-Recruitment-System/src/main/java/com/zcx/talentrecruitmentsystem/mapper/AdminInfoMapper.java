package com.zcx.talentrecruitmentsystem.mapper;
/*
    管理员基本信息mapper接口，主要声明基本的CRUD方法和
    查询所有会员申请记录
    修改个人和企业用户的会员申请状态
    修改个人和企业用户的isVip属性
 */
import com.zcx.talentrecruitmentsystem.entity.AdminInfo;
import com.zcx.talentrecruitmentsystem.entity.MemberApply;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminInfoMapper{
    //新增，删除，修改方法的返回值都是int，这是执行该方法后影响的行数
    //如果返回1 证明执行成功，若返回0证明执行失败
    //所以不用void做返回值
    //而查询是为了要拿到数据，所以返回对应的实体类对象、List集合、Map集合

    //新增管理员
    int insertAdmin(AdminInfo adminInfo);

    //根据Id删除管理员
    int deleteAdminById(Long id);

    //修改管理员信息
    int updateAdmin(AdminInfo adminInfo);

    //根据Id查询管理员
    AdminInfo selectAdminById(Long id);

    //查询全部管理员
    List<AdminInfo> selectAllAdmins();

    //管理员查询所有申请记录
    List<MemberApply> selectAllApplies();

    //管理员审核会员申请透过/拒绝,即修改status,0表示初始申请，1表示通过，2表示拒绝
    int updateApplyStatus(
            @Param("id") Long id,
            @Param("status") Integer status
    );

    //根据企业账号，因为会员申请表存储的是账号，设置企业或个人是否是vip，isVip为0表示非会员，为1表示会员
    int updateEnterpriseVipStatus(
            @Param("account") String account,
            @Param("isVip") Integer isVip
    );
    int updateUserVipStatus(
            @Param("account") String account,
            @Param("isVip") Integer isVip
    );

    //登录操作，即查账号
    AdminInfo selectByAccount(String account);

}
