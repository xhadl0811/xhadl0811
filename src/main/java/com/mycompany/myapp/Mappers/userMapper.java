package com.mycompany.myapp.Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mycompany.myapp.VO.Chat;
import com.mycompany.myapp.VO.User;

public interface userMapper {
	@Insert("insert into user(email,password,nickname,enabled) values(#{email},#{password},#{nickname},true)")
	public boolean insertUser(User user); 
		
	@Insert("insert into shop_authorities(email,authority) values(#{email},#{authority})")
	public boolean insertAuthorities(@Param("email") String email, @Param("authority") String authority);
	
	@Select("select nickname from user where email=#{email}")
	public String getNickname(String email);
	
	@Update("update user set fail_count = fail_count + 1 where email = #{email}")
	public boolean addFailCount(String email);
	
	@Select("select * from user")
	public List<User> getUserList();

	@Delete("delete from user where id=#{id}")
	public boolean deleteUser(int id);
	
	@Delete("delete from shop_authorities where email=#{email}")
	public boolean deleteAuthorities(String email);
	
	@Update("update user set enabled = #{enabled} where id=#{id}")
	public boolean changeEnabled(@Param("enabled")Boolean enabled,@Param("id")int id);
	
	@Select("select * from user where email=#{email}")
	public User getUser(String email);
	
	@Select("select password from user where email = #{email}")
	public String getPassword(String email);
	
	@Update("update user set email = #{newEmail} where email = #{email}")
	public boolean updateEmail(@Param("newEmail")String newEmail,@Param("email")String email );
	
	@Update("update shop_authorities set email = #{newEmail} where email = #{email}")
	public boolean updateEmailAUTHORITIES(@Param("newEmail")String newEmail,@Param("email")String email );
	
	@Update("update user set password = #{password} where email = #{email}")
	public boolean updatePassword(@Param("password")String pw,@Param("email") String email);
	
	@Update("update user set nickname = #{nickname} where email = #{email}")
	public boolean updateNickname(@Param("nickname")String nickname , @Param("email") String email);
	
	@Delete("delete from user where email = #{email}")
	public boolean deleteUserByEmail(String email);

	@Select("select * from chat where (user1 = #{user1} and user2 = #{user2}) or (user1=#{user2} and user2=#{user1})")
	public List<Chat> getChat(@Param("user1")String user1,@Param("user2") String user2);

	@Insert("insert into chat (message,time,user1,user2) values(#{message},#{time},#{user1},#{user2})")
	public boolean setChat(@Param("message") String message,@Param("time")String time ,@Param("user1")String user1,@Param("user2")String user2);
	
	@Select("select target from chat_room where pri=#{pri}")
	public List<String> getRoom(String pri);
	
	@Insert("insert into chat_room (pri,target) values(#{pri},#{target})")
	public boolean setRoom(@Param("pri") String pri,@Param("target") String target);
	
	@Select("select email from user where email=#{email}")
	public String getEmail(String email);
}
