package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data.prisonapi

data class Prison(
  val prisonId: String,
  val prisonName: String,
  val active: Boolean,
  val male: Boolean,
  val female: Boolean,
  val contracted: Boolean,
  val types: List<PrisonType> = listOf(),
  val addresses: List<Address> = listOf(),
  val operators: List<PrisonOperator> = listOf(),
)

data class Address(
  val id: Long,
  val addressLine1: String?,
  val addressLine2: String?,
  val town: String,
  val county: String?,
  val postcode: String,
  val country: String,

)

data class PrisonType (
  val code: String,
  val description: String,

)

data class PrisonOperator(
  val name: String,
)