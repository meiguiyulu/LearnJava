package com.lyj.controller;

import com.google.code.kaptcha.Producer;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@RestController
public class VerifyController {

    @Autowired
    private Producer producer;

    @RequestMapping("/vc.jpg")
    public String verifyCode(HttpSession session) throws IOException {
        // 1. 生成验证码
        String text = producer.createText();
        // 2. 保存到session中
        session.setAttribute("kaptcha", text);
        // 3. 生成图片
        BufferedImage image = producer.createImage(text);
        FastByteArrayOutputStream fos = new FastByteArrayOutputStream();
        ImageIO.write(image, "jpg", fos);

        // 4. 返回Base64
        return Base64.encodeBase64String(fos.toByteArray());
    }

}
