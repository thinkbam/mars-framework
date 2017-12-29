package cn.thinkbam.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Dubbo测试
 */
public class DemoServiceTest {

    /**
     * 启动Dubbo提供者服务
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/dubbo-demo-provider.xml"}
        );
        context.start();
        System.out.println("Dubbo Provider启动....");
        System.in.read();
    }
}
