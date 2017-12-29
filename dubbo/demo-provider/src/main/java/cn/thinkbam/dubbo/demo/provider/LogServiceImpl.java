package cn.thinkbam.dubbo.demo.provider;

import cn.thinkbam.dubbo.demo.api.LogService;

import java.util.Random;
import java.util.UUID;

public class LogServiceImpl implements LogService {
    @Override
    public Object getLogs(String id) {
        return "getLogs---->" + UUID.randomUUID();
    }

    @Override
    public int addLog(Object log) {
        return new Random().nextInt(100);
    }
}
