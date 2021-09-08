package kg.TestTask.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kg.TestTask.dao.ResponseObject;
import kg.TestTask.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;


@Controller
public class TaskController {
    @Autowired
    private TaskService taskService;


    //  отправляем запрос
    @GetMapping("/requestCurrency")
    @ResponseBody
    public ResponseObject getCurrency() throws JsonProcessingException {
         return taskService.sendRequest();}

}