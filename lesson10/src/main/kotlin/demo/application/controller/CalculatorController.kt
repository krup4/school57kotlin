package demo.application.controller

import demo.application.client.CrmClient
import demo.application.dto.User
import demo.application.services.ServiceCalc
import demo.application.util.SyntheticUserGenerator
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import kotlin.math.max

@Tag(
    name = "Оценка кредитной нагрузки",
    description = "Эти методы вызываются напрямую с фронта, для расчета кредитной нагрузки"
)
@RestController
class CalculatorController(
    val serviceCalc: ServiceCalc
) {


    @GetMapping("/calculate")
    fun simpleScore(
        @RequestParam userId: String,
        @RequestParam monthlyPayment: Long
    ) = serviceCalc.simpleScore(userId, monthlyPayment);
}
