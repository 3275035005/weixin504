package com.cn.teaching.service.impl;

import com.cn.teaching.entity.TtSite;
import com.cn.teaching.mapper.TtSiteMapper;
import com.cn.teaching.service.TtSiteService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.teaching.utils.page.PageResult;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 场地信息 服务实现类
 * </p>
 */
@Service
public class TtSiteServiceImpl extends ServiceImpl<TtSiteMapper, TtSite> implements TtSiteService {

    @Override
    public PageResult pageQuery(int page, int limit, TtSite data) {
        List<TtSite> queryList = baseMapper.pageQuery(data);
        PageHelper.startPage(page, limit);
        PageInfo<TtSite> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }
}
