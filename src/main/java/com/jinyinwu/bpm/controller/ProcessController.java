package com.jinyinwu.bpm.controller;

import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by wangkun23 on 2017/4/9.
 */
@Controller
@RequestMapping("/process")
public class ProcessController {

    private static Logger logger = LoggerFactory.getLogger(ProcessController.class);


    @Resource
    private TaskService taskService;

    /**
     * 我的任务列表
     *
     * @param request
     * @param response
     * @param model
     * @return
     */
    @RequestMapping("/task")
    public String index(HttpServletRequest request, HttpServletResponse response, Model model) {
        List<Task> tasks = taskService.createTaskQuery().taskAssignee("huyang").list();
        model.addAttribute("tasks",tasks);
        return "task";
    }
}
