package demo.application.services

import demo.application.dto.CreditApplication
import org.springframework.stereotype.Service

@Service
class ServiceScore(
    private val servicePDN: ServicePDN
) {

    fun simpleScore(creditApplication: CreditApplication): Boolean {
        if (creditApplication.user.age < 18) {
            return false
        }

        return servicePDN.getPDN(creditApplication.user, creditApplication.monthlyPayment) > 0
    }
}
