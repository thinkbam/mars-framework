package cn.thinkba.dubbo.demo.consumer;

import cn.thinkbam.dubbo.demo.api.DemoService;
import cn.thinkbam.dubbo.demo.api.LogService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.UUID;

public class ConsumerTest {

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/dubbo-demo-consumer.xml"});
        context.start();
        System.out.println("Dubbo Consumer已启动...");
        DemoService demoService = (DemoService) context.getBean("demoService");
        String message = demoService.sayHello("阿里巴巴...");
        System.out.println("message = " + message);

        LogService logService = (LogService) context.getBean("logService");
        Object object = logService.getLogs(UUID.randomUUID()+"");
        int count = logService.addLog("xxxxx");
        System.out.println("getLogs>>>>>>>>>>>>>>>>> " + object);
        System.out.println("addLog>>>>>>>>>>>>>>>>> " + count);
        Thread.sleep(100000);
    }
}
