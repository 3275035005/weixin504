package com.cn.teaching.service;

import com.cn.teaching.entity.TtLeave;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cn.teaching.utils.page.PageResult;

import java.util.List;

/**
 * <p>
 * 请销假信息 服务类
 * </p>
 */
public interface TtLeaveService extends IService<TtLeave> {

    PageResult pageQuery(int page, int limit, TtLeave data);

    List<TtLeave> getLeaveByLeaveIdAndType(String id, String type);

}
