package com.cn.teaching.service;

import com.cn.teaching.entity.TtSite;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.teaching.utils.page.PageResult;

/**
 * <p>
 * 场地信息 服务类
 * </p>
 */
public interface TtSiteService extends IService<TtSite> {

    PageResult pageQuery(int page, int limit, TtSite data);

}
