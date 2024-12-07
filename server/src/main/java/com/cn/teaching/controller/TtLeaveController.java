package com.cn.teaching.controller;


import com.cn.teaching.entity.TtLeave;
import com.cn.teaching.service.TtLeaveService;
import com.cn.teaching.utils.page.PageResult;
import com.cn.teaching.utils.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 请销假信息 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/tt-leave")
public class TtLeaveController {


    @Autowired
    private TtLeaveService ttLeaveService;

    /**
     * 分页条件查询
     * @param page   当前页码
     * @param limit 每页的大小
     * @param data 封装查询条件数据
     * @return
     */
    @PostMapping("pageQuery/{page}/{limit}")
    public R getPageData(
            @PathVariable int page,
            @PathVariable int limit,
            @RequestBody TtLeave data){
        PageResult pageResult = ttLeaveService.pageQuery(page, limit, data);
        return R.ok().data("rows",pageResult);
    }

    /**
     * 审核操作
     * @param data
     * @return
     */
    @PutMapping("update")
    public R update(@RequestBody TtLeave data){
        ttLeaveService.updateById(data);
        return R.ok();
    }


    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("deleteById/{id}")
    public R deleteById(@PathVariable String id){
        ttLeaveService.removeById(id);
        return R.ok();
    }
}

