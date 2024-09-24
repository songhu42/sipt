package com.humanval.sipt.util;

import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.SimpleTimeZone;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.Vector;


/**
 * 
 * @author Administrator
 *
 */

public class ComUtil {
	
	public static String getIntFormat(int num){
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(0);
	    
	    return nf.format(num);
	}

	public static String getLongFormat(long num){
		NumberFormat nf = NumberFormat.getNumberInstance();
		nf.setMaximumFractionDigits(0);
	    
	    return nf.format(num);
	}
	
	// jsp include param �쟾�떖�떆 encode �븘�슂 
	public static String encodeUTF8(String src) {
		String rtn = ""; 
		try {
			rtn = java.net.URLEncoder.encode(src, "UTF8");
		} catch( UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}
		return rtn;  
	}

	// jsp param decode �븘�슂 
	public static String decodeUTF8(String src) {
		String rtn = ""; 
		try {
			rtn = java.net.URLDecoder.decode(src, "UTF8");
		} catch( UnsupportedEncodingException ue) {
			ue.printStackTrace();
		}
		return rtn;  
	}
	
	// param �븳湲� 諛쏆쓣�븣 decode & chNull �쟻�슜 .. 
	public static String chUTFString(String src) {
		return decodeUTF8(chNull(src)); 
	}
	
	// list�뿉 �뾾�뒗 媛믪씤 寃쎌슦 add�븳�떎. 
	public static ArrayList<String> addUnique(ArrayList<String> list, String data) {
		for( int i=0; i<list.size(); i++ ) {
			if( data.equals((String)list.get(i)) ) return list; 
		}
		list.add(data); 
		return list; 
	}
	// list�뿉 �엳�뒗 媛믪�吏� 泥댄겕 .. 
	public static boolean isExist(ArrayList<String> list, String data) {
		for( int i=0; i<list.size(); i++ ) {
			if( data.equals((String)list.get(i)) ) return true; 
		}

		return false; 
	}	
		
	
	/**
	 * get current time int 
	 * @date    2012-03-02
	 * @author  songhu
	 */
	public static int getTime(){
		int standardGMT = 9; 	// for KOREA
		
	    String[] ids = TimeZone.getAvailableIDs(standardGMT * 60 * 60 * 1000);
	    SimpleTimeZone pdt = new SimpleTimeZone(standardGMT * 60 * 60 * 1000, ids[0]);
	    Calendar date = new GregorianCalendar(pdt);
	    Date trialTime = new Date();
	    date.setTime(trialTime);

	    int timex = (date.get(Calendar.HOUR_OF_DAY)*10000) + (date.get(Calendar.MINUTE)*100) + date.get(Calendar.SECOND);
	    return timex;
	} // end get Time
	
	/**
	 * @param void
	 * @return 121212 123 long 
	 * @date    2002-06-21
	 * @author  songhu
	 */
	public static long getMilliTime(){

		int standardGMT = 9; 	// for KOREA

		String[] ids = TimeZone.getAvailableIDs(standardGMT * 60 * 60 * 1000);
	    SimpleTimeZone pdt = new SimpleTimeZone(standardGMT * 60 * 60 * 1000, ids[0]);
	    Calendar date = new GregorianCalendar(pdt);
	    Date trialTime = new Date();
	    date.setTime(trialTime);

	    int timexm = date.get(Calendar.MILLISECOND);
	    return timexm;
	} // end get Time

	public static int getDayOfWeek(String day) {
		return getDayOfWeek(getDate(day, "-"));
	}

	public static int getDayOfWeek(String day, String delim) {
		return getDayOfWeek(getDate(day, delim));
	}

	public static int getDayOfWeek(Date day) {
		Calendar c = Calendar.getInstance();
		c.setTime(day);
		int dayOfWeek = c.get(Calendar.DAY_OF_WEEK);
		
		return dayOfWeek; 
	}
	/**
	 * gap �씪 �썑�쓽 �궇吏� 怨꾩궛 
	 * @param   int int
	 * @return  Date
	 * @date    2013-04-09
	 * @author  songhu
	 */
	public static Date gapDay(Date date, int gap){
		long newTime = date.getTime() + (long)gap * 1000 * 60 * 60 * 24; 
	    Date date1 = new Date(newTime); 
	    
	    return date1;
	}

	/**
	 * �궇吏� 李⑥씠 鍮꾧탳 .. 
	 * @param   Date from, Date to
	 * @return  int 10�씪
	 * @date    2013-04-09
	 * @author  songhu
	 */
	public static int diffDay(Date from, Date to) throws Exception {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		String fromStr = formatter.format(from); 
		String toStr = formatter.format(to); 
		
		Date fromN = new Date(formatter.parse(fromStr).getTime()); 
		Date toN = new Date(formatter.parse(toStr).getTime()); 
		
		int gab = (int)(( toN.getTime() - fromN.getTime() )/((long)1000 * 60 * 60 * 24)); 
		
		return gab; 
	}  

	
	
