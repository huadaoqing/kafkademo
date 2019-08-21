package com.example.demo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

public class ReadTxt {
	private  static Map<String,String> userAccountMap = new HashMap<>();
	
	/**
     * 获得电话号码的正则表达式：包括固定电话和移动电话
     * 符合规则的号码：
     *     1》、移动电话
     *         86+‘-’+11位电话号码
     *         86+11位正常的电话号码
     *         11位正常电话号码a
     *         (+86) + 11位电话号码
     *         (86) + 11位电话号码
     *     2》、固定电话
     *         区号 + ‘-’ + 固定电话  + ‘-’ + 分机号
     *         区号 + ‘-’ + 固定电话 
     *         区号 + 固定电话
     * @return    电话号码的正则表达式
     */
    public static String isPhoneRegexp()
    {
        String regexp = "";
        
        //能满足最长匹配，但无法完成国家区域号和电话号码之间有空格的情况
        String mobilePhoneRegexp = "\"userAccount\":\".*\"";
        
        
        
        //    System.out.println("regexp = " + mobilePhoneRegexp);
        //固定电话正则表达式   
 
        regexp += mobilePhoneRegexp; 
    
        return regexp;
    }


	/**
	   * 读取文件，将文件中的电话号码读取出来，保存在Set中。
	   * @param filePath	文件的绝对路径
	   * @return			文件中包含的电话号码
	   */
	  public static Set<String> getPhoneNumFromFile(String filePath)
	  {
	    Set<String> phoneSet = new HashSet<String>();
	    try
	    {
	      String encoding = "UTF-8";
	      File file = new File(filePath);
	      if (file.isFile() && file.exists())
	      { // 判断文件是否存在
	        InputStreamReader read = new InputStreamReader(
	            new FileInputStream(file), encoding);// 考虑到编码格
	        BufferedReader bufferedReader = new BufferedReader(read);
	        String lineTxt = null;
	        while ((lineTxt = bufferedReader.readLine()) != null)
	        {
	          //读取文件中的一行，将其中的电话号码添加到phoneSet中
	          getPhoneNumFromStrIntoSet(lineTxt, phoneSet);
	        }
	        read.close();
	      }
	      else
	      {
	        System.out.println("找不到指定的文件");
	      }
	    }
	    catch (Exception e)
	    {
	      System.out.println("读取文件内容出错");
	      e.printStackTrace();
	    }
	    return phoneSet;
	  }
	  

	    /**
	     * 从dataStr中获取出所有的电话号码（固话和移动电话），将其放入Set
	     * @param dataStr    待查找的字符串
	     * @param phoneSet    dataStr中的电话号码
	     */
	    public static void getPhoneNumFromStrIntoSet(String dataStr,Set<String> phoneSet)
	    {
	        //获得固定电话和移动电话的正则表达式
	        String regexp = isPhoneRegexp();
	        
	      //  System.out.println("Regexp = " + regexp);
	        
	        Pattern pattern = Pattern.compile(regexp); 
	        java.util.regex.Matcher matcher = pattern.matcher(dataStr); 
	 
	        //找与该模式匹配的输入序列的下一个子序列
	        while (matcher.find()) 
	        { 
	            //获取到之前查找到的字符串，并将其添加入set中
	           // phoneSet.add();
	        	String[] a= matcher.group().split(",");
	        	String[] b = a[0].split(":");
	        	String str = b[1].replace("\"", "");
	        	userAccountMap.put(str, "");
	        } 
	        //System.out.println(phoneSet);

}
	    public static void main(String[] args) { 
/*	    	String text = "13522158842;托尔斯泰;test2;13000002222;8613111113313"; 
	    	Pattern pattern = Pattern.compile("(?<!\\d)(?:(?:1[358]\\d{9})|(?:861[358]\\d{9}))(?!\\d)"); 
	    	java.util.regex.Matcher matcher = pattern.matcher(text); 
	    	    StringBuffer bf = new StringBuffer(64); 
	    	    while (matcher.find()) { 
	    	      bf.append(matcher.group()).append(","); 
	    	    } 
	    	    int len = bf.length(); 
	    	    if (len > 0) { 
	    	      bf.deleteCharAt(len - 1); 
	    	    } 
	    	   
	    	System.out.println(bf.toString()); */
	    	getPhoneNumFromFile("C:\\Users\\华道青\\Desktop\\698039018080000003.txt");
	    	int i=0;
	    	for(String a:userAccountMap.keySet()){
	    		i++;
	    		System.out.println(i+":"+a);
	    		

	    	}
	    	}
	}
