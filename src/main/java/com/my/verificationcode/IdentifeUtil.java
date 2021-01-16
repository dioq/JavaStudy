package com.my.verificationcode;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import net.sourceforge.tess4j.util.LoadLibs;

import java.io.File;

public class IdentifeUtil {

    public static String getImgContent(String imgPath) {
        String content = null;
        File imageFile = new File(imgPath);
        if (!imageFile.exists()) {
            System.out.println("文件不存在");
            return null;
        }
        //读取图片数字
        ITesseract instance = new Tesseract();
        instance.setTessVariable("user_defined_dpi", "300");

        File tessDataFolder = LoadLibs.extractTessResources("tessdata");
        instance.setLanguage("eng");//英文库识别数字比较准确
        instance.setDatapath(tessDataFolder.getAbsolutePath());

        try {
            content = instance.doOCR(imageFile).replace("\n", "");
        } catch (TesseractException e) {
            e.printStackTrace();
        }
        return content;
    }
}
