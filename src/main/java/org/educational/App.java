package org.educational;

import java.io.IOException;
import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class App {
    public static void main(String[] args) throws IOException {


        Crawler crawler = new Crawler();
        String rootURL = "https://google.com";

        crawler.Crawl(rootURL, 100);

        Scraper scraper = new Scraper();
        final String htmlContent = scraper.getContent(rootURL);
        final String extractedTitle = scraper.extractTitle(htmlContent);
        System.out.println("Scraper: " + extractedTitle);


        String ip = String.valueOf(URL2Ip(rootURL));
        new PortScanner(ip);

    }

    public static InetAddress URL2Ip(String rootURL) {
        InetAddress ip = null;
        try {
            // Fetch IP address by getByName()
            ip = InetAddress.getByName(new URL(rootURL)
                    .getHost());

            // Print the IP address
            System.out.println("Public IP Address of: " + ip);
        } catch (MalformedURLException e) {
            // It means the URL is invalid
            System.out.println("Invalid URL");
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
        return ip;
    }
}