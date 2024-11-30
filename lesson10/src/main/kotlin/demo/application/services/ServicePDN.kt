package demo.application.services

import demo.application.dto.User
import org.springframework.stereotype.Service
import kotlin.math.max

@Service
class ServicePDN {

    fun getPDN(user: User, monthlyPayment: Long) : Long {
        val existMonthlyPayment = user.loans.filterNot {
            it.isClose
        }.sumOf { it.monthlyPayment }

        val totalMonthlyPayment = existMonthlyPayment + monthlyPayment

        // Если суммарный месячный платеж не может составлять больше трети дохода
        return user.income / 3 - totalMonthlyPayment
    }
}