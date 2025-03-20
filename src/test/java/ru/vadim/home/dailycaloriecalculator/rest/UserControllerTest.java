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
class UserControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private JsonFileReader jsonFileReader;

    private static final String BASE_URL = "/calories-calculator/api/user/add";

    @Test
    void addUserShouldSuccess() throws Exception {
        String request = jsonFileReader.readJsonFromFile("rest/addUserSuccessRequest.json");

        MvcResult result = mockMvc.perform(post(BASE_URL)
                .content(request)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expected = jsonFileReader.readJsonFromFile("rest/addUserSuccessResponse.json");

        assertJson(actualResponse).where().keysInAnyOrder().arrayInAnyOrder().isEqualTo(expected);
    }

    @Test
    void shouldReturnErrorWhenEmailExists() throws Exception {
        String request = jsonFileReader.readJsonFromFile("rest/addUserWithExistsEmailRequest.json");

        MvcResult result = mockMvc.perform(post(BASE_URL)
                        .content(request)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expected = jsonFileReader.readJsonFromFile("rest/addUserWithExistsEmailResponse.json");

        assertJson(actualResponse).where().keysInAnyOrder().arrayInAnyOrder().isEqualTo(expected);
    }

    @Test
    void shouldReturnErrorWhenNameIsBlank() throws Exception {
        String request = jsonFileReader.readJsonFromFile("rest/addUserWithEmptyNameRequest.json");

        MvcResult result = mockMvc.perform(post(BASE_URL)
                        .content(request)
                        .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andReturn();

        String actualResponse = result.getResponse().getContentAsString();
        String expected = jsonFileReader.readJsonFromFile("rest/addUserWithEmptyNameResponse.json");

        assertJson(actualResponse).where().keysInAnyOrder().arrayInAnyOrder().isEqualTo(expected);
    }
}