package psn.lotus.worm;

import java.util.List;

/**
 * @project lotus
 * @time 2016/10/27 14:37
 */
public interface FrontCrawler {

    List<CrawUrl> getChildren() throws Exception;

}
