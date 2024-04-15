package design_patterns.abstractFactory.factory.product;

/**
 * @Description
 * @Date 2024/4/8 10:43
 */
public interface OssImage {
    //缩略图
    public String getThumb();
    //水印
    public String getWatermark();
    //ai方法
    public String getEnhance();
}
