package br.com.victor.utilmanager.controller

import br.com.victor.utilmanager.services.EmailService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("email")
class EmailController(private val emailService: EmailService) {

    @PostMapping
    @Deprecated("This method doesnt work anymore beacuse google deactive de smtp without auth",ReplaceWith(""),DeprecationLevel.WARNING)
    fun sendEmail(request: EmailRequest) : ResponseEntity<Void> {
        emailService.sendEmail(request)
        return ResponseEntity.status(HttpStatus.MOVED_TEMPORARILY).build()
    }


}