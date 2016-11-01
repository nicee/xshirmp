package psn.lotus.worm;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @project lotus
 * @time 2016/10/27 13:30
 */
public class CrawUrl implements Serializable {

    //扒取地址
    private String url;
    //地址编号
    private int urlNo;
    //扒取地址MD5值
    private String urlMd5;
    //地址响应码
    private int statusCode;
    //地址权重
    private int weight;
    //引用次数
    private int hitNum;
    //文章标题
    private String title;
    //页面文章编码
    private String charset;
    //页面内容大小
    private int fileSize;
    //页面摘要
    private String abstractText;
    //页面描述
    private String description;
    //最近修改时间
    private Timestamp lastlyUpdateTime;
    //过期时间
    private Timestamp ExpirationTime;
    //页面类型
    private String type;
    //层级深度
    private int layer = -1;
    //父节点
    private CrawUrl parent;
    //子链接
    private List<CrawUrl> child;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getUrlNo() {
        return urlNo;
    }

    public void setUrlNo(int urlNo) {
        this.urlNo = urlNo;
    }

    public String getUrlMd5() {
        return urlMd5;
    }

    public void setUrlMd5(String urlMd5) {
        this.urlMd5 = urlMd5;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getHitNum() {
        return hitNum;
    }

    public void setHitNum(int hitNum) {
        this.hitNum = hitNum;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCharset() {
        return charset;
    }

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public String getAbstractText() {
        return abstractText;
    }

    public void setAbstractText(String abstractText) {
        this.abstractText = abstractText;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getLastlyUpdateTime() {
        return lastlyUpdateTime;
    }

    public void setLastlyUpdateTime(Timestamp lastlyUpdateTime) {
        this.lastlyUpdateTime = lastlyUpdateTime;
    }

    public Timestamp getExpirationTime() {
        return ExpirationTime;
    }

    public void setExpirationTime(Timestamp expirationTime) {
        ExpirationTime = expirationTime;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public CrawUrl getParent() {
        return parent;
    }

    public void setParent(CrawUrl parent) {
        this.parent = parent;
    }

    public List<CrawUrl> getChild() {
        return child == null ? new ArrayList<CrawUrl>() : child;
    }

    public void setChild(List<CrawUrl> child) {
        this.child = child;
    }

}