	/**
	 * �궇吏� 紐뉗씪�썑 諛섑솚 
	 * @param   int nowDate, int gap
	 * @return  int 20020131
	 * @date    2002-05-16
	 * @author  songhu
	 */
	public static int gapDayInt(int nowDate, int gap){
		int yearx   = nowDate/10000;
		int monthx  = (nowDate - (yearx*10000))/100;
		int dayx    = nowDate - (yearx*10000) - (monthx*100);

		int day     = 0;
		Calendar date = Calendar.getInstance();
		date.set(yearx, (monthx-1), dayx);
		date.set(Calendar.DATE, date.get(Calendar.DAY_OF_MONTH) + gap);

		day = (date.get(Calendar.YEAR) * 10000) + ((date.get(Calendar.MONTH)+1) *100) + date.get(Calendar.DAY_OF_MONTH) ;
		return day;
	} 

	/**
	 * �궇吏� 紐뉗씪�썑 諛섑솚 
	 * @param   String nowDate(20121212), int gap
	 * @return  int 20020131
	 * @date    2018-05-16
	 * @author  songhu
	 */
	public static String gapDayString(String nowDate, int gap){
		int gapDay = gapDayInt(Integer.parseInt(nowDate), gap); 

		return String.valueOf(gapDay);
	} 

	/**
	 * String(2012-01-01)�삎 �궇吏쒕�� Date濡� 蹂��솚 
	 * @param   day String,
	 * @return   Date
	 * @date    2018-10-20
	 * @author  songhu
	 */
	public static Date getDate(String day){
		return getDate(day, "-"); 
	} 

	public static Date getDate(String day, String delim){
		String nday = chNull(day); 
		Date rDate = new Date(); 
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy" + delim + "MM" + delim + "dd");
		
		try {
			rDate = formatter.parse(nday);
		} catch(Exception pe) {
			pe.printStackTrace();
		}
		
		return rDate; 
	} 

	/**
	 * Int�삎 �궇吏쒕�� String(2012-01-01)�쑝濡� 蹂��솚 
	 * @param   Day int,
	 * @return  2002-01-01 String
	 * @date    2002-03-02
	 * @author  songhu
	 */
	public static String getDateString(int day){
		String date = day + "";

		if( day == 0 ){
			date = "";
		} else if(day>10000000){
			date = date.substring(0,4) + "-" +date.substring(4,6) + "-" + date.substring(6,8);
		} else if(day>100000){
			date = date.substring(0,4) + "-" +date.substring(4,6);
		}
		return date;
	} 


	/**
	 * �궇吏쒕�� String(2012-01-01)�쑝濡� 蹂��솚 
	 * @param   Day int,
	 * @return  2002-01-01 String
	 * @date    2002-03-02
	 * @author  songhu
	 */
	public static String getDateString(Date day){
		return getDateString(day, "-"); 
	}
	
	public static String getDateString(Date day, String delim){
		SimpleDateFormat formatter=new SimpleDateFormat("yyyy" + delim + "MM" + delim + "dd");
		
		return formatter.format(day);
	}  

	public static String getDateStringWest(Date day){
		SimpleDateFormat formatter=new SimpleDateFormat("MM/dd/yyyy");
		
		return formatter.format(day);
	}  
	
	/**
	 * String(20120101)�삎 �궇吏쒕�� String(2012-01-01)�쑝濡� 蹂��솚 
	 * @param   Day String,
	 * @return  2002-01-01 String
	 * @date    2002-03-02
	 * @author  songhu
	 */
	public static String getDateString(String day){
		if(day.equals("")) return ""; 
	    int dat = Integer.parseInt(day);
	    return getDateString(dat);
	}


	/**
	 * NullPointException�뿉 �븞�쟾�븳 String to Number Converting 
	 * @param   String s_number
	 * @return  double rtnValue
	 * @date    2003-07-15
	 * @author  songhu
	 */
	public static double getDoubleNumber(String snum){
		String s_number = chNull(snum); 

	    String tmpNumber = "";
	    double rtnValue = 0.0d;
	    if(s_number == null || s_number.equals("")){
	        return 0.0d;
	    }else{
	        StringTokenizer st = new StringTokenizer(chNull(s_number), ",");
	        while(st.hasMoreTokens()){
	            tmpNumber += st.nextToken();
	        }
	        rtnValue = Double.parseDouble(tmpNumber);
	        return rtnValue;
	    }//end if
	} // end getDoubleNumber

