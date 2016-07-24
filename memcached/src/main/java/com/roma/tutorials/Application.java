package com.roma.tutorials;

import com.roma.tutorials.memcached.SpyMemcachedClient;
import net.spy.memcached.MemcachedClient;

import java.util.concurrent.Future;

/**
 * Created by Roma on 2016/7/24 0024.
 */
public class Application {

    public static void main(String[] args) {
        MemcachedClient mc = SpyMemcachedClient.getMClient();

        // 1. Set the text, setting a timeout of 3 seconds
        Future f = mc.set("key", 3, "Hello Memcached！");
        try {
            System.out.println("The memcached server state is: " + f.get());
            // Thread.sleep(3000);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        // 2. Get the text
        Object o = mc.get("key");
        System.out.println("the store value is: " + o.toString());

        // 3. Close the client
        mc.shutdown();
    }
}
