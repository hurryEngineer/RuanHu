package edu.nju.data.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/7/20.
 */
public class HttpRequest {

    public static String sendGet(String url) throws IOException {

        String newUrl = url;
        if(!newUrl.startsWith("http://")) {
            newUrl = "http://" + url;
        }
        
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(newUrl);
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        return responseString;
    }

    private static final String APPLICATION_JSON = "application/json";

    private static final String CONTENT_TYPE_TEXT_JSON = "text/json";

    public static String sendPost(String url, KeyMatch keyMatch) throws IOException {
        if(!url.startsWith("http://")) {
            url = "http://" + url;
        }

        HttpClient httpClient = new DefaultHttpClient();
        HttpPost httpPost = new HttpPost(url);
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("content", keyMatch.getContent()));
        nvps.add(new BasicNameValuePair("type", keyMatch.getType()));

        httpPost.setEntity(new UrlEncodedFormEntity(nvps,HTTP.UTF_8));

        HttpResponse response = httpClient.execute(httpPost);
        String result = new BasicResponseHandler().handleResponse(response);

        return result;
    }
}