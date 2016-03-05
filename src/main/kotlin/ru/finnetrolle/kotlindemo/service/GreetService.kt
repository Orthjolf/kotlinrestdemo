package ru.finnetrolle.kotlindemo.service

import com.sun.net.httpserver.Authenticator
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.finnetrolle.kotlindemo.model.User
import ru.finnetrolle.kotlindemo.model.UserRepository

/**
 * Created by maxsyachin on 05.03.16.
 */

@Component
open class GreetService @Autowired constructor (val userRepo: UserRepository) {

    interface Resp {
        class Success(val greeting: String, val count: Int): Resp
        class SuccessNew(val greeting: String): Resp
    }

    fun greet(name: String): Resp {
        val user = userRepo.findOne(name)
        if (user == null) {
            val newUser = User(name, 0)
            userRepo.save(newUser)
            return Resp.SuccessNew("Welcome to our land, ${name}")
        } else {
            user.greets += 1
            userRepo.save(user)
            return Resp.Success("Hello again, ${user.name}!", user.greets)
        }
    }

}