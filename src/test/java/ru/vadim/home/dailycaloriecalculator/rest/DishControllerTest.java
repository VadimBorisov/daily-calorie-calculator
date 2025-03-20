package ru.vadim.home.dailycaloriecalculator.rest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static uk.org.webcompere.modelassert.json.JsonAssertions.assertJson;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class DishControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JsonFileReader jsonFileReader;

    @Test
    void addDishShouldSuccess() throws Exception {

        String request = jsonFileReader.readJsonFromFile("rest/dishAddSuccessRequest.json");

        MvcResult result = mockMvc.perform(post("/calories-calculator/api/dish/add")
                        .content(request)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expected = jsonFileReader.readJsonFromFile("rest/dishAddSuccessResponse.json");

        assertJson(actualResponse).where().keysInAnyOrder().arrayInAnyOrder().isEqualTo(expected);
    }

    @Test
    void addDishShouldReturnErrorWhenNameIsBlank() throws Exception {
        String request = jsonFileReader.readJsonFromFile("rest/dishAddEmptyNameRequest.json");;

        MvcResult result = mockMvc.perform(post("/calories-calculator/api/dish/add")
                    .content(request)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expected = jsonFileReader.readJsonFromFile("rest/dishAddEmptyNameResponse.json");

        assertJson(actualResponse).where().keysInAnyOrder().arrayInAnyOrder().isEqualTo(expected);
    }
}