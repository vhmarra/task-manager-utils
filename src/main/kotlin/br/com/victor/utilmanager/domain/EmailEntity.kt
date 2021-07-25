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
    var message: String? = null

    @Column(name = "email_subject")
    var emailSubject: String? = null

    @Column(name = "email_address")
    var emailAddress: String? = null

    @Column(name = "date_created")
    var dateCreated: LocalDateTime? = null

    @Column(name = "date_sented")
    var dateSented: LocalDateTime? = null

    @Column(name = "sented")
    var sented: Int? = null

}