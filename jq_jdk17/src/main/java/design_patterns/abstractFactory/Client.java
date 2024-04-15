package design_patterns.abstractFactory;

import design_patterns.abstractFactory.aliyun.AliyunOssFactory;
import design_patterns.abstractFactory.factory.AbstractOssFactory;

/**
 * @Description
 * @Date 2024/4/8 10:38
 */
public class Client {
    public static void main(String[] args) {
        AbstractOssFactory factory = new AliyunOssFactory();
        factory.uploadImage(new Byte[1024]);
    }
}
