package br.com.victor.utilmanager.services

import br.com.victor.utilmanager.controller.EmailRequest
import br.com.victor.utilmanager.domain.EmailEntity
import br.com.victor.utilmanager.repositories.EmailRepository
import org.springframework.core.env.Environment
import org.springframework.stereotype.Service
import java.time.LocalDateTime
import java.util.*
import java.util.logging.Logger
import javax.mail.*
import javax.mail.internet.InternetAddress
import javax.mail.internet.MimeMessage


@Service
class EmailService(private val emailRepository: EmailRepository,
                    private val environment: Environment) {

    private val log: Logger = Logger.getAnonymousLogger()

    fun sendEmail(request:EmailRequest){
        var email = EmailEntity()
        email.dateCreated = LocalDateTime.now()
        email.message = request.message
        email.emailSubject = request.subject
        email.emailAddress = request.emailTo
        email.sented = 0

        var emailSaved = emailRepository.save(email)

        val msg: Message = MimeMessage(getSession())
        msg.setFrom(InternetAddress(environment.getProperty("email.login"), false))

        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(request.emailTo))
        msg.setSubject(request.subject)
        msg.setText(request.message)
        try {
            log.info("sending email...")
            Transport.send(msg)
            log.info("Email sented!")
            emailSaved.sented = 1
            emailSaved.dateSented = LocalDateTime.now()
            emailRepository.save(emailSaved)
        } catch (e:Exception) {
            log.severe("Error sending email")
            throw e
        }

    }

    private fun getProperties():Properties {
        val props = Properties()
        props.put("mail.smtp.auth", "true")
        props.put("mail.smtp.starttls.enable", "true")
        props.put("mail.smtp.host", "smtp.gmail.com")
        props.put("mail.smtp.port", "587")
        return props
    }

    private fun getSession():Session {
        val session: Session = Session.getInstance(getProperties(), object : Authenticator() {
            override fun getPasswordAuthentication(): PasswordAuthentication {
                return PasswordAuthentication(environment.getProperty("email.login"), environment.getProperty("email.senha"))
            }
        })
        return session
    }
}