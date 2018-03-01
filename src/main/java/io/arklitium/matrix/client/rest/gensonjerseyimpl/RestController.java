package io.arklitium.matrix.client.rest.gensonjerseyimpl;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
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

    public Response doGET(String target, String path) {
        target = formatUrl(target);
        log.info("executing: " + target + "/" + path);
        Response response = client.target(target)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .get();
        return response;
    }

    public Response doGET(String target, String path, String token) {
        target = formatUrl(target);
        log.info("executing: " + target + "/" + path);
        Response response = client.target(target)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .get();
        return response;
    }

    public Response doGET(String target, String path, List<Pair> parameters, String token) {
        target = formatUrl(target);
        WebTarget webTarget = client.target(target).path(path);
        for (Pair parameter : parameters) {
            webTarget.queryParam(parameter.getLeft().toString(), parameter.getRight());
        }
        log.info("executing: " + webTarget.getUri().toString());
        Response response = webTarget
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .get();
        return response;
    }

    public Response doPUT(String target, String path, String token, Object payload) {
        target = formatUrl(target);
        log.info("executing: " + target + "/" + path);
        Response response = client.target(target)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .header("Authorization", "Bearer " + token)
                .put(Entity.json(payload));
        return response;
    }


    public Response doPOST(String target, String path, Object payload) {
        target = formatUrl(target);
        log.info("executing: " + target + "/" + path);
        Response response = client.target(target)
                .path(path)
                .request(MediaType.APPLICATION_JSON)
                .post(payload != null ? Entity.json(payload) : null);
        return response;
    }

    private String formatUrl(String target) {
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
                return  correctUrl;
            }
            throw new RuntimeException(e);
        }
    }

}
