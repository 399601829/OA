package cn.yj.user.mapper;

import cn.yj.common.BaseMapper;
import cn.yj.user.entity.po.User;
import org.apache.ibatis.annotations.Select;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 永健
 * @since 2020-04-04 03:15
 */
public interface UserMapper extends BaseMapper<User>
{

    /**
     *
     * @param loginName
     * @return
     */
    User login(String loginName);

    @Select("select * from tb_user where id=#{id}")
    @Override
    User selectById(Serializable id);

    @Select("select * from tb_user where token=#{token}")
    User selectByToken(String token);


    @Select("select id,name,login_name,password,token,status from tb_user where login_name=#{loginName}")
    User selectByLoginName(String loginName);


    @Select("select id,name as userName from tb_user")
    List<Map<String, String>> listIdName();
}
