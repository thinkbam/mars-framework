package cn.thinkbam.castor.util;

import cn.thinkbam.castor.vo.FieldVO;
import cn.thinkbam.castor.vo.MessageConfigurationVO;
import org.exolab.castor.mapping.Mapping;
import org.exolab.castor.xml.MarshalException;
import org.exolab.castor.xml.Marshaller;
import org.exolab.castor.xml.Unmarshaller;
import org.exolab.castor.xml.ValidationException;
import org.xml.sax.InputSource;

import java.io.*;

public class OxMapper {
    public static void main(String[] args) throws Exception {
//        marshallerByMapping();
        unmarshallerByMapping();
    }


    /**
     * 按照自定义mapping配置，编组JavaObject(javaObject->XML)
     *
     * @throws Exception
     */
    private static String marshallerByMapping() throws Exception {
        //加载自定义xml映射文件
        Mapping mapping = new Mapping();
        String url = "F:\\Workspaces\\idea\\mars-framework\\castor-oxmapping\\src\\main\\java\\cn\\thinkbam\\castor\\oxmapping\\message.xml";
        mapping.loadMapping(url);

        StringWriter writer = new StringWriter();
        MessageConfigurationVO message = new MessageConfigurationVO();
        message.setName("报文名称");
        message.setCode("报文编码");
        message.setService("Service名称");
        message.setMethod("Method名称");
        FieldVO[] input = new FieldVO[3];
        for (int i = 0; i < 3; i++) {
            FieldVO vo = new FieldVO();
            vo.setName("FieldName" + i);
            vo.setValue(i);
            input[i] = vo;
        }
        message.setInput(input);

        Marshaller marshaller = new Marshaller(writer);
        //按照自定义xml映射文件，将javaObject转换成XML
        marshaller.setMapping(mapping);
        marshaller.marshal(message);
        //按照自定义的xml映射文件生成xml文档
        System.out.println("writer = " + writer);
        return writer.toString();
    }

    /**
     * 解组XML（XML->javaObject）
     */
    private static void unmarshallerByMapping() throws Exception {
        String xml =
                "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" +
                "<request name=\"报文名称1\" code=\"报文编码\" method=\"Method名称\">" +
                        "<service>Service名称</service>" +
                        "<input>" +
                            "<field name=\"FieldName0\" value=\"0\"/>" +
                            "<field name=\"FieldName1\" value=\"1\"/>" +
                            "<field name=\"FieldName2\" value=\"2\"/>" +
                        "</input>" +
                "</request>";
//        String xml = marshallerByMapping();
       StringReader reader = new StringReader(xml);

       //加载自定义xml映射文件
        Mapping mapping = new Mapping();
        String url = "F:\\Workspaces\\idea\\mars-framework\\castor-oxmapping\\src\\main\\java\\cn\\thinkbam\\castor\\oxmapping\\message.xml";
        mapping.loadMapping(url);

        Unmarshaller unmarshaller = new Unmarshaller(mapping);
       MessageConfigurationVO message = (MessageConfigurationVO) unmarshaller.unmarshal(new InputSource(reader));
        System.out.println("message = " + message);
    }


    /**
     * Castor默认 编组javaObject (javaObject->XML)
     *
     * @throws IOException
     * @throws MarshalException
     * @throws ValidationException
     */
    private static void marshaller() throws Exception {
        MessageConfigurationVO message = new MessageConfigurationVO();
        message.setName("报文名称");
        message.setCode("报文编码");
        message.setService("Service名称");
        message.setMethod("Method名称");

        //使用Castor默认行为进行映射
        FileWriter writer = new FileWriter("./mapping.xml");
        Marshaller marshaller = new Marshaller(writer);
        marshaller.setEncoding("UTF-8");
        marshaller.marshal(message);
    }

    /**
     * Castorm默认 解组xml（XML->javaObject）
     *
     * @throws FileNotFoundException
     * @throws MarshalException
     * @throws ValidationException
     */
    private static void unmarshal() throws Exception {
        FileReader reader = new FileReader("./mapping.xml");
        MessageConfigurationVO message = (MessageConfigurationVO) Unmarshaller.unmarshal(MessageConfigurationVO.class, reader);
        System.out.println("message = " + message);
    }
}
