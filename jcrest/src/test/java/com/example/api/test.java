package com.example.api;

import static org.junit.Assert.*;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;




public class test {


	@Test
	public void test() throws Exception {
		URL url;
	
	
				url = new URL("http://localhost:8080/api/members/");
				// 문자열로 URL 표현
				System.out.println("URL :" + url.toExternalForm());
				// HTTP Connection 구하기
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				// 요청 방식 설정 ( GET or POST or .. 별도로 설정하지않으면 GET 방식 )
				conn.setRequestMethod("GET");
				// 연결 타임아웃 설정
				conn.setConnectTimeout(3000); // 3��
				// 읽기 타임아웃 설정
				conn.setReadTimeout(3000); // 3��
				// 요청 방식 구하기
				System.out.println("getRequestMethod():" + conn.getRequestMethod());
				// 응답 콘텐츠 유형 구하기
				System.out.println("getContentType():" + conn.getContentType());
				// 응답 코드 구하기
				System.out.println("getResponseCode():" + conn.getResponseCode());
				assertEquals(200, conn.getResponseCode());

				try (InputStream in = conn.getInputStream();

						ByteArrayOutputStream out = new ByteArrayOutputStream()) {
						byte[] buf = new byte[1024 * 8];
						int length = 0;
						while ((length = in.read(buf)) != -1) {
							out.write(buf, 0, length);
						}

				String strBody = new String(out.toByteArray());
				System.out.println(strBody);
				String[] array = strBody.split(":");
				// assertEquals(array[1], "1");
				System.out.println(strBody);
				}

		} 

	}	

