package com.Study.tank.Test;

import org.junit.jupiter.api.Test;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author ������
 * @version 1.0
 */
 class ImageTest {//������
    @Test
    void test(){
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\asus\\Desktop\\��ֽ\\�½��ļ���\\Win11.png"));//��ȡĿ¼�µ�ͼƬ�ļ�
            assertNotNull(image);//�ļ����ǿ� ����ͨ��

        } catch (IOException e) {
            e.printStackTrace();
        }

        //fail("Not yet implemented");//����ʧ��
        //Assertions ����
        //assertNotNull(new Object());//�����������ݲ��ǿ�ֵ
    }
}
