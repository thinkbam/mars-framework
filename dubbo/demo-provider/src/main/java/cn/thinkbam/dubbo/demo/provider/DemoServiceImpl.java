package cn.thinkbam.dubbo.demo.provider;

import cn.thinkbam.dubbo.demo.api.DemoService;

public class DemoServiceImpl implements DemoService {
    @Override
    public String sayHello(String name) {
        return "Hello " + name;
    }
}
