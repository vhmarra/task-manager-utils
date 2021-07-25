package br.com.victor.utilmanager.repositories

import br.com.victor.utilmanager.domain.EmailEntity
import org.springframework.data.jpa.repository.JpaRepository

interface EmailRepository : JpaRepository<EmailEntity,Long> {
}