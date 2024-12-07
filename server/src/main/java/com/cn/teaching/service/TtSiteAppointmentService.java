package com.cn.teaching.service;

import com.cn.teaching.entity.TtSiteAppointment;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 场地预约信息 服务类
 * </p>
 */
public interface TtSiteAppointmentService extends IService<TtSiteAppointment> {

    boolean getBySiteIdAndUserId(String id, String userId);

    void cancelAppointmentSite(TtSiteAppointment ttSiteAppointment);

    List<TtSiteAppointment> getSiteAppointmentInfo(String id, String status);
}
