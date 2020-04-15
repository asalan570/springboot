package com.wql.educationservice.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wql.educationservice.entity.EduTeacher;
import com.wql.educationservice.entity.vo.TeacherQuery;
import com.wql.educationservice.service.EduTeacherService;
import com.wql.servicebase.config.exceptionhandler.MyException;
import com.wql.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author wql
 * @since 2020-04-13
 */
@Api(description="讲师管理")
@RestController
@RequestMapping("/eduController")
public class EduTeacherController {

    @Autowired
    private EduTeacherService eduTeacherService;

    //查询所有
//    @RequestMapping(value = "/findAll",method = {RequestMethod.GET,RequestMethod.POST})
    @ApiOperation(value = "查询所有")
    @GetMapping("/findAll")
    public R findAll(){
        List<EduTeacher> list = eduTeacherService.list(null);
        return R.ok().data("items",list);
    }

//    @RequestMapping(value = "/delById",method = {RequestMethod.POST})
    @ApiOperation(value = "根据ID删除")
    @DeleteMapping("/delById/{id}")//通过路径拿到传递过来的id
    public R delById(@PathVariable String id){
//        boolean b = eduTeacherService.removeByIds(Arrays.asList("1195337453429129218"));
//        return true;
        boolean b = eduTeacherService.removeById(id);
        if(b){
            return R.ok();
        }else{
            return R.error();
        }

    }

    //分页查询
//    @ApiOperation(value = "分页查询")
//    @GetMapping("/{page}/{limit}")
//    public R pageSelect(
//            @ApiParam(name = "page", value = "当前页码", required = true)
//            @PathVariable Long page,
//            @ApiParam(name = "limit", value = "每页记录数", required = true)
//            @PathVariable Long limit){
//        Page<EduTeacher> objectPage = new Page<>(page, limit);
//        IPage<EduTeacher> page1 = eduTeacherService.page(objectPage, null);
//        long total = objectPage.getTotal();
//        return R.ok().data("total",total).data("rows",page1);
//    }
    //分页查询
    @ApiOperation(value = "分页查询-带参数")
    @PostMapping("/pageSelect/{page}/{limit}")//参数带有注解 requestBody时, 只能用postmapping
    public R pageSelect(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable Long page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable Long limit,
            @RequestBody(required =  false) TeacherQuery teacherQuery){ // required = false 参数可以为空
        //创建page对象
        Page<EduTeacher> objectPage = new Page<>(page, limit);
        //调用传参分页查询service


        //自定义异常处理方法示例
//        try {
//            int i = 10/0;
//        }catch (Exception e){
//            throw  new MyException(20005,"自定义异常处理...");
//        }

//        System.out.println("p:"+page+",l:"+limit);
        eduTeacherService.pageQuery(objectPage,teacherQuery);
        List<EduTeacher> records = objectPage.getRecords();
        long total = objectPage.getTotal();
        return R.ok().data("total",total).data("rows",records);
    }

    /**
     * 添加
     * @param eduTeacher
     * @return
     */
    @PostMapping("/save")
    public R save(@RequestBody EduTeacher eduTeacher){
        boolean save = eduTeacherService.save(eduTeacher);
        if(save){
            return R.ok();
        }else{
            return R.error();
        }
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping("/findById/{id}")
    public R findById(@PathVariable String id){
        EduTeacher byId = eduTeacherService.getById(id);
        return R.ok().data("item",byId);
    }

    /**
     * 根据ID修改
     * @param eduTeacher
     * @return
     */
    @PostMapping("/updateById")
    public R updateById(@RequestBody EduTeacher eduTeacher){
        boolean b = eduTeacherService.updateById(eduTeacher);
        if(b){
            return R.ok();
        }else{
            return R.error();
        }
    }
}

