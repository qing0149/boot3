package design_patterns.abstractFactory.aliyun;

import design_patterns.abstractFactory.aliyun.product.AliyunOssImage;
import design_patterns.abstractFactory.factory.AbstractOssFactory;
import design_patterns.abstractFactory.factory.product.OssImage;
import design_patterns.abstractFactory.factory.product.OssVideo;

/**
 * @Description
 * @Date 2024/4/8 10:47
 */
public class AliyunOssFactory implements AbstractOssFactory {

    @Override
    public OssImage uploadImage(Byte[] bytes) {
        return new AliyunOssImage(bytes,"al",true);
    }

    @Override
    public OssVideo uploadVideo(Byte[] bytes) {
        return null;
    }
}
