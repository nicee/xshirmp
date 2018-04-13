package psn.lotus.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

/**
 * 限流测试
 *
 * @project lotus
 * @time 2018/4/12 13:58
 */
public class RateLimiterTest {

    public static void main(String[] args) {
        // 每2秒新增5个令牌
        RateLimiter rateLimiter = RateLimiter.create(5, 2, TimeUnit.SECONDS);
        // 需要消费10个令牌
        System.out.println(rateLimiter.acquire(10));
        System.out.println(rateLimiter.acquire(3));
        System.out.println(rateLimiter.acquire(2));
        System.out.println(rateLimiter.acquire(1));
        System.out.println(rateLimiter.acquire(2));
        System.out.println(rateLimiter.acquire(3));
    }

}
