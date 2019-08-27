package com.cwb.news.util.commonUtil;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.concurrent.Executor;

/**
 * 文件转换类
 * @author admins
 *
 */
@Component
public class FileConvertManager {
	private static final Logger logger = LoggerFactory.getLogger(FileConvertManager.class);
	@Autowired
	private Executor executor;
	/**
	 * 一个简单的通过命令行转换文件的方法
	 * @param cmd
	 */
	public void convertMp4OrExtrPic(String cmd){
		logger.info(cmd); 
		if(StringUtils.isNotBlank(cmd)){
			logger.info("开启线程执行----"); 
			executor.execute(new ThreedTsConvertMp4OrExtrPic(cmd));
		}
	}
	
	
	/**
	 * ts转换mp4 以及视屏抽取图片的线程
	 * @author admins
	 *
	 */
	class ThreedTsConvertMp4OrExtrPic implements Runnable{
		String cmdStr = "";
		public ThreedTsConvertMp4OrExtrPic(){
			
		}
		public ThreedTsConvertMp4OrExtrPic(String cmd){
			cmdStr = cmd;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			BufferedReader br = null;
			 try {  
				 logger.info("线程执行命令------"+cmdStr); 
		            Process p = Runtime.getRuntime().exec(cmdStr); 
		            br = new BufferedReader(new InputStreamReader(p.getInputStream(),Charset.forName("UTF-8"))); 
		            String line = null;  
		            StringBuilder sb = new StringBuilder();
		            while ((line = br.readLine()) != null) {
		                sb.append(line + "\n");  
		            }
			 }catch (Exception e) {  
		            e.printStackTrace(); 
		            logger.error("exeCmd error:"+e);
		        }
		        finally  
		        {  
		            if (br != null)  
		            {  
		                try {  
		                    br.close();  
		                } catch (Exception e) {  
		                    e.printStackTrace();  
		                }  
		            }
		           
		        } 
			
		}
		
	}
	
	/*
	public static void main(String[] args) {
		//convertMp4("F://Temp//ffmeg//bin//ffmpeg.exe -i \"concat:F:\\Temp\\ffmeg\\bin\\car_865923030039405F20180322111850.ts\" -acodec copy -vcodec copy -absf aac_adtstoasc F:\\Temp\\ffmeg\\bin\\999.mp4");
	}*/
	
}
