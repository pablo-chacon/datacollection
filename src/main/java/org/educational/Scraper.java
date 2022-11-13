package org.educational;


import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Scraper {

    /*
    Scraper scraper = new Scraper();
        final String htmlContent = scraper.getContent();
        final String extractedTitle = scraper.extractTitle();
        System.out.println(extractedTitle);*/


    public static String getContent(String rootURL)throws IOException {
        final OkHttpClient client = new OkHttpClient.Builder().build();
        final Request request = new Request.Builder().url(rootURL).build();
        final Response response = client.newCall(request).execute();
        return response.body().string();
    }

    public static String extractTitle(String htmlContent) {
        final Pattern titleRegExp = Pattern.compile("<title>(.*?)</title>", Pattern.DOTALL);
        final Matcher matcher = titleRegExp.matcher(htmlContent);
        matcher.find();
        return matcher.group(1);
    }

    /*public static void printExtractTitle() {
        System.out.println(Scraper.extractTitle(htmlContent));
    }*/
}
