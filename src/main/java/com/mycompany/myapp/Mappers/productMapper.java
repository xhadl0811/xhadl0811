package com.mycompany.myapp.Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.mycompany.myapp.VO.Product;
public interface productMapper {
	@Insert("insert into shop (name,price,author,nickname,description,file1,file2,file3,category1,category2,category3,time)"
			+ "values(#{name},#{price},#{author},#{nickname},#{description},#{file1},#{file2},#{file3},"
			+ "#{category1},#{category2},#{category3},#{time})")
	public boolean addProduct(Product product);
	
	@Select("select * from shop order by id desc")
	public List<Product> getList();
	
	@Select("select * from shop where id=#{id} ")
	public Product getListById(int id);
	
	@Update("update shop set see=see+1 where id=#{id}")
	public boolean addSee(int id);
	
	@Update("update shop set name=#{name} , price=#{price} , description=#{description} ,"
			+ "file1=#{file1} ,file2=#{file2},file3=#{file3}, category1=#{category1} , category2=#{category2} , category3=#{category3}"
			+ " where id = #{id}")
	public boolean editProduct(Product product);

	
	@Delete("delete from shop where id=#{id}")
	public boolean deleteProduct(int id);
	
	@Select("select author from shop where id=#{id}")
	public String getEmail(int id);
	
	@Select("select id from shop where author=#{author} order by id desc limit 1")
	public int getId(String author);
	
	@Update("update shop set isSelling = false , buyer = #{buyer} where id=#{id}")
	public boolean successPay(@Param("id")int id,@Param("buyer")String buyer);
	
	@Select("select isSelling from shop where id = #{id}")
	public boolean isSelling(int id);
	
	@Select("select author from shop where id = #{id}")
	public String getAuthor(int id);

	
}
