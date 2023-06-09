package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data

import java.time.LocalDateTime

data class SampleDataDTO(

  var sampleId: String,

  val createdDateTime: LocalDateTime,

  val sampleData: String,
)
