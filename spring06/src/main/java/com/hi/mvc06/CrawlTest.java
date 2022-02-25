package com.hi.mvc06;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class CrawlTest {

	public static void main(String[] args) {
		// 1. 사이트에 연결 요청(http 요청)
		// 2. html문서를 받아온다.(http 응답) 7000줄 코드를 받음.
		// 3. 추출하고자 하는 위치를 찾아서 해당 노드를 가지고 온다.
		//    결과는 list자료구조를 사용
		//    기존에 ArrayList를 재사용해서 가능을 더 붙여놓은 
		//    Elements(상속해서 만들어 놓음.)
		
		String url="https://finance.naver.com/item/main.naver?code=035720";
		
		try {
			Document doc= Jsoup.connect(url).get();
			//System.out.println(doc);

//			Elements list=doc.select("span.code");
//			System.out.println(list.size());
//			System.out.println(list.get(0).text());
			
//			Elements list=doc.select("span.tx");
//			System.out.println(list.size());
//			System.out.println(list.text());
//			System.out.println(list.get(6).text());
			
			
			//#middle > div.h_company > div.wrap_company > div > span.code
			//Elements list=doc.select("div.today span.blind");
			//Elements list=doc.select("span.blind");
			//System.out.println(list.get(0).text());
			
			Elements list=doc.select("table > tbody > tr:nth-child(1) > td:nth-child(2) > em.no_up > span");
			System.out.println(list.get(0).text());					
			list=doc.select("table > tbody > tr:nth-child(1) > td.first > em > span");
			System.out.println(list.get(0).text());
			System.out.println("=======");
			
			String today=list.get(0).text();
			String[] s=today.split(",");
			String today2=String.join("", s);
			int today3=Integer.parseInt(today2);
			System.out.println(today3);
			
			
			
			
		} catch (IOException e) {
			System.out.println("크롤링하는 중 에러발생...");
			e.printStackTrace();
		} //1,2
		

	}

}
