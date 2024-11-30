package demo.application.services

import demo.application.dto.User
import demo.application.util.SyntheticUserGenerator
import org.springframework.stereotype.Service
import kotlin.math.max
import demo.application.client.CrmClient

@Service
class ServiceCalc (
    private val crmClient: CrmClient,
    private val syntheticUserGenerator: SyntheticUserGenerator,
    private val servicePDN: ServicePDN
) {

    fun simpleScore(userId: String, monthlyPayment: Long): Long {
        val user: User = if (System.getenv("environment") == "Test") {
            syntheticUserGenerator.generateUser()
        } else {
            crmClient.getUserById(userId)
        }

        return servicePDN.getPDN(user, monthlyPayment)
    }
}