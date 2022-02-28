package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.entity.Follow;
import me.cocode.jike.entity.Users;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface FollowMapper extends CommonMapper<Follow> {

    /**
     * 增加用户关注数
     */
    @Update("UPDATE users " +
            "SET users.following=( " +
            "SELECT following FROM ( " +
            "SELECT users.following FROM users WHERE users.id=#{userId}) AS t)+1 WHERE users.id=#{userId}")
    int increaseUserFollowing(@Param("userId") Integer userId);

    /**
     * 增加用户的被关注数
     */
    @Update("UPDATE users " +
            "SET users.followed=(SELECT followed FROM ( " +
            "SELECT users.followed FROM users WHERE users.id=#{beFollowedUserId}) AS t)+1 WHERE users.id=#{beFollowedUserId}")
    int increaseUserFollowed(@Param("beFollowedUserId") Integer beFollowedUserId);


    /**
     * 减少用户关注数
     */
    @Update("UPDATE users " +
            "SET users.following=( " +
            "SELECT following FROM ( " +
            "SELECT users.following FROM users WHERE users.id=#{userId}) AS t)-1 WHERE users.id=#{userId}")
    int decreaseUserFollowing(@Param("userId") Integer userId);


    /**
     * 减少用户的粉丝数
     */
    @Update("UPDATE users " +
            "SET users.followed=(SELECT followed FROM ( " +
            "SELECT users.followed FROM users WHERE users.id=#{beFollowedUserId}) AS t)-1 WHERE users.id=#{beFollowedUserId}")
    int decreaseUserFollowed(@Param("beFollowedUserId") Integer beFollowedUserId);


    /**
     * 获取某个用户的关注列表
     */
    @Select("SELECT u.id,u.user_name userName,u.signature,u.avatar  FROM users u WHERE u.id IN ( " +
            "SELECT f.following_user_id FROM follow f WHERE f.user_id=#{userId})")
    List<Users> getUserFollowing(@Param("userId") Integer userId);


    /**
     * 获取某个用户的被关注列表
     */
    @Select("SELECT u.id,u.user_name userName,u.signature,u.avatar  FROM users u WHERE u.id IN ( " +
            "SELECT f.user_id FROM follow f WHERE f.following_user_id=#{userId})")
    List<Users> getUserFollowed(@Param("userId") Integer userId);


    /**
     * 删除用户所有的关注
     */
    @Delete("DELETE FROM  follow WHERE follow.user_id= #{userId}")
    int deleteUsersFollow(@Param("userId") Integer userId);

    /**
     * 删除用户粉丝中的用户
     */
    @Delete("DELETE FROM  follow WHERE follow.following_user_id= #{userId}")
    int deleteUsersFollowing(@Param("userId") Integer userId);


}