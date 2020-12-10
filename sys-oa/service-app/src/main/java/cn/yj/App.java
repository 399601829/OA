package cn.yj;

import cn.yj.activity.web.modeler.ModelSaveRestResource;
import cn.yj.aop.EnableAopLog;
import cn.yj.params.check.EnableCheckMethodParams;
import cn.yj.tools.readconfig.EnableReadConfig;
import org.activiti.rest.editor.main.StencilsetRestResource;
import org.activiti.rest.editor.model.ModelEditorJsonRestResource;
import org.activiti.spring.boot.DataSourceProcessEngineAutoConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

/**
 * <br>
 *
 * @author 永健
 * @since 2020-11-28 20:54
 */

// 扫描 activiti-modeler-5.22.0.jar 的Controller;不用自定义重写
@SpringBootApplication(
        exclude = {
                org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
                , org.activiti.spring.boot.SecurityAutoConfiguration.class
        })

// 开启activity
@Import(value = {DataSourceProcessEngineAutoConfiguration.class, ModelSaveRestResource.class, ModelEditorJsonRestResource.class, StencilsetRestResource.class})

@MapperScan("cn.yj.user.mapper")
@EnableReadConfig(classLoader = App.class)
@EnableAopLog(targetPackage = "cn.yj")
@EnableCheckMethodParams(targetPackage = "com.example.demo.core.service")
//@EnableAutoForwardGeneration(entityPackages = "cn.yj.user.entity.po", OnOff = false)
//@EnableGlobalException
public class App
{
    public static void main(String[] args)
    {
        SpringApplication.run(App.class, args);
    }
}
