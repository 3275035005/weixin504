Page({

    /**
     * 页面的初始数据
     */
    data: {},
  
    leaveButton(e){
      let id = e.currentTarget.dataset['index']
      wx.navigateTo({
        url: '/pages/leave_info/index?id='+id // 跳转到目标页面
      })
    },

})