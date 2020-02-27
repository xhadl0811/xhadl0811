package com.mycompany.myapp.VO;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Product {
	int id;
	@Size(min=2)
	@NotEmpty
	String name;//
	String author;
	String nickname;
	String price;
	String description;//
	String file1;
	String	file2;
	String file3;
	String time;	
	String category1;//
	String category2;//
	String category3;//
	Boolean isSelling;
	String buyer;
	
	public String getBuyer() {
		return buyer;
	}

	public void setBuyer(String buyer) {
		this.buyer = buyer;
	}

	public Boolean getIsSelling() {
		return isSelling;
	}

	public void setIsSelling(Boolean isSelling) {
		this.isSelling = isSelling;
	}

	int see;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}



	public String getFile1() {
		return file1;
	}

	public void setFile1(String file1) {
		this.file1 = file1;
	}

	public String getFile2() {
		return file2;
	}

	public void setFile2(String file2) {
		this.file2 = file2;
	}

	public String getFile3() {
		return file3;
	}

	public void setFile3(String file3) {
		this.file3 = file3;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public int getSee() {
		return see;
	}

	public void setSee(int see) {
		this.see = see;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", author=" + author + ", nickname=" + nickname + ", price="
				+ price + ", description=" + description + ", file1=" + file1 + ", file2=" + file2 + ", file3=" + file3
				+ ", time=" + time + ", category1=" + category1 + ", category2=" + category2 + ", category3="
				+ category3 + ", see=" + see + "]";
	}









}
