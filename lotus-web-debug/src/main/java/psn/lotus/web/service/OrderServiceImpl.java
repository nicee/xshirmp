package psn.lotus.web.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @project lotus
 * @time 2017/8/2 14:53
 */
@Service
public class OrderServiceImpl implements OrderService {

    private static final Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    private volatile static Boolean bool = Boolean.TRUE;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public synchronized void order() {
        // params check
        paramsCheck();

        String threadName = Thread.currentThread().getName();
        logger.info("当前线程[name={}]准备执行创建订单...", threadName);

        if (existItems()) {
            logger.info("当前线程[name={}]购物车存在商品...", threadName);
            // real create order
            create();
            cleanItems();
        } else {
            logger.info("当前线程[name={}]购物车不存在商品, 无需执行订单过程...", threadName);
            throw new IllegalAccessError("无订单商品不能创建订单");
        }

        logger.info("当前线程[name={}]购物车订单创建完毕...", threadName);
    }

    private void paramsCheck() {
        logger.info("params check success.");
    }

    private boolean existItems() {
        String threadName = Thread.currentThread().getName();
        logger.info("当前线程[name={}]正在检查购物车商品...", threadName);
        return bool;
    }

    private void cleanItems() {
        String threadName = Thread.currentThread().getName();
        logger.info("当前线程[name={}]清空购物车商品...", threadName);

        bool = Boolean.FALSE;
    }

    private void create() {
//        logger.warn("throw one exception to interrupt order process");
//        throw new NullPointerException("ignore this exception created deliberate");

        String threadName = Thread.currentThread().getName();
        logger.info("当前线程[name={}]创建订单中...", threadName);
    }

}
