package com.example.controller;

import com.example.common.Result;
import com.example.document.EsStudent;
import com.example.service.EsStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2020/7/10 10:29
 * @Version 1.0
 */
@Controller
@RequestMapping("esStudent")
public class EsStudentController {
    @Autowired
    private EsStudentService esStudentService;

    @GetMapping("/importAllList")
    @ResponseBody
    public Result<Integer> importAllList() {
        int count = esStudentService.importAll();
        return Result.success(count);
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public Result<Object> delete(@PathVariable Long id) {
        esStudentService.delete(id);
        return Result.success(null);
    }

    @DeleteMapping("/delete/batch")
    @ResponseBody
    public Result<Object> delete(@RequestParam("ids") List<Long> ids) {
        esStudentService.delete(ids);
        return Result.success(null);
    }

    @PostMapping("/create/{id}")
    @ResponseBody
    public Result<EsStudent> create(Long id) {
        EsStudent esStudent = esStudentService.create(id);
        if (esStudent != null) {
            return Result.success(esStudent);
        }
        return Result.failed();
    }

    @GetMapping("/search")
    @ResponseBody
    public Result<Page<EsStudent>> search(@RequestParam(required = false) String keyword, @RequestParam(required = false, defaultValue = "0") Integer pageNum, @RequestParam(required = false, defaultValue = "5") Integer pageSize) {
        Page<EsStudent> esStudentPage = esStudentService.search(keyword, pageNum, pageSize);
        return Result.success(esStudentPage);
    }

}
