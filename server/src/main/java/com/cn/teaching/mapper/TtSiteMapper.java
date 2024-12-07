package com.cn.teaching.mapper;

import com.cn.teaching.entity.TtSite;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 场地信息 Mapper 接口
 * </p>
 */
public interface TtSiteMapper extends BaseMapper<TtSite> {

    List<TtSite> pageQuery(TtSite data);
}
