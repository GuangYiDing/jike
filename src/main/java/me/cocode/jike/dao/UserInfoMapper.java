package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.dto.UserPersonalDto;
import me.cocode.jike.entity.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserInfoMapper extends CommonMapper<UserInfo> {

    /**
     * 获取用户的档案信息
     */
    @Select("SELECT u.user_name userName,u.avatar userAvatar,u.signature signature,u.cover cover,ui.gender gender,ui.emotion emotion,ui.birthday birthday FROM users u INNER JOIN user_info ui ON u.id=#{userId} and ui.id = #{userId} ")
    @ResultType(UserPersonalDto.class)
    UserPersonalDto getUserPersonalInfo(@Param("userId") Integer userId);

    @Update(
            "UPDATE users " +
                    "INNER JOIN user_info " +
                    "ON users.id = user_info.id " +
                    "SET user_name=#{userName},avatar=#{userAvatar},signature=#{signature},cover=#{cover},birthday=#{birthday},gender=#{gender},emotion=#{emotion} " +
                    "WHERE users.id=#{userId}")
    int updateUserPersonal(@Param("userName") String userName,
                           @Param("userAvatar") String userAvatar,
                           @Param("signature") String signature,
                           @Param("cover") String cover,
                           @Param("birthday") String birthday,
                           @Param("gender") String gender,
                           @Param("emotion") String emotion,
                           @Param("userId") Integer userId);


    /**
     * 获取推荐用户时的卡片信息
     */
    @Select("SELECT u.id,u.user_name userName,u.avatar userAvatar,u.signature,ui.gender,ui.emotion,ui.birthday FROM users u,user_info ui WHERE u.id=ui.id")
    List<UserPersonalDto> getUserInfoCard();

    /**
     * 删除用户档案
     */
    @Delete("DELETE FROM  user_info WHERE user_info.id=#{userId} ")
    int deleteUsersInfo(@Param("userId") Integer userId);
}