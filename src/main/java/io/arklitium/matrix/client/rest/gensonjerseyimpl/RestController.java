package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.List;

public class RestController {

    private final static Logger log = LogManager.getLogger(RestController.class);

    private final Client client;

    private final Boolean tls;


    public RestController(boolean tls, boolean sslAutoSignedCert) throws KeyManagementException, NoSuchAlgorithmException {
        if (sslAutoSignedCert) {
            SSLContext sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[]{new X509TrustManager() {
                public void checkClientTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                public void checkServerTrusted(X509Certificate[] arg0, String arg1) throws CertificateException {
                }

                public X509Certificate[] getAcceptedIssuers() {
                    return new X509Certificate[0];
                }
            }}, new java.security.SecureRandom());
            client = ClientBuilder.newBuilder().sslContext(sslcontext).hostnameVerifier((s1, s2) -> true).build();
        } else {
            client = ClientBuilder.newClient();
        }
        this.tls = tls;
    }


    public <T> T doGET(String target, String path, List<Pair> parameters, Class<T> entityClass) throws Exception {
        Response response = handleRequest("GET", target, path, parameters, null, null)
                .get();
        return handleResponse(response, entityClass);
    }


    public <T> T doGET(String target, String path, List<Pair> parameters, String authToken, Class<T> entityClass) throws Exception {
        Response response = handleRequest("GET", target, path, parameters, null, authToken)
                .get();
        return handleResponse(response, entityClass);
    }


    public <T> T doPUT(String target, String path, List<Pair> parameters, Object payload, Class<T> entityClass) throws Exception {
        Response response = handleRequest("PUT", target, path, parameters, payload, null)
                .put(payload != null ? Entity.json(payload) : null);
        return handleResponse(response, entityClass);
    }


    public <T> T doPUT(String target, String path, List<Pair> parameters, Object payload, String authToken, Class<T> entityClass) throws Exception {
        Response response = handleRequest("PUT", target, path, parameters, payload, authToken)
                .put(payload != null ? Entity.json(payload) : null);
        return handleResponse(response, entityClass);
    }


    public <T> T doPOST(String target, String path, List<Pair> parameters, Object payload, Class<T> entityClass) throws Exception {
        Response response = handleRequest("POST", target, path, parameters, payload, null)
                .post(payload != null ? Entity.json(payload) : null);
        return handleResponse(response, entityClass);
    }


    public <T> T doPOST(String target, String path, List<Pair> parameters, Object payload, String authToken, Class<T> entityClass) throws Exception {
        Response response = handleRequest("POST", target, path, parameters, payload, authToken)
                .post(payload != null ? Entity.json(payload) : null);
        return handleResponse(response, entityClass);
    }


    private Invocation.Builder handleRequest(String httpMethod, String target, String path, List<Pair> parameters, Object payload, String authToken) {
        target = formatToUrl(target);
        WebTarget webTarget = client.target(target).path(path);
        if (parameters != null) {
            for (Pair parameter : parameters) {
                webTarget.queryParam(parameter.getLeft().toString(), parameter.getRight());
            }
        }
        log.info("executing: {} {}", httpMethod, webTarget.getUri().toString());
        if (payload != null) {
            log.info("with data: {}", payload.toString());
        }
        Invocation.Builder requestBuilder = webTarget.request(MediaType.APPLICATION_JSON);
        if (StringUtils.isNotBlank(authToken)) {
            requestBuilder = requestBuilder.header("Authorization", "Bearer " + authToken);
        }
        return requestBuilder;
    }


    private <T> T handleResponse(Response response, Class<T> entityClass) throws Exception {
        if (response.getStatus() != 200) {
            String responseData = response.readEntity(String.class);
            throw new Exception(responseData);
        }
        T entity = response.readEntity(entityClass);
        log.info("response: {}", entity.toString());
        return entity;
    }


    private String formatToUrl(String target) {
        try {
            new URL(target);
            return target;
        } catch (MalformedURLException e) {
            String correctUrl = null;
            if (!StringUtils.startsWithIgnoreCase(target, "http")) {
                if (tls) {
                    correctUrl = StringUtils.replaceFirst(target, "", "https://");
                } else {
                    correctUrl = StringUtils.replaceFirst(target, "", "http://");
                }
                return correctUrl;
            }
            throw new RuntimeException(e);
        }
    }

}
