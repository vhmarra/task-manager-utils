package br.com.victor.utilmanager.domain

import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "email")
class EmailEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "message")
    val message: String? = null

    @Column(name = "email_subject")
    val emailSubject: String? = null

    @Column(name = "email_address")
    val emailAddress: String? = null

    @Column(name = "date_created")
    val dateCreated: LocalDateTime? = null

    @Column(name = "date_sented")
    val dateSented: LocalDateTime? = null

    @Column(name = "sented")
    val sented: Int? = null

}