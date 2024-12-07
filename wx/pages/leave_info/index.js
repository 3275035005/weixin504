var call = require("../../utils/request.js")
var help = require("../../utils/help.js")
var userId = '';
Page({

  /**
   * 页面的初始数据
   */
  data: {

    type: '',
    reason:'',
    startTime: '请选择开始日期',
    endTime: '请选择截止日期',
  },
  onLoad: function (options) {
    const { id } = options;
    this.setData({
      type: id
    })
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
    }
  },

  // 修改
  updateInfo() {
    if (this.data.startTime == "" ||this.data.startTime == "请选择开始日期" ) {
      wx.showToast({
        title: '请选择开始日期',
        icon: 'none',
        duration: 1000
      })
      return false;
    }
    if (this.data.endTime == "" || this.data.endTime == "请选择截止日期") {
      wx.showToast({
        title: '请选择截止日期',
        icon: 'none',
        duration: 1000
      })
      return false;
    }
    wx.showLoading({
      title: '提交中...'
    });
    call.request('wx/sendLeave', {
      userId: userId,
      type: this.data.type,
      startTime: this.data.startTime,
      endTime: this.data.endTime,
      reason: this.data.reason
    }, this.onSuccess, this.onFail);
  },

  onSuccess(res) {
    wx.hideLoading();
    if (res.code == 20000) {
      help.show("提交成功")
      setTimeout(function () { // 下单成功跳转页面
        wx.reLaunch({
          url: '/pages/leave/index'
        })
      }, 2000)

    } else {
      help.show(res.msg)
    }
  },

  	// 开始时间
	startTimeChange(e){
		this.setData({
			startTime : e.detail.value
		})
  },
  
  // 截止时间
  endTimeChange(e){
		this.setData({
      endTime : e.detail.value
		})
  },

  onFail() {
    wx.hideLoading();
    help.show("网络请求超时,请稍后再试")
  }
})