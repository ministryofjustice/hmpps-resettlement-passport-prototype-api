package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.resource

import org.springframework.http.MediaType
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data.SampleDataDTO
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.service.SampleDataService

@Validated
@RestController
@RequestMapping("/prototype", produces = [MediaType.APPLICATION_JSON_VALUE])
class SampleResourceController(
  private val sampleDataService: SampleDataService,
) {

  @GetMapping("/getData/{sampleId}")
  fun getSampleData(
    @PathVariable sampleId: String,
  ): SampleDataDTO {
    return sampleDataService.getSampleData(sampleId)
  }
}
