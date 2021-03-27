package com.example.controller;

import com.example.common.Result;
import com.example.document.Activity;
import com.example.document.EsStudent;
import com.example.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/25 11:18
 * @Version 1.0
 */
@Controller
@RequestMapping("activity")
public class ActivityController {

    @Autowired
    private ActivityService activityService;

    @GetMapping("/importAll")
    @ResponseBody
    public Result<Integer> importAll() {
        int count = activityService.importAll();
        return Result.success(count);
    }

    @GetMapping("/search")
    @ResponseBody
    public Result<Page<Activity>> search(@RequestParam(required = false) String keyword, @RequestParam(required = false, defaultValue = "0") Integer pageNum, @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<Activity> activitiePage = activityService.search(keyword, pageNum, pageSize);
        return Result.success(activitiePage);
    }
}
