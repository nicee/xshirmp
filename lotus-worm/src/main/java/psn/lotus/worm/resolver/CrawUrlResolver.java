package psn.lotus.worm.resolver;

import psn.lotus.worm.CrawUrl;

import java.util.List;

/**
 * @project lotus
 * @time 2016/10/27 17:09
 */
public class CrawUrlResolver extends AbstractResponseBodyResolver {

    private static final String HREF_INDEX_PATTERN = "[hH][rR][eE][fF]=['\"]?([^'\"]*)['\"]?";

    public CrawUrlResolver() {
        super(HREF_INDEX_PATTERN);
    }

    public CrawUrl urlResolve() throws Exception {
        List<String> urlList = super.resolve();
        CrawUrl crawUrl = null;

        if (!urlList.isEmpty()) {
            crawUrl = new CrawUrl();
            List<CrawUrl> crawUrls = crawUrl.getChild();
            for (String url : urlList) {
                CrawUrl child = new CrawUrl();
                child.setUrl(url);
                child.setParent(crawUrl);
                crawUrls.add(child);
            }
            crawUrl.setChild(crawUrls);
        }

        return crawUrl;
    }

}
