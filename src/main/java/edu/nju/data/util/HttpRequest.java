package edu.nju.data.util;

import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dora on 2016/7/20.
 */
public class HttpRequest {

    public static String sendGet(String url) throws IOException {
        String newUrl = "http://" + url;
        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(newUrl);
        HttpResponse response = client.execute(request);
        String responseString = new BasicResponseHandler().handleResponse(response);
        return responseString;
    }

    public static String sendPost(String url, Object json) throws IOException {
        url = "https://" + url;
        String result = null;
        HttpPost httpRequest = new HttpPost(url);//创建HttpPost对象
        StringEntity entity = new StringEntity(json.toString(), "utf-8");//解决中文乱码问题
        entity.setContentEncoding("UTF-8");
        entity.setContentType("application/json");
        httpRequest.setEntity(entity);

        HttpResponse httpResponse = new DefaultHttpClient().execute(httpRequest);
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = httpResponse.getEntity();
            result = EntityUtils.toString(httpEntity);//取出应答字符串
        }


        return result;
    }
}