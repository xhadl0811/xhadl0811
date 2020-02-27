package com.mycompany.myapp.Helper;

public class pageHelper {

	int startPage;
	int endPage;
	int allPage;
	int allProduct;
	int nowPage;
	
	public pageHelper(int allProduct,int nowPage) {	
		this.allProduct = allProduct;
		if(nowPage>getAllPage())
			this.nowPage=getAllPage();				
		else
			this.nowPage = nowPage;
	}
	
	public int getAllPage() {	
		if(allProduct%10==0) 
			return allProduct/10;
		else
			return allProduct/10+1;
	}
	
	public int getStartPage() {
		if(nowPage%10==0)
			return nowPage-9;
		else 
			return (nowPage/10)*10 + 1; 
	}
	
	public int getEndPage() {
		if(nowPage%10==0)
			return nowPage;
		else if((nowPage/10)*10+10 > getAllPage()) 
			return getAllPage();
		else
			return (nowPage/10)*10+10;
	}
	
		
	public int getStartPost() {
		return nowPage * 10 - 9;
	}

	
}