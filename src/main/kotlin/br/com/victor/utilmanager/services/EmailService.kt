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
    @Deprecated("This method doesnt work anymore beacuse google deactive de smtp without auth",ReplaceWith(""),DeprecationLevel.WARNING)
    fun sendEmail(request:EmailRequest){
        var email = EmailEntity()
        email.dateCreated = LocalDateTime.now()
        email.message = request.message
        email.emailSubject = request.subject
        email.emailAddress = request.emailTo
        email.sented = 0

        var emailSaved = emailRepository.save(email)
        try {
            log.warning("this method is deprecated, but the entity still will be persisted on db")
            //Transport.send(msg)
        } catch (e:Exception) {
            log.severe("Error sending email")
            throw e
        }

    }
}