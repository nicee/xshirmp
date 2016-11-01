package psn.lotus.worm.resolver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @project lotus
 * @time 2016/10/27 14:53
 */
public final class ResponseBodyResolverChain {

    private static final Logger LOGGER = LoggerFactory.getLogger(ResponseBodyResolverChain.class);

    private List<ResponseBodyResolver> resolverList;

    private int size = 0;

    private int cursor = -1;

    public ResponseBodyResolverChain(ResponseBodyResolver... resolvers) {
        Assert.notEmpty(resolvers, "The resolver could not be empty");
        CollectionUtils.mergeArrayIntoCollection(resolvers, resolverList);
    }

    public ResponseBodyResolver getResolver() {
        return (++cursor > (size - 1)) ? null : resolverList.get(cursor);
    }

}
