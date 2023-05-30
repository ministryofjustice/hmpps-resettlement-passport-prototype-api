package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data

import com.fasterxml.jackson.annotation.JsonInclude
import com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL
import io.swagger.v3.oas.annotations.media.Schema

@JsonInclude(NON_NULL)
@Schema(description = "Prison Information")
data class PrisonDto(
  @Schema(description = "Prison ID", example = "MDI", required = true) val prisonId: String,
  @Schema(description = "Name of the prison", example = "Moorland HMP", required = true) val prisonName: String,
  @Schema(description = "Whether the prison is still active", required = true) val active: Boolean,
  @Schema(description = "Whether the prison has male prisoners") val male: Boolean,
  @Schema(description = "Whether the prison has female prisoners") val female: Boolean,
  @Schema(description = "Whether the prison is contracted") val contracted: Boolean,
  // @Schema(description = "List of types for this prison") val types: List<PrisonTypeDto> = listOf(),
  // @Schema(description = "List of address for this prison") val addresses: List<AddressDto> = listOf(),
  // @Schema(description = "List of operators for this prison") val operators: List<PrisonOperatorDto> = listOf(),
) {
  constructor(prison: PrisonDto) : this(
    prison.prisonId,
    prison.prisonName,
    prison.active,
    prison.male,
    prison.female,
    prison.contracted,
    // prison.prisonTypes.map { PrisonTypeDto(it) },
    // prison.addresses.map { AddressDto(it) },
    // prison.prisonOperators.map { PrisonOperatorDto(it) },
  )
}
