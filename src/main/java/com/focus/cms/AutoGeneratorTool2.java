package com.focus.cms;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;

public class AutoGeneratorTool2 {

  public static void main(String[] args) {



  }


  public static String parseHtmlFile(String temDir, String fileName, String targetFileName, Map<String, Object> paramMap) {
    boolean delete = false;
    if (delete) {
      File d = new File(targetFileName);
      if (d.exists()) {
        d.delete();
      }
      return "";
    }

    try {
      // 创建一个合适的Configration对象
      Configuration configuration = new Configuration();
      configuration.setDirectoryForTemplateLoading(new File(temDir));
      configuration.setObjectWrapper(new DefaultObjectWrapper());
      configuration.setDefaultEncoding("UTF-8");
      // 获取或创建一个模版。
      Template template = configuration.getTemplate(fileName);
      Writer writer = new OutputStreamWriter(new FileOutputStream(targetFileName), "UTF-8");
      template.process(paramMap, writer);
    } catch (Exception e) {
      e.printStackTrace();
    }
    return "OK";
  }

}
