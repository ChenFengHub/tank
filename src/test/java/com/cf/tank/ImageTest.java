package com.cf.tank;


import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

/**
 * @program: design-pattern-tank
 * @description: 类功能描述
 * @author: Mr.CF
 * @create: 2022-08-13 04:04:04
 */
public class ImageTest {

    @Test
    public void test() throws IOException {
//        fail("fail");
//        BufferedImage image = ImageIO.read(new File("F:/xxxx"));
//        assertNotNull(image);

        BufferedImage image2 = ImageIO.read(ImageTest.class.getClassLoader().getResourceAsStream("images/0.gif"));
        assertNotNull(image2);
    }

}
