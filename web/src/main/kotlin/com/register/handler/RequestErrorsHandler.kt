package com.register.handler

import com.register.user.dto.ErrorsDTO
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Component
import org.springframework.validation.BindingResult

@Component
class RequestErrorsHandler {

    fun getErrors(result: BindingResult): ResponseEntity<ErrorsDTO> {
        val errors = result.allErrors.map { it.defaultMessage }

        return ResponseEntity.status(404).body<ErrorsDTO>(ErrorsDTO(errors))
    }
}
