package ru.finnetrolle.kotlindemo.service

import com.sun.net.httpserver.Authenticator
import org.springframework.stereotype.Component

/**
 * Created by maxsyachin on 05.03.16.
 */

@Component
class GreetService {

    interface Resp {
        class Success(val msg: String): Resp
        class Error(): Resp
    }

    fun greet(name: String): Resp {
        return if (name.equals("R21"))
            Resp.Error()
        else
            Resp.Success("Hello, ${name}")
    }

}