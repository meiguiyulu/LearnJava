package com.lyj.controller;

import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
public class VerifyController {

    @Autowired
    private Producer producer;

    @RequestMapping("/vc.jpg")
    public void verifyCode(HttpServletResponse response, HttpSession session) throws IOException {
        // 1. 生成验证码
        String text = producer.createText();
        // 2. 保存到session中
        session.setAttribute("kaptcha", text);
        // 3. 生成图片
        BufferedImage image = producer.createImage(text);
        // 4. 响应图片
        response.setHeader("Cache-Control",
                "no-store, no-cache");
        response.setContentType("image/ipeg");
        ServletOutputStream outputStream = response.getOutputStream();
        ImageIO.write(image, "jpg", outputStream);

    }

}
