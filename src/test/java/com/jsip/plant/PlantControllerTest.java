package com.jsip.plant;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlantController.class)
class PlantControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getPlants() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/all");
        MvcResult result = mvc.perform(request).andReturn();
        System.out.println(result.getResponse().getContentAsString());
    }

    @Test
    void addNewPlants() {
    }
}