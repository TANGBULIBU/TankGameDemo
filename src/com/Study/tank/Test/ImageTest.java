package com.Study.tank.Test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author 鸡腿子
 * @version 1.0
 */
 class ImageTest {//测试类
    @Test
    void test(){
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\壁纸\\新建文件夹\\Win11.png"));//读取目录下的图片文件
            assertNotNull(image);//文件不是空 测试通过

        } catch (IOException e) {
            e.printStackTrace();
        }

        //fail("Not yet implemented");//测试失败
        //Assertions 断言
        //assertNotNull(new Object());//测试里面内容不是空值
    }
}
