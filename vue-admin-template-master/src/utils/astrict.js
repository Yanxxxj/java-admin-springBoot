// 引入路由和storage工具函数
import stroage from '@/utils/stroage'
import router from "@/router/index"
import { Message } from 'element-ui'

let lastTime = new Date().getTime()
let currentTime = new Date().getTime()
let timeOut = 60 * 100 //设置超时时间: 30分钟

window.onload= function () {
  console.log("9")
  window.document.onmousedown= function () {
    console.log("10")

    stroage.setItem("lastTime", new Date().getTime())
  }
};

function checkTimeout() {
  currentTime = new Date().getTime()     //更新当前时间
  lastTime = stroage.getItem("lastTime");

  if (currentTime - lastTime > timeOut) { //判断是否超时
    // 清除storage的数据(登陆信息和token)
    // 跳到登陆页
    if(router.currentRoute.name == 'login'){
      return // 当前已经是登陆页时不做跳转
    } else{
     // window.alert('用户账户已过期，请重新登陆')
      Message({
        message: '用户账户已过期，请重新登陆',
        type: 'warning',
      })
      stroage.clear()
      router.push({name: 'login' })
    }
}}

export default function () {
  /* 定时器 间隔30秒检测是否长时间未操作页面 */
  window.setInterval(checkTimeout, 300000);
}
