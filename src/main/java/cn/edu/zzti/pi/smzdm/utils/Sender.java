package cn.edu.zzti.pi.smzdm.utils;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class Sender {

    public static String send(HttpRequestBase httpRequest) throws Exception {
        return buildSession().send(httpRequest);
    }

    public static Session buildSession() {
        return new Session(HttpClients.createDefault());
    }

    public static HttpGet buildGetRequest(String url) throws Exception {
        return new HttpGet(url);
    }

    public static HttpGet buildGetRequest(String url, String request) throws Exception {
        if (null == request || 0 == request.length()) return new HttpGet(url);
        return new HttpGet(url + "?" + new String(request));
    }

    public static HttpPost buildPostRequest(String url, String request) throws Exception {
        HttpPost post = new HttpPost(url);
        post.setEntity(new StringEntity(request));
        return post;
    }

    public static HttpPost buildPostRequest(String url, Map<String, String> model) throws Exception {
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        for (Map.Entry<String, String> e : model.entrySet()) {
            list.add(new BasicNameValuePair(e.getKey(), e.getValue()));
        }
        post.setEntity(new UrlEncodedFormEntity(list, "UTF-8"));
        return post;
    }
}
