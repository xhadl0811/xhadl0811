package com.mycompany.myapp.Mappers;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.mycompany.myapp.VO.Product;
import com.mycompany.myapp.VO.User;

public interface pagingMapper {
	@Select("select count(*) from shop")
	public int getAllproduct();
	
	@Select("select * from shop order by id desc limit #{a} , 10")
	public List<Product> getProduct(int a);
	
	@Select("select * from user order by id desc limit #{a} , 10")
	public List<User> getUser(int a);
}
