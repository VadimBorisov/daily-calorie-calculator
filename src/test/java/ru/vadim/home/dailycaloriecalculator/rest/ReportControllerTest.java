package ru.vadim.home.dailycaloriecalculator.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class ReportControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JsonFileReader jsonFileReader;

    @Test
    void getDailySummaryShouldSuccess() throws Exception {
        MvcResult result = mockMvc.perform(get("/calories-calculator/api/report/1/19-03-2025"))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expected = jsonFileReader.readJsonFromFile("rest/dailyCalorieReportResponse.json");

        assertJson(actualResponse).where().keysInAnyOrder().arrayInAnyOrder().isEqualTo(expected);
    }
}