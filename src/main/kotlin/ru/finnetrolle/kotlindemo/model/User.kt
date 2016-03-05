package ru.finnetrolle.kotlindemo.model

import org.springframework.data.repository.CrudRepository
import javax.persistence.Entity
import javax.persistence.Id


/**
 * Created by maxsyachin on 05.03.16.
 */

interface UserRepository: CrudRepository<User, String>

@Entity(name = "users")
data class User(
        @Id
        var name: String = "",
        var greets: Int = 0)

