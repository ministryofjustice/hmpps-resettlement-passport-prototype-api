package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.config

import jakarta.validation.ValidationException
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.BAD_REQUEST
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class HmppsResettlementPassportPrototypeApiExceptionHandler {
  @ExceptionHandler(ValidationException::class)
  fun handleValidationException(e: Exception): ResponseEntity<ErrorResponse> {
    log.info("Validation exception: {}", e.message)
    return ResponseEntity
      .status(BAD_REQUEST)
      .body(
        ErrorResponse(
          status = BAD_REQUEST,
          userMessage = "Validation failure: ${e.message}",
          developerMessage = e.message,
        ),
      )
  }

  @ExceptionHandler(java.lang.Exception::class)
  fun handleException(e: java.lang.Exception): ResponseEntity<ErrorResponse?>? {
    log.error("Unexpected exception", e)
    return ResponseEntity
      .status(INTERNAL_SERVER_ERROR)
      .body(
        ErrorResponse(
          status = INTERNAL_SERVER_ERROR,
          userMessage = "Unexpected error: ${e.message}",
          developerMessage = e.message,
        ),
      )
  }

  companion object {
    private val log = LoggerFactory.getLogger(this::class.java)
  }
}

/**
 * Codes that can be used by api clients to uniquely discriminate between error types,
 * instead of relying on non-constant text descriptions.
 *
 * NB: Once defined, the values must not be changed
 */
enum class ErrorCode(val errorCode: Int) {
  IncentiveLevelActiveIfRequired(100),
  IncentiveLevelActiveIfActiveInPrison(101),
  IncentiveLevelCodeNotUnique(102),
  IncentiveLevelReorderNeedsFullSet(103),

  PrisonIncentiveLevelActiveIfRequired(200),
  PrisonIncentiveLevelActiveIfDefault(201),
  PrisonIncentiveLevelActiveIfPrisonersExist(202),
  PrisonIncentiveLevelNotGloballyActive(203),
  PrisonIncentiveLevelDefaultRequired(204),
}

data class ErrorResponse(
  val status: Int,
  val errorCode: Int? = null,
  val userMessage: String? = null,
  val developerMessage: String? = null,
  val moreInfo: String? = null,
) {
  constructor(
    status: HttpStatus,
    errorCode: Int? = null,
    userMessage: String? = null,
    developerMessage: String? = null,
    moreInfo: String? = null,
  ) :
    this(status.value(), errorCode, userMessage, developerMessage, moreInfo)
}