	public static long getLongNumber(String snum){
		String s_number = chNull(snum); 

	    String tmpNumber = "";
	    long rtnValue = 0L;
	    if(s_number == null || s_number.equals("")){
	        return 0L;
	    }else{
	        StringTokenizer st = new StringTokenizer(s_number, ",");
	        while(st.hasMoreTokens()){
	            tmpNumber += st.nextToken();
	        }
	        rtnValue = Long.parseLong(tmpNumber);
	        return rtnValue;
	    }//end if
	} // end getLongNumber

	public static float getFloatNumber(String snum){
		String s_number = chNull(snum); 
		
	    String  tmpNumber = "";
	    float   rtnValue = 0.0f;
	    if(s_number == null || s_number.equals("")){
	        return 0.0f;
	    }else{
	        StringTokenizer st = new StringTokenizer(s_number, ",");
	        while(st.hasMoreTokens()){
	            tmpNumber += st.nextToken();
	        }
	        rtnValue = Float.parseFloat(tmpNumber);
	        return rtnValue;
	    }//end if
	} // end getFloatNumber

	public static int getIntNumber(String snum){
		String s_number = chNull(snum); 

	    String  tmpNumber = "";
	    int     rtnValue = 0;
	    if(s_number == null || s_number.equals("")){
	        return 0;
	    }else{
	        StringTokenizer st = new StringTokenizer(s_number, ",");
	        while(st.hasMoreTokens()){
	            tmpNumber += st.nextToken();
	        }
	        rtnValue = Integer.parseInt(tmpNumber);
	        return rtnValue;
	    }//end if
	} // end getIntNumber


	public static int getDateNumber(String snum){
		String s_number = chNull(snum); 

		String  tmpNumber = "";
		int     rtnValue = 0;
		if(s_number == null || s_number.equals("")){
			return 0;
		}else{
			tmpNumber = ComUtil.replace(s_number, "-", ""); 
			tmpNumber = ComUtil.replace(tmpNumber, "/", ""); 
			
			rtnValue = Integer.parseInt(tmpNumber);
			return rtnValue;
		}//end if
	} // end getIntNumber

		
	public static String chNull(String Req, String def ) {
		if (Req == null || Req.trim().equals("") || Req.trim().equals("undefined") ) return def;
		else return Req.trim();
	}
	
	public static String chNull(String Req ) {
		if (Req == null || Req.trim().equals("") || Req.trim().equals("undefined") ) return "";
		else return Req.trim();
	}
	public static int chNull(int Req ) {
		return Req;
	}
	public static long chNull(long Req ) {
		return Req;
	}
   
	public static double chNull(double Req ) {
		return Req;
	}
	public static BigDecimal chNull(java.math.BigDecimal Req ) {
		return Req;
	}
	public static Date chNull(Date Req ) {
	   if (Req == null ) Req = new Date(); 
	   return Req;
	}
	
	public static String substring(String str, int start, int end){
			String retStr = "";	
			
			int rStart = 0;
			int rEnd = 0;
			String oneChar;
			for(int i = 0; i < end; i++){
				
				oneChar = "" + str.charAt(i);
				if(rStart == start){
					retStr = retStr + oneChar;
					if(oneChar.getBytes().length == 1){
						rEnd++;
						
					}else if(oneChar.getBytes().length == 2){
						rEnd = rEnd + 2;
					} else{
					}				
								
				}

				if(rEnd == end)break;

				if(rStart != start){
					if(oneChar.getBytes().length == 1){
						rStart++;
						rEnd++;
						
					}else if(oneChar.getBytes().length == 2){
						rStart = rStart + 2;
						rEnd = rEnd + 2;
					} else{
					}
				}

			}		
			return retStr;		
		}

	public static double round(double val, int pnt)
	{
		double tmp = val * Math.pow(10, pnt); 
		tmp = Math.round(tmp); 
		return (double)tmp/Math.pow(10, pnt);
	}

	public static String[] split(String str, String s) {
			StringTokenizer st = new StringTokenizer(str, s);
			List<String> list = new ArrayList<String>();

			while (st.hasMoreTokens()) {
				list.add(st.nextToken());
			}

			String[] result = new String[list.size()];

			for (int i = 0; i < list.size(); ++i) {
				result[i] = (String) list.get(i);
			}

			return result;
	}


	//replaceAll 
	public static String replaceAll(String str, String oldstr, String newstr) { 
		StringBuffer buf = new StringBuffer(); 
		int savedpos = 0; 
		while(true) { 
			int pos = str.indexOf(oldstr, savedpos); 		
			if(pos != -1) { 
				buf.append(str.substring(savedpos, pos)); 
				buf.append(newstr); 
		
				savedpos = pos + oldstr.length(); 
				if(savedpos >= str.length()) 	break; 
			} else 	break; 
		} 
		buf.append(str.substring(savedpos, str.length())); 
		return buf.toString(); 
	} 

