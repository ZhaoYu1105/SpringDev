package devLib.boot.filter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;

/**
 * 自定义filter中，增加对访问接口的调用次数的记录
 * 
 * @author [miaoyunhai@cmhi.chinamobile.com]
 * @date 2017年8月4日 - 下午5:50:12
 * @history
 *          2017年8月4日 - 下午5:50:12 [miaoyunhai@cmhi.chinamobile.com] create.
 */
@WebFilter(urlPatterns = "/*", filterName = "CounterFilter", initParams = { @WebInitParam(name = "encoding", value = "UTF-8"),
    @WebInitParam(name = "forceEncoding", value = "true") })
public class CounterFilter implements Filter {

    private volatile Thread                       counterThread = null;

    private AtomicLong                            atomicCounter;

    private ConcurrentHashMap<String, AtomicLong> counterMap;
    private ConcurrentHashMap<Long, AtomicLong>   tpsMap;

    private int                                   duration      = 10;

    @Override
    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2) throws IOException, ServletException {
        // 统计tps
        long sec = System.currentTimeMillis() / 1000;
        if (tpsMap.containsKey(sec)) {
            tpsMap.get(sec).incrementAndGet();
        } else {
            tpsMap.put(sec, new AtomicLong(1));
        }
        // System.out.println(sec);

        // 统计每个接口的访问量
        HttpServletRequest request = (HttpServletRequest) arg0;
        String uri = request.getRequestURI();
        if (counterMap.containsKey(uri)) {
            counterMap.get(uri).incrementAndGet();
        } else {
            counterMap.put(uri, new AtomicLong(1));
        }

        atomicCounter.incrementAndGet();
        // System.out.println(String.format("Counter= %d\tPath= %s",
        // atomicCounter.get(),
        // uri));

        arg2.doFilter(arg0, arg1);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        atomicCounter = new AtomicLong(0);
        counterMap = new ConcurrentHashMap<>();
        tpsMap = new ConcurrentHashMap<>();

        if (counterThread == null) {
            counterThread = new Thread() {
                @Override
                public void run() {
                    try {
                        sleep(10000l);
                    } catch (InterruptedException e) {
                    }

                    while (true) {
                        try {
                            // 打印调用次数
                            System.out.println(String.format("***********************total calls： %s", atomicCounter.get()));
                            for (Map.Entry<String, AtomicLong> kv : counterMap.entrySet()) {
                                System.out.println(String.format("Path=%s, calls: %d", kv.getKey(), kv.getValue().get()));
                            }

                            // 打印TPS
                            long sec = System.currentTimeMillis() / 1000;
                            for (Map.Entry<Long, AtomicLong> kv : tpsMap.entrySet()) {
                                if (sec - kv.getKey() > duration) {
                                    tpsMap.remove(kv.getKey());
                                    continue;
                                }

                                System.out.println(String.format("time=%d, calls: %d", kv.getKey(), kv.getValue().get()));
                            }
                        } catch (Exception e) {
                        } finally {
                            try {
                                sleep(10000l);
                            } catch (InterruptedException e) {
                            }
                        }
                    }
                }
            };

            counterThread.start();
        }
    }

}
