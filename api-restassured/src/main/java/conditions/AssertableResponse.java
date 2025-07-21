package conditions;

import io.qameta.allure.Step;
import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
@Getter
public class AssertableResponse {
    private Response response;

    @Step("Api response shouldHave {condition}")
    public AssertableResponse shouldHave(Condition condition){
        log.info("About to check condition {}", condition);
        condition.check(response);
        return this;
    }

    @Step
    public AssertableResponse shouldHave(Condition... condition){
        for (Condition cond : condition) {
            cond.check(response);
        }
        return this;
    }
}
