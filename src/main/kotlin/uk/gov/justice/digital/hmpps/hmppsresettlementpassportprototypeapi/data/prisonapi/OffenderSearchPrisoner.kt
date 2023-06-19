package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data.prisonapi

import java.time.LocalDate

data class OffenderSearchPrisoner(
  val bookingId: Long,
  val prisonerNumber: String,
  val dateOfBirth: LocalDate,
  val receptionDate: LocalDate,
  val firstName: String,
  val middleNames: String? = null,
  val lastName: String,
  val prisonId: String,
  val alerts: List<PrisonerAlert> = emptyList(),
)

data class OffenderSearchPrisonerList(
  val content: List<OffenderSearchPrisoner>,
  val totalElements: Int,
  val last: Boolean,
)

data class PrisonerAlert(
  val alertType: String,
  val alertCode: String,
  val active: Boolean,
  val expired: Boolean,
) {
  companion object {
    const val ACCT_ALERT_CODE = "HA"
  }
}
