package psn.lotus.cloud.http;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定义HTTP Header包装实体
 *
 * @project lotus
 * @time 2018/4/19 10:43
 */
public class HttpHeaders {

    private Map<String, List<String>> headers;

    public HttpHeaders() {
        this(new HashMap<>(16));
    }

    public HttpHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    public HttpHeaders(String header, String value) {

    }

    public HttpHeaders put(String header, String value) {
        List<String> values = headers.get(header);
        if (values != null) {
            values.add(value);
        } else {
            values = new ArrayList<>(1);
            values.add(value);
            headers.put(header, values);
        }
        return this;
    }

    public HttpHeaders put(String header, List<String> values) {
        headers.put(header, values);
        return this;
    }

    public HttpHeaders remove(String header) {
        headers.remove(header);
        return this;
    }

    public HttpHeaders clear() {
        headers.clear();
        return this;
    }

    public int size() {
        return headers.size();
    }

    @Override
    public String toString() {
        String split = ":", newLine = "/r/n";
        StringBuilder builder = new StringBuilder(16 * size());
        for (Map.Entry<String, List<String>> entry : headers.entrySet()) {
            builder.append(entry.getKey()).append(split).append(entry.getValue()).append(newLine);
        }
        return builder.toString();
    }

}
