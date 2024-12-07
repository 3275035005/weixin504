package com.cn.teaching.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cn.teaching.entity.TtSiteAppointment;
import com.cn.teaching.mapper.TtSiteAppointmentMapper;
import com.cn.teaching.service.TtSiteAppointmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 场地预约信息 服务实现类
 * </p>
 */
@Service
public class TtSiteAppointmentServiceImpl extends ServiceImpl<TtSiteAppointmentMapper, TtSiteAppointment> implements TtSiteAppointmentService {

    @Override
    public boolean getBySiteIdAndUserId(String id, String userId) {
        QueryWrapper<TtSiteAppointment> qw = new QueryWrapper<>();
        LambdaQueryWrapper<TtSiteAppointment> lambda = qw.lambda();
        lambda.eq(TtSiteAppointment::getSiteId, id);
        lambda.eq(TtSiteAppointment::getUserId, userId);
        lambda.eq(TtSiteAppointment::getStatus, "1");
        return baseMapper.selectOne(lambda) != null;
    }

    @Override
    public void cancelAppointmentSite(TtSiteAppointment ttSiteAppointment) {
        UpdateWrapper<TtSiteAppointment> qw = new UpdateWrapper<>();
        LambdaUpdateWrapper<TtSiteAppointment> lambda = qw.lambda()
        .eq(TtSiteAppointment::getSiteId, ttSiteAppointment.getSiteId())
        .eq(TtSiteAppointment::getUserId, ttSiteAppointment.getUserId());

        TtSiteAppointment ttSiteAppointment1 = new TtSiteAppointment();
        ttSiteAppointment1.setStatus("2");

        baseMapper.update(ttSiteAppointment1, lambda);
    }

    @Override
    public List<TtSiteAppointment> getSiteAppointmentInfo(String id, String status) {
        return baseMapper.getSiteAppointmentInfo(id, status);
    }
}
