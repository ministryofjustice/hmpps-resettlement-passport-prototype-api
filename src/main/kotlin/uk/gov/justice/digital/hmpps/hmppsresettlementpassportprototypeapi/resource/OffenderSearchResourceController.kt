package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.resource

import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.config.ErrorResponse
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data.prisonapi.OffenderSearchPrisoner
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.service.OffenderSearchApiService

@RestController
@Validated
@RequestMapping("/hmpps", produces = [MediaType.APPLICATION_JSON_VALUE])
class OffenderSearchResourceController(
  private val offenderSearchService: OffenderSearchApiService,
) {

  @GetMapping("/prison/{prisonId}/prisoners")
  @Operation(summary = "Get all prisoners by search term", description = "All prisoners data based on search term")
  @ApiResponses(
    value = [
      ApiResponse(
        responseCode = "200",
        description = "Successful Operation",
      ),
      ApiResponse(
        responseCode = "401",
        description = "Unauthorized to access this endpoint",
        content = [Content(mediaType = "application/json", schema = Schema(implementation = ErrorResponse::class))],
      ),
    ],
  )
  suspend fun getPrisonerbyTerm(
    @PathVariable
    prisonId: String,
    @RequestBody
    @Parameter
    term: String,
    @Parameter
    page: Int,
    @Parameter
    size: Int,
    @Parameter
    sort: String,
  ): List<OffenderSearchPrisoner> = offenderSearchService.getPrisonersByTerm(prisonId, term, page, size, sort)
}
