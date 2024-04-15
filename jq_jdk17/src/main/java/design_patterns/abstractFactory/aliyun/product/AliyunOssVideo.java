package design_patterns.abstractFactory.aliyun.product;

import design_patterns.abstractFactory.factory.product.OssVideo;

/**
 * @Description
 * @Date 2024/4/8 11:45
 */
public class AliyunOssVideo implements OssVideo {
    private byte[] bytes;

    public AliyunOssVideo(byte[] bytes,String watermark) {
        this.bytes = bytes;
        System.out.println("[阿里云】视频已上传至阿里云oS8,URL:http://oss,aliyun.com/XXXXXX×,pg");
        System.out.println("[可里云】已生成缩略图，码率5000k");
        System.out.println("[阿里云】已为图片新增水印，码率7000k");
    }

    @Override
    public String get720P() {
        return "AliyunOssVideo.720";
    }

    @Override
    public String get1080P() {
        return "AliyunOssVideo.1080";
    }
}
