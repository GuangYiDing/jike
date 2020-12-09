package me.cocode.jike.dao;

import me.cocode.jike.common.service.CommonMapper;
import me.cocode.jike.entity.Follow;
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
     * 减少用户的被关注数
     */
    @Update("UPDATE users " +
            "SET users.followed=(SELECT followed FROM ( " +
            "SELECT users.followed FROM users WHERE users.id=#{beFollowedUserId}) AS t)-1 WHERE users.id=#{beFollowedUserId}")
    int decreaseUserFollowed(@Param("beFollowedUserId") Integer beFollowedUserId);

    /**
     * 获取已经关注的用户
     */
    @Select("SELECT users.id,users.user_name FROM users WHERE users.id IN ( " +
            "SELECT following_user_id FROM follow WHERE follow.user_id=#{userId})")
    List<Integer> getFollowingUserIds(@Param("userId") Integer userId);

}