package design_patterns.decorator;

import java.io.FileOutputStream;

/**
 * @program: Boot3
 * @description:
 * @author:
 * @create: 2024-03-08 13:48
 **/
public class Client {
    public static void main(String[] args) {
        String msg="1.txt";
        FileDataSource fileDataSource = new FileDataSource(msg);
        fileDataSource.writeData("abcds");
        String s = fileDataSource.readData();
        System.out.println(s);
        System.out.println("----------------");
        EncryptionDecorator encryptionDecorator = new EncryptionDecorator(new FileDataSource(msg));
        encryptionDecorator.writeData("abcds");
        System.out.println(encryptionDecorator.readData());

    }

}
