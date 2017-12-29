package cn.thinkbam.dubbo.demo.provider;

import cn.thinkbam.dubbo.demo.api.DemoService;

/**
 * 提供服务
 */
public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
