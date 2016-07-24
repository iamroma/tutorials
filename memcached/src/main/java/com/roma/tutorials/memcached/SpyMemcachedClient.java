package com.roma.tutorials.memcached;

import net.spy.memcached.AddrUtil;
import net.spy.memcached.BinaryConnectionFactory;
import net.spy.memcached.MemcachedClient;

/**
 * Created by Administrator on 2016/7/24 0024.
 */
public class SpyMemcachedClient {

    public static MemcachedClient mc = null;

    public static MemcachedClient getMClient() {
        if (mc != null) {
            return mc;
        }
        // Connect using the binary protocol
        try {
            mc = new MemcachedClient(new BinaryConnectionFactory(),
                    AddrUtil.getAddresses("127.0.0.1:11211"));
        } catch (Exception ex) {
            mc.shutdown();
            ex.printStackTrace();
        }
        return mc;
    }
}
