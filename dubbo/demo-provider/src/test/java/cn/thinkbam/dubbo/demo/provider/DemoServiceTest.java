package cn.thinkbam.dubbo.demo.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class DemoServiceTest {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                new String[]{"spring/dubbo-demo-provider.xml"}
        );
        context.start();
        System.out.println("Dubbo Provider启动....");
        System.in.read();
    }
}
