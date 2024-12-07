package com.cn.teaching.controller;


import com.cn.teaching.entity.TtSite;
import com.cn.teaching.service.TtSiteService;
import com.cn.teaching.utils.page.PageResult;
import com.cn.teaching.utils.response.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 场地信息 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/tt-site")
public class TtSiteController {

    @Autowired
    private TtSiteService ttSiteService;

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
            @RequestBody TtSite data){
        PageResult pageResult = ttSiteService.pageQuery(page, limit, data);
        return R.ok().data("rows",pageResult);
    }
    /**
     * 修改操作
     * @param data
     * @return
     */
    @PutMapping("update")
    public R update(@RequestBody TtSite data){
        ttSiteService.updateById(data);
        return R.ok();
    }

    /**
     * 新增操作
     * @param data
     * @return
     */
    @PostMapping("insert")
    public R insert(@RequestBody  TtSite data){
        ttSiteService.save(data);
        return R.ok();
    }

    /**
     * 删除操作
     * @param id
     * @return
     */
    @DeleteMapping("deleteById/{id}")
    public R deleteById(@PathVariable String id){
        ttSiteService.removeById(id);
        return R.ok();
    }
}

