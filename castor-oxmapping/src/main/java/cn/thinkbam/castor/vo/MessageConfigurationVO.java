package cn.thinkbam.castor.vo;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Map;

/**
 * 报文配置对象
 * @author Thinkbam
 * @version 1.0
 * @see java.io.Serializable
 */
public class MessageConfigurationVO implements Serializable{
    /**
     * 报文名称
     */
    private String name;
    /**
     * 报文编码
     */
    private String code;
    /**
     * 服务名称
     */
    private String service;
    /**
     * 原子方法名称
     */
    private String method;

    private FieldVO[] input;

    public FieldVO[] getInput() {
        return input;
    }

    public void setInput(FieldVO[] input) {
        this.input = input;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String toString() {
        return "MessageConfigurationVO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", service='" + service + '\'' +
                ", method='" + method + '\'' +
                ", input=" + Arrays.toString(input) +
                '}';
    }
}
