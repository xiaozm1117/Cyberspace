package cn.jt.controller

import org.apache.ibatis.javassist.expr.NewArray
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.http.converter.json.MappingJacksonValue
import org.springframework.stereotype.Controller
import org.springframework.util.StringUtils
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController

import cn.jt.pojo.Admin
import cn.jt.pojo.Result
import cn.jt.service.LoginRegisterService

@RestController
class LoginRegister {
    @Autowired
    private val redisTemplate: RedisTemplate<*, *>? = null
    @Autowired
    private val loginRegisterService: LoginRegisterService? = null

    @RequestMapping("/loginRegister/register")
    fun regiester(@RequestBody admin: Admin) {
        loginRegisterService!!.register(admin)
    }

    @RequestMapping("/loginRegister/login")
    fun login(@RequestBody admin: Admin): String {
        return loginRegisterService!!.login(admin)

    }

    @RequestMapping("/loginRegister/checkname")
    fun checkname(@RequestParam name: String) {
        loginRegisterService!!.checkname(name)
    }

    //通过ticket获取用户信息
    @RequestMapping("/query/{ticket}")
    @ResponseBody
    fun findUserByTicket(@PathVariable ticket: String, callback: String): MappingJacksonValue {

        var jacksonValue: MappingJacksonValue? = null
        try {
            val userJSON = redisTemplate!!.opsForValue().get(ticket) as String

            if (!StringUtils.isEmpty(userJSON)) {
                /**
                 * 问题:是否需要将userJSON转化为user对象返回??
                 * 答:不需要 因为页面js解析时已经处理了
                 * var _data = JSON.parse(data.data);
                 */
                jacksonValue = MappingJacksonValue(Result(userJSON))
                jacksonValue.jsonpFunction = callback
                return jacksonValue
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        jacksonValue = MappingJacksonValue(Result("fail"))
        jacksonValue.jsonpFunction = callback
        return jacksonValue
    }
}
