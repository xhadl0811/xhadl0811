package com.mycompany.myapp.Helper;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeHelper {
		public String getTime() {		
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date time = new Date();
			return format.format(time);
		}
}
