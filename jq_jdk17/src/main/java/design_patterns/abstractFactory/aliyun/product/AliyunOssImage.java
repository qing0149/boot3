package design_patterns.abstractFactory.aliyun.product;

import design_patterns.abstractFactory.factory.product.OssImage;

/**
 * @Description
 * @Date 2024/4/8 11:39
 */
public class AliyunOssImage implements OssImage {
    private Byte[] bytes;
    public AliyunOssImage(Byte[] bytes,String watermark,boolean transparent) {
        this.bytes=bytes;
        System.out.println("[阿里云】图片已上传至阿里云oS8,URL:http://oss,aliyun.com/XXXXXX×,pg");
        System.out.println("[可里云】已生成缩略图，尺寸640X480像素");
        System.out.println("[阿里云】已为图片新增水印，水印文本："+watermark+",文木领色：◆aaaaaa,背景透明："+transparent);
        System.out.println("[阿里云】已将图片AI增强为4K极清画质");
    }

    @Override
    public String getThumb() {
        return "[阿里云】图片已上传至阿里云oS8,URL:http://oss,aliyun.com/getThumb×,pg";
    }

    @Override
    public String getWatermark() {
        return "[阿里云】图片已上传至阿里云oS8,URL:http://oss,aliyun.com/getWatermark×,pg";
    }

    @Override
    public String getEnhance() {
        return "[阿里云】图片已上传至阿里云oS8,URL:http://oss,aliyun.com/getEnhance×,pg";
    }
}
