package edu.nju.data.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Dora on 2016/7/26.
 */
public class HttpRequestTest {
    @Test
    public void sendPost() throws Exception {

        String content = "\"这样就可以通过测试了吗\"";
        KeyMatch km = new KeyMatch();
        km.setContent(content);
        String s = HttpRequest.sendPost("121.42.184.4:8080/api/"+"keymatch",km);
        System.out.println(s);
    }

}