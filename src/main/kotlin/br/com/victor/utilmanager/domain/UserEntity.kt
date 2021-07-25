package br.com.victor.utilmanager.domain

import java.time.LocalDate
import javax.persistence.*

@Entity
@Table(name = "user")
class UserEntity {

    @Id
    @GeneratedValue
    val id: Long? = null

    @Column(name = "name")
    val name: String? = null

    @Column(name = "email")
    val email: String? = null

    @Column(name = "cpf")
    val cpf: String? = null

    @Column(name = "birth_date")
    val birthDate: LocalDate? = null
}