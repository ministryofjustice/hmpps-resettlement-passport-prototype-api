package uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.service

import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.awaitBody
import uk.gov.justice.digital.hmpps.hmppsresettlementpassportprototypeapi.data.prisonapi.OffenderSearchPrisoner

@Service
class OffenderSearchApiService(
  private val offenderSearchWebClient: WebClient,
) {

  suspend fun getPrisonersByTerm(prisonId: String, term: String, page: Int, size: Int, sort: String): List<OffenderSearchPrisoner> {
    return offenderSearchWebClient
      .get()
      .uri("/prison/{id}/prisoners?term=" + term + "&page=" + page + "&size=" + size + "&sort=" + sort)
      .retrieve()
      .awaitBody()
  }
}
