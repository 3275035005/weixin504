package com.cn.teaching.mapper;

import com.cn.teaching.entity.TtLeave;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 请销假信息 Mapper 接口
 * </p>
 */
public interface TtLeaveMapper extends BaseMapper<TtLeave> {

    List<TtLeave> pageQuery(TtLeave data);
}
