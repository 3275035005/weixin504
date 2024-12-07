var call = require("../../utils/request.js")
var help = require("../../utils/help.js")

Page({

    data: {
        siteList:[],
    },
    onLoad: function () {
        this.getSiteByCategoryId('');
     },

     // 根据分类查询所有预约课程
     getSiteByCategoryId(id){
        call.getData('wx/getSite' , this.onSuccessSiteAll, this.onFaiSiteAll);
     },

     onSuccessSiteAll(res) {
      if(res.code == 20000){
        this.setData({
          siteList:res.data.row
      })
    } 
    },
  
    onFaiSiteAll() {
      help.show("网络请求失败");
    },


})