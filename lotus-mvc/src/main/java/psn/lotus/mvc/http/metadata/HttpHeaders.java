package psn.lotus.mvc.http.metadata;

import java.io.Serializable;
import java.util.*;

/**
 * HTTP头部信息，可用于请求和响应
 *
 * @author: nicee
 * @since: 2016/2/4
 */
public class HttpHeaders implements Map<String, List<String>>, Serializable {

    private static final long serialVersionUID = -3627925228253293059L;

    private static final String ACCEPT = "Accept";
    private static final String ACCEPT_CHARSET = "Accept-Charset";
    private static final String ALLOW = "Allow";
    private static final String CACHE_CONTROL = "Cache-Control";
    private static final String CONTENT_DISPOSITION = "Content-Disposition";
    private static final String CONTENT_LENGTH = "Content-Length";
    private static final String CONTENT_TYPE = "Content-Type";
    private static final String DATE = "Date";
    private static final String ETAG = "ETag";
    private static final String EXPIRES = "Expires";
    private static final String IF_MODIFIED_SINCE = "If-Modified-Since";
    private static final String IF_NONE_MATCH = "If-None-Match";
    private static final String LAST_MODIFIED = "Last-Modified";
    private static final String LOCATION = "Location";
    private static final String PRAGMA = "Pragma";

    private final Map<String, List<String>> availableHeaders;

    private HttpHeaders(Map<String, List<String>> headers) {
        availableHeaders = headers;
    }

    public HttpHeaders() {
        this(new HashMap<String, List<String>>());
    }

    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean containsKey(Object key) {
        return false;
    }

    public boolean containsValue(Object value) {
        return false;
    }

    public List<String> get(Object key) {
        return null;
    }

    public List<String> put(String key, List<String> value) {
        return null;
    }

    public List<String> remove(Object key) {
        return null;
    }

    public void putAll(Map<? extends String, ? extends List<String>> m) {

    }

    public void clear() {

    }

    public Set<String> keySet() {
        return null;
    }

    public Collection<List<String>> values() {
        return null;
    }

    public Set<Entry<String, List<String>>> entrySet() {
        return null;
    }
}
