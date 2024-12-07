package com.cn.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cn.teaching.entity.TtLeave;
import com.cn.teaching.mapper.TtLeaveMapper;
import com.cn.teaching.service.TtLeaveService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cn.teaching.utils.page.PageResult;
import com.cn.teaching.utils.utils.AceUtils;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 请销假信息 服务实现类
 * </p>
 */
@Service
public class TtLeaveServiceImpl extends ServiceImpl<TtLeaveMapper, TtLeave> implements TtLeaveService {

    @Override
    public PageResult pageQuery(int page, int limit, TtLeave data) {
        List<TtLeave> queryList = baseMapper.pageQuery(data);
        PageHelper.startPage(page, limit);
        PageInfo<TtLeave> pageInfo = new PageInfo<>(queryList);
        return new PageResult<>(pageInfo.getTotal(), queryList);
    }

    @Override
    public List<TtLeave> getLeaveByLeaveIdAndType(String id, String type) {

        QueryWrapper<TtLeave> qw = new QueryWrapper<>();
        LambdaQueryWrapper<TtLeave> lambda = qw.lambda();
        lambda.eq(TtLeave::getUserId, id);
        if(!StringUtils.isEmpty(type)){
            lambda.eq(TtLeave::getType, type);
        }
        return baseMapper.selectList(qw);
    }
}
