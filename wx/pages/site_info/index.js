var call = require("../../utils/request.js")
var help = require("../../utils/help.js")
var userId = '';
var siteId = '';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    itme: {},
  },

  onLoad: function (options) {
    const { id } = options;
    siteId = id
    this.getInit();

  },
  /**
   * 获取登录用户信息
   */
  getInit() {
    userId = wx.getStorageSync("token")
    // 用户信息不存在跳转登录页面
    if (userId == null || userId == undefined || userId == '') {
      // 跳转到登录页面
      wx.reLaunch({
        url: '/pages/login/index'
      })
    } else {
      this.getInfo();
    }
  },

  getInfo() {
    call.getData('wx/getSiteById?id=' + siteId + "&userId=" + userId, this.onSuccessclassAll, this.onFaiclassAll);
  },
  onSuccessclassAll(res) {
    if (res.code == 20000) {
      this.setData({
        item: res.data.row
      })
      console.log(this.data.item);
    }
  },
  onFaiclassAll() {
    help.show("网络请求失败");
  },

  // 预约课程
  appointmentSiteBtn() {
    call.request('wx/appointmentSite', {
      siteId: siteId,
      userId: userId
    }, this.onSuccessappointmentSiteBtn, this.onFaiappointmentSiteBtn);
  },
  onSuccessappointmentSiteBtn(res) {
    if (res.code == 20000) {
      help.show("预约场地成功");
      this.getInfo();
    } else {
      help.show(res.message);
    }
  },
  onFaiappointmentSiteBtn() {
    help.show("网络请求失败");
  },

  //取消预约 
  cancelAppointmentSiteBtn() {
    call.request('wx/cancelAppointmentSite', {
      siteId: siteId,
      userId: userId
    }, this.onSuccesscancelAppointmentSiteBtn, this.onFaicancelAppointmentSiteBtn);
  },
  onSuccesscancelAppointmentSiteBtn(res) {
    if (res.code == 20000) {
      help.show("取消预约成功");
      this.getInfo();
    } else {
      help.show(res.message);
    }
  },
  onFaicancelAppointmentSiteBtn() {
    help.show("网络请求失败");
  },
})