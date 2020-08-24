package cn.jt.tool;

import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;


public class FreemarkTest {
	
	
	@Test
    public void test() throws Exception {

        //1.创建一个 Configuration 对象， 参数是freemarker 的版本号
        Configuration configuration = new Configuration();

        //2.设置模板文件所在的路径
        configuration.setClassForTemplateLoading(FreemarkTest.class, "/templates");

        //3. 设置模板文件使用的字符集
        configuration.setDefaultEncoding("utf-8");

        //4. 获取模板
        Template template = configuration.getTemplate("test.ftl");

        //5. 创建一个模板使用的数据集，可以是 pojo 也可以是 map；一般是 Map
        Map<String, Object> map = new HashMap<>();
        map.put("name", "安莉莉");
        map.put("message", "hello nice to meet you !");

        //6. 创建一个 Writer 对象，一般创建 FileWriter 对象，指定生成的文件名
        FileWriter fileWriter = new FileWriter("D:/java/workspace/freemarkprj/page/test.html");

        //7. 调用模板对象的 process 方法输出文件
        template.process(map, fileWriter);

        //8. 关闭流
        fileWriter.close();


    }

}
