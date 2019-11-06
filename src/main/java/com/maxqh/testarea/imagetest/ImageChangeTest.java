package com.maxqh.testarea.imagetest;

import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;

/**
 * @Author:qianhao
 * @Description: 图片合成及写字
 * @Date:2018/7/30
 * @Version:1.0
 */
public class ImageChangeTest {
    public static void main(String[] args) throws Exception {
        // 图片合成
        Long start = System.currentTimeMillis();
        ClassPathResource classPathResource = new ClassPathResource("img/bg_v2.jpg");
        classPathResource.getInputStream();
        // BufferedImage bg = ImageIO.read(new
        // URL("http://kano.guahao.com/btz13703015"));//读取互联网图片
        BufferedImage bg = ImageIO.read(classPathResource.getInputStream());

        BufferedImage img = new BufferedImage(bg.getWidth(), bg.getHeight(), BufferedImage.TYPE_INT_RGB);// 创建图片
        BufferedImage logo = null;
        if(Boolean.TRUE){
            logo = ImageIO.read(new URL("https://kano.guahao.cn/ea32654767_image140.jpg"));// 读取互联网图片;
        }else {
            logo = ImageIO.read(new URL("https://kano.guahao.cn/pYf27810846"));
        }
        int cornerRadius = logo.getWidth() / 4;
        logo = makeRoundedCorner(logo, cornerRadius);

        Graphics g = img.getGraphics();// 开启画图
        g.drawImage(bg, 0, 0, null);
        g.drawImage(logo.getScaledInstance(150, 150, Image.SCALE_AREA_AVERAGING), 65, 35, null);

        String name = "胡海";
        String department = "呼吸科";
        String hospital = "浙江省立同德医院";
        String hospitalLong = "山东省高密市阚家镇卫生院(高密市双羊镇高戈庄卫生院)";
        hospital = hospitalLong;
        // 写字
        g.setColor(new Color(33, 33, 33));
        g.setFont(new Font("Lantinghei SC", Font.PLAIN, 40));
        g.drawString(name + " " + department, 255, 85);

        g.setColor(new Color(99, 99, 99));
        g.setFont(new Font("Lantinghei SC", Font.PLAIN, 32));
        for (int i = 0; i * 14 < hospital.length(); i++) {
            int startSub = i * 14;
            int endSub = ((i + 1) * 14 > hospital.length() ? hospital.length() : (i + 1) * 14);
            g.drawString(hospital.substring(startSub, endSub), 255, 135 + i * 35);
        }

        g.dispose();

        ImageIO.write(img, "jpg", new File("/Users/qianhao/Downloads/new.jpg"));
        Long end = System.currentTimeMillis();

        System.out.println("RT:" + (end - start));
    }

    /**
     * 生成圆角图标
     * 
     * @author Master.Pan
     * @param image
     * @param cornerRadius 圆角半径
     * @return
     */
    public static BufferedImage makeRoundedCorner(BufferedImage image, int cornerRadius) {
        int w = image.getWidth();
        int h = image.getHeight();
        BufferedImage output = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g2 = output.createGraphics();
        g2.setComposite(AlphaComposite.Src);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(Color.WHITE);
        g2.fill(new RoundRectangle2D.Float(0, 0, w, h, cornerRadius, cornerRadius));
        g2.setComposite(AlphaComposite.SrcAtop);
        g2.drawImage(image, 0, 0, null);
        g2.dispose();
        return output;
    }
}
