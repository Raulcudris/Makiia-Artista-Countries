
package com.makiia.crosscutting.patterns;

import com.makiia.crosscutting.domain.constants.Constants;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.StandardCharsets;
import java.util.Map;


@Setter
@Getter
@Log4j2
@Component
public class AdapterClientRest {

    @Autowired
    private RestTemplate restTemplate;

    public <T> T get(final String endpoint, final Class<T> responseObject) {
        log.info(Constants.EXECUTING_GET, endpoint);

        return this.restTemplate.getForObject(endpoint, responseObject);
    }

    public <T> T get(final String endpoint, final Class<T> responseObject, final String param) {
        log.info(Constants.EXECUTING_GET, endpoint);

        return this.restTemplate.getForObject(endpoint, responseObject, param);
    }

    public <T> T get(final String endpoint, final Class<T> responseObject, final Map<String, String> params) {
        log.info(Constants.EXECUTING_GET, endpoint);

        return this.restTemplate.getForObject(endpoint, responseObject, params);
    }

    public <T> T post(final String endpoint, final Object data, final Class<T> responseObject,
                      final HttpHeaders headers) {
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info(Constants.EXECUTING_POST, endpoint);
        HttpEntity<Object> request = new HttpEntity<>(data, headers);

        return this.restTemplate.postForObject(endpoint, request, responseObject);
    }

    public <T> T post(final String endpoint, final Object data, final Class<T> responseObject) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info(Constants.EXECUTING_POST, endpoint);
        HttpEntity<Object> request = new HttpEntity<>(data, headers);

        return this.restTemplate.postForObject(endpoint, request, responseObject);
    }

    public <T> Boolean delete(final String endpoint) {
        log.info(Constants.EXECUTING_DELETE, endpoint);

        this.restTemplate.delete(endpoint);

        return true;
    }

    public <T> Boolean delete(final String endpoint, final Map<String, String> params) {
        log.info(Constants.EXECUTING_DELETE, endpoint);

        this.restTemplate.delete(endpoint, params);

        return true;
    }

    public <T> T post(final String endpoint, final Object data, final Class<T> responseObject,
                      final Map<String, String> paramsUri) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        log.info(Constants.EXECUTING_POST, endpoint);
        HttpEntity<Object> request = new HttpEntity<>(data, headers);

        return this.restTemplate.postForObject(endpoint, request, responseObject, paramsUri);
    }

    public <T> T postStringUTF8(final String endpoint, final Object data, final Class<T> responseObject,
                                final HttpHeaders headers) {
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(StandardCharsets.UTF_8));
        log.info(Constants.EXECUTING_POST, endpoint);
        HttpEntity<Object> request = new HttpEntity<>(data, headers);

        return this.restTemplate.postForObject(endpoint, request, responseObject);
    }

    public ResponseEntity<String> postForEntityMetod(String path,
                                                     HttpEntity<MultiValueMap<String, Object>> requestEntity) {
        return restTemplate.postForEntity(path, requestEntity, String.class);
    }

    public <T> ResponseEntity<T> getForEntityMetod(String path, final Class<T> responseObject) {
        return restTemplate.getForEntity(path, responseObject);
    }

    public byte[] getForObjectMetod(String path) {
        return restTemplate.getForObject(path, byte[].class);
    }

    public ResponseEntity<String> getForEntityMetod(String path) {
        return restTemplate.getForEntity(path, String.class);
    }
}
