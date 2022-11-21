package org.educational;



import org.educational.crawler.Crawler;

import java.util.ArrayList;
import java.util.List;

public class App {



    public static void main(String[] args) {

        Crawler crawler = new Crawler();
        List<String> hostURLs = new ArrayList<>();

        hostURLs.add("https://www.google.com");
        hostURLs.add("https://www.overthewire.org/wargames/banditlabs/bandit0");
        hostURLs.add("https://www.cryptocompare.com");

        /*for (String s : PortScanner.portScanReport) {
            System.out.println(s);
        }*/



        for (int i = 0; i < hostURLs.size(); i++) {
            String host = hostURLs.get(i);
            crawler.Crawl(host, 100);
            System.out.println(host);
            //hostDB.addURL(host);

        }















    }


}




