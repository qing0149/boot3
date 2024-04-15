package design_patterns.abstractFactory.qiniu;

import design_patterns.abstractFactory.factory.AbstractOssFactory;
import design_patterns.abstractFactory.factory.product.OssImage;
import design_patterns.abstractFactory.factory.product.OssVideo;

/**
 * @Description
 * @Date 2024/4/8 10:48
 */
public class QiniuOssFactory implements AbstractOssFactory {

    @Override
    public OssImage uploadImage(Byte[] bytes) {
        return null;
    }

    @Override
    public OssVideo uploadVideo(Byte[] bytes) {
        return null;
    }
}