	// String replace.. 
	public static String replace( String cont, String src, String des ) {
		if( src.equals("") ) return cont; 
		
		StringBuffer buffer = new StringBuffer(); 
		int src_len = src.length(); 
		int con_len = cont.length(); 
		
		for( int i=0; i<con_len; i++ ) {
			if( i > con_len-src_len ) {
				buffer.append( cont.substring(i) ); 
				break; 
			}
			
			String substr = cont.substring(i, i+src_len); 
			if( substr.equals(src) ) { 
				buffer.append(des); 
				i += (src_len-1); 
			} else {
				buffer.append( cont.substring(i, i+1) ); 
			}
		}
		
		return new String( buffer ); 
		
	}
	
	
	// change delimiter to , separated string 
	public static String getTokenString(String src, String delim) {
		String retStr = ""; 
		Vector<String> retV = getTokenVector(src, delim); 
		for( int i=0; i<retV.size(); i++) {
			if( i > 0 ) retStr += ","; 
			retStr += "'" + (String)retV.get(i) + "'"; 
		}
		return retStr; 
		
	}
	// return token string vector
	public static Vector<String> getTokenVector(String src, String delim) {
		
		Vector<String> retV = new Vector<String>(); 
		StringTokenizer tck = new 	StringTokenizer(src, delim); 
		while( tck.hasMoreElements() ) {
			String elem = tck.nextToken().trim();
			if( !"".equals(elem) ) retV.add(elem);
		}
		return retV; 
		
	}
	
	public static int countChar(String source, char ch) {
		int lastPos = 0; 
		int count = 0; 
		for( int i=0; i<source.length(); ) {
			lastPos = source.indexOf(ch, lastPos+1); 
			if( lastPos >= 0 ) { 
				count++;
				i = lastPos; 
			} else break; 
		}
		return count; 
	}
	
	public static String alert(String msg) {
		StringBuffer rHtml = new StringBuffer();
		
		if ( msg == null || msg.equals("") ) return "";
		rHtml.append("<script language=javascript>\n");
		rHtml.append("alert('").append(msg).append("'); \n");
		rHtml.append("</script> \n");
		
		return rHtml.toString();
	}

	public static String alertClose() {
		StringBuffer rHtml = new StringBuffer();
		
		rHtml.append("<script language=javascript>\n");
		rHtml.append("alert('Process instance has been successfully initialized and started'); \n");
		rHtml.append("self.close();\n");
		rHtml.append("</script>\n");
		
		return rHtml.toString();
	}

	public static String redirect(String url) {
		StringBuffer rHtml = new StringBuffer();
		
		if ( url == null || url.equals("") ){
			return "";
		}
		rHtml.append("<html>\n ");
		rHtml.append("<head>\n ");
		rHtml.append("</head>\n ");
		rHtml.append("<body>\n ");
		rHtml.append("<script type=\"text/javascript\">\n ");
		rHtml.append("location.href='" + url + "'; \n");
		rHtml.append("</script> \n");
		rHtml.append("</body>\n ");
		rHtml.append("</html>\n ");
		
		return rHtml.toString();
	}
	
	public static String parentRedirect(String url) {
		StringBuffer rHtml = new StringBuffer();
		
		if ( url == null || url.equals("") ){
			return "";
		}
		rHtml.append("<script language=javascript>\n ");
		rHtml.append("parent.location.href='" + url + "'; \n");
		rHtml.append("</script> \n");
		return rHtml.toString();
	}
	
	/**
	 * �쁽�옱 �궇吏쒕�� yyyyMMddHHmmss�삎�깭濡� 諛섑솚
	 * @return
	 */
	public static String getCurrentDate(){
		Calendar cal = Calendar.getInstance();
		
	    String yyyy = Integer.toString(cal.get(Calendar.YEAR));
	    String mm   = Integer.toString(cal.get(Calendar.MONTH) + 1);
	    String dd   = Integer.toString(cal.get(Calendar.DAY_OF_MONTH));
	    String hh   = Integer.toString(cal.get(Calendar.HOUR_OF_DAY));
	    String mi   = Integer.toString(cal.get(Calendar.MINUTE));
	    String ss   = Integer.toString(cal.get(Calendar.SECOND));
	    
	    return yyyy + (mm.length() == 1 ? "0" + mm : mm) + (dd.length() == 1 ? "0" + dd : dd) + (hh.length() == 1 ? "0" + hh : hh) + (mi.length() == 1 ? "0" + mi : mi) + (ss.length() == 1 ? "0" + ss : ss); 
	}

	/**
	 * �뙆�씪 �솗�옣�옄瑜� 諛섑솚�븳�떎. 
	 * @param String fileName
	 * @param String
	 * @return
	 */
	public static String getFileExt(String fileName ) {
    	String ext = ""; 
    	int ind = fileName.lastIndexOf("."); 
    	if( ind >= 0 ) ext = fileName.substring(ind); 

    	return ext; 
	}
}
