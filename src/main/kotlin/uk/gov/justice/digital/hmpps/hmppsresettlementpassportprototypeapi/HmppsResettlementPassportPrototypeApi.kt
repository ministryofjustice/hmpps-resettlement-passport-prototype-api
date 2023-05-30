package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

/**
 * Used as the system oauth username when calling HMPPS apis
 * as well as the "audit module" for creating records in prison-api
 */
const val SYSTEM_USERNAME = "RESETTLEMENT_PASSPORT_API"

@SpringBootApplication()
class HmppsResettlementPassportPrototypeApi

fun main(args: Array<String>) {
  runApplication<HmppsResettlementPassportPrototypeApi>(*args)
}
