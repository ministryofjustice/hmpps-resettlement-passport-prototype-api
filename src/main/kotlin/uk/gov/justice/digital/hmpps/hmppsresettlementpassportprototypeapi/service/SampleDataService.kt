package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.service

import org.springframework.stereotype.Service
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data.SampleDataDTO
import java.time.LocalDateTime

@Service
class SampleDataService(
  //private val readinessProfileRepository: ReadinessProfileRepository
) {

  fun getSampleData(sampleId: String): SampleDataDTO {
    val sampleDataDTO: SampleDataDTO = SampleDataDTO(sampleId, LocalDateTime.now(), "Data Generated as " + sampleId + " requested @ " + LocalDateTime.now() );
    return sampleDataDTO;
  }
}