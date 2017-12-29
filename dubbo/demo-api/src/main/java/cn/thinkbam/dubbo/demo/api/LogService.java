package cn.thinkbam.dubbo.demo.api;

public interface LogService {

    Object getLogs(String id);

    int addLog(Object log);
}
