package ru.finnetrolle.kotlindemo.restful

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import ru.finnetrolle.kotlindemo.service.GreetService
import java.util.*
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.PathParam
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

/**
 * Created by maxsyachin on 05.03.16.
 */

@Component
@Path("greet/{name}")
open class GreetResource @Autowired constructor (val service: GreetService) {

    data class Greet(val message: String, val count: Int)
    data class Welcome(val message: String)

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    fun greet(@PathParam("name") name: String): Response {
        val resp = service.greet(name)

        return when(resp) {
            is GreetService.Resp.Success -> Response.ok(Greet(resp.greeting, resp.count)).build()
            is GreetService.Resp.SuccessNew -> Response.ok(Welcome(resp.greeting)).build()
            else -> Response.status(Response.Status.INTERNAL_SERVER_ERROR).build()
        }
    }

}