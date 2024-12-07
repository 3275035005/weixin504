package com.cn.teaching.mapper;

import com.cn.teaching.entity.TtSiteAppointment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 场地预约信息 Mapper 接口
 * </p>
 */
public interface TtSiteAppointmentMapper extends BaseMapper<TtSiteAppointment> {

    List<TtSiteAppointment> getSiteAppointmentInfo(@Param("userId") String id,@Param("status")  String status);

}
