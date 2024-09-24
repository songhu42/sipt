package com.humanval.hsm.util;

import java.io.*;
import java.net.URL;
import java.net.URLEncoder;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;
import javax.net.ssl.HttpsURLConnection;

import java.util.Random;
import java.util.HashMap;
import java.util.Map.Entry;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
/*
 * 
 * NaverCloudAPI
 * Https request, response
 */
public class NaverCloudAPI
{
	static String url = "https://naveropenapi.apigw.ntruss.com/voice/v1/tts"; 

	public static void writeVoiceMP3(String text, String target) {

		try {

			URL url = new URL(NaverCloudAPI.url);
			HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();  
			connection.setDoInput(true);
			connection.setDoOutput(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
			connection.setRequestProperty("X-NCP-APIGW-API-KEY-ID", "jxvg5mfjdw");
			connection.setRequestProperty("X-NCP-APIGW-API-KEY", "hZxjeoocU8UwNKnyBS5ng0orJ9Lc2n3dMwTjISr4");

			DataOutputStream outputStream = new DataOutputStream(new BufferedOutputStream(connection.getOutputStream()));

			String bodyStr = "speaker=clara&speed=0&text=" + URLEncoder.encode(text, "UTF-8"); 
			outputStream.writeBytes(bodyStr); 
			outputStream.flush();
			outputStream.close();

			int response_code = connection.getResponseCode();

			if (response_code == 200) {
				InputStream is = connection.getInputStream();
                int read = 0;
                byte[] bytes = new byte[1024];

                File f = new File(target);
                f.createNewFile();
                OutputStream os = new FileOutputStream(f);
                while ((read =is.read(bytes)) != -1) {
                    os.write(bytes, 0, read);
                }
                is.close();
                os.close();
			}

		} catch (Exception e) {
			e.printStackTrace(); 
		} 
	}
	
	public static void main(String args[]) {
		NaverCloudAPI.writeVoiceMP3("belongs to",  "C:\\ProjectLuna\\hsm\\WebContent\\mp3\\belongsto.mp3");
	}
}
