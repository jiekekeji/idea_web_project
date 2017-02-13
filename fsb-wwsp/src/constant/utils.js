import md5 from 'js-md5'

var utils = {
  /**
   * Created by Administrator on 2017/2/7.
   */
  setDocumentTitle: function setDocumentTitle(title) {
    "use strict";
    //以下代码可以解决以上问题，不依赖jq
    setTimeout(function () {
      //利用iframe的onload事件刷新页面
      document.title = title;
      var iframe = document.createElement('iframe');
      iframe.src = '../../static/public/logo.png'; // 必须
      iframe.style.visibility = 'hidden';
      iframe.style.width = '1px';
      iframe.style.height = '1px';
      iframe.onload = function () {
        setTimeout(function () {
          document.body.removeChild(iframe);
        }, 0);
      };
      document.body.appendChild(iframe);
    }, 0);
  },

  /**
   * 生成一个 0 - 1000 之间的随机整数
   * @returns {Number}
   */
  getRandom: function () {
    return parseInt(1000 * Math.random());
  },

  /**
   *
   * @param userid
   * @param random
   * @param userkey
   * @param userid
   * @param random
   * @param userkey
   */
  getRandomkey: function (userid, random, userkey) {
    let content = ''+userid + random + userkey + userid + random + userkey;
    console.log('content=' + content)
    return md5(content);
  },

  /**
   * 保存登陆成功后返回的userid
   * @param userid
   */
  setUserid: function (userid) {
    sessionStorage.setItem('userid', userid);
  },

  /**
   * 返回保存的userid
   */
  getUserid: function () {
    return sessionStorage.getItem('userid');
  },

  /**
   *保存登陆成功后返回的userkey
   * @param userkey
   */
  setUserkey: function (userkey) {
    sessionStorage.setItem('userkey', userkey);
  },

  /**
   * 返回保存的userkey
   */
  getUserkey: function () {
    return sessionStorage.getItem('userkey');
  },

  /**
   * 用户是否已登陆，如果已经存在userid和userkey
   * 说明用户已登陆，否则未登陆
   */
  isUserLogin: function () {
    if (isEmpty(getUserid()) || isEmpty(getUserkey())) {
      return false;
    }
    return true;
  },

  /**
   * 判断是否为空
   * @param text
   * @returns {boolean}
   */
  isEmpty: function (text) {
    if (typeof(text) === undefined || null === text || '' === text) {
      return true;
    }
    return false;
  }

}

export {utils};
