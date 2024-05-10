package SpringCglib;

//没有业务接口，单独的唱歌功能实现
public class SuperSatZhou {
    @NotNullOrThrow(message = "返回值不能为空")
    public void sing() {
        System.out.println("周润发正在唱歌");
    }
    public void xizao() {
        System.out.println("周润发在洗澡");
    }
    public Integer getNumber() {
        System.out.println("周润发获取数字");
        return 1;
    }
}