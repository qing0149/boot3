package design_patterns.abstractFactory.factory;

import design_patterns.abstractFactory.factory.product.OssImage;
import design_patterns.abstractFactory.factory.product.OssVideo;

/**
 * @Description 工厂是生产产品的使用方法
 * @Date 2024/4/8 10:38
 */
public interface AbstractOssFactory {
    //封装的是产品接口
    public OssImage uploadImage(Byte[] bytes);
    public OssVideo uploadVideo(Byte[] bytes);
}
