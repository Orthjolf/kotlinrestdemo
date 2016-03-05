package ru.finnetrolle.kotlindemo.restful

import org.glassfish.jersey.server.ResourceConfig
import org.springframework.stereotype.Component

/**
 * Created by maxsyachin on 05.03.16.
 */

@Component
open class JerseyConfig: ResourceConfig {

    constructor() {
        packages(JerseyConfig::class.java.`package`.name)
    }

}