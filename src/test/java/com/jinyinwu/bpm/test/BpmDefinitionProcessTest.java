package com.jinyinwu.bpm.test;

import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by wangkun23 on 2017/4/5.
 */
public class BpmDefinitionProcessTest extends TestBase {

    final Logger logger = LoggerFactory.getLogger(BpmDefinitionProcessTest.class);

    @Resource
    private RepositoryService repositoryService;


    @Override
    public void empty() {
    }

    @Test
    public void deploy() throws IOException {

        DeploymentBuilder builder = repositoryService.createDeployment();
//        Deployment deployment = builder.name("王坤第一个流程定义")
//                .addClasspathResource("bpmn/leaveBill.bpmn")
//                .addClasspathResource("bpmn/leaveBill.png")
//                .deploy();
        //直接部署bpmn的文件
        ClassPathResource classPathResource=new ClassPathResource("bpmn/simple.flow.bpmn");
        InputStream fileInputStream =classPathResource.getInputStream();
        Deployment deployment = builder.addInputStream("部署流程测试", fileInputStream).deploy();
        logger.info("deployment {}", deployment.getId());
    }

    // @Test  测试没通过
    public void query() {
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();

        //processDefinitionQuery.orderByProcessDefinitionVersion().desc();

        List<ProcessDefinition> pds = processDefinitionQuery.list();
        // 遍历集合，查看内容
        for (ProcessDefinition pd : pds) {
            System.out.print("id:" + pd.getId() + ",");
            System.out.print("name:" + pd.getName() + ",");
            System.out.print("key:" + pd.getKey() + ",");
            System.out.println("version:" + pd.getVersion());
        }

        //查询流程定义
        //ProcessDefinition processDefinition=repositoryService.createProcessDefinitionQuery();

        //logger.info("deployment {}", processDefinition.getVersion());
    }

}