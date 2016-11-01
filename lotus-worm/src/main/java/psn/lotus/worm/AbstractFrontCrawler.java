package psn.lotus.worm;

import org.springframework.util.Assert;

import java.util.List;

/**
 * @project lotus
 * @time 2016/10/27 14:40
 */
public abstract class AbstractFrontCrawler implements FrontCrawler {

    private final CrawUrl root;

    public AbstractFrontCrawler(String url) {
        this.root = new CrawUrl();
        root.setUrl(url);
    }

    public AbstractFrontCrawler(CrawUrl root) {
        Assert.notNull(root, "The root of url could not be null.");
        this.root = root;
    }

    public List<CrawUrl> getChildren() throws Exception {
        return root.getChild();
    }

}
