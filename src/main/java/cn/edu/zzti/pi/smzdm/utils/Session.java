package cn.edu.zzti.pi.smzdm.utils;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.util.EntityUtils;

public final class Session {

    private final HttpClient httpClient;

    public Session(HttpClient httpClient) {
        this.httpClient = httpClient;
    }

    private static final RequestConfig requestConfig = RequestConfig.custom()
            .setConnectTimeout(30 * 1000)
            .setSocketTimeout(30 * 1000)
            .build();

    public String send(HttpRequestBase httpRequest) throws Exception {
        httpRequest.setConfig(requestConfig);

        HttpResponse result = httpClient.execute(httpRequest);
        String response = EntityUtils.toString(result.getEntity());
        return response;
    }
}
