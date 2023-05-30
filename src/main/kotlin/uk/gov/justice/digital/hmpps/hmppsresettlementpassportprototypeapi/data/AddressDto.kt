/*package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data

import io.swagger.v3.oas.annotations.media.Schema

data class AddressDto(
  @Schema(description = "Unique ID of the address", example = "10000", required = true) val id: Long,
  @Schema(description = "Address line 1", example = "Bawtry Road", required = false) val addressLine1: String?,
  @Schema(description = "Address line 2", example = "Hatfield Woodhouse", required = false) val addressLine2: String?,
  @Schema(description = "Village/Town/City", example = "Doncaster", required = true) val town: String,
  @Schema(description = "County", example = "South Yorkshire", required = false) val county: String?,
  @Schema(description = "Postcode", example = "DN7 6BW", required = true) val postcode: String,
  @Schema(description = "Country", example = "England", required = true) val country: String,
) {
  constructor(address: Address) : this(
    address.id!!,
    address.addressLine1,
    address.addressLine2,
    address.town,
    address.county,
    address.postcode,
    address.country,
  )
}
*/
