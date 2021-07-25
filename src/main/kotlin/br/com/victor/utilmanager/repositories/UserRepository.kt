package br.com.victor.utilmanager.repositories

import br.com.victor.utilmanager.domain.UserEntity
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<UserEntity,Long> {
}