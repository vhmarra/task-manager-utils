package br.com.victor.utilmanager.controller

import com.fasterxml.jackson.annotation.JsonProperty

data class EmailRequest(
    var message: String,
    var subject: String,
    @JsonProperty (value = "email-to")var emailTo: String

    )
