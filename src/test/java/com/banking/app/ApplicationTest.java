package com.banking.app;

import com.banking.app.dto.CustomerInfo;
import com.banking.app.dto.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@AutoConfigureMockMvc
@SpringBootTest
public class ApplicationTest {

    @Autowired
    MockMvc mockMvc;

    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    public void testGetProductsWithNoProductsAdded() throws Exception {
        CustomerInfo customerInfo = new CustomerInfo(30000.0, 28, false);
        MvcResult result = mockMvc.perform(get("/product/myProducts").param("income", String.valueOf(30000.0)).
                        param("age", String.valueOf(28)).param("isStudent", String.valueOf(false)).
                        contentType("application/json"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertEquals(result.getResponse().getContentLength(), 0); // no products added
    }

    @Test
    public void testAddProduct() throws Exception {
        String requestBody = objectMapper.writeValueAsString(new Product("1","2"));;
        mockMvc.perform(post("/product/addProduct").content(requestBody).contentType("application/json"))
                .andDo(print()).andExpect(status().isOk());
    }

    @Test
    public void testGetProducts() throws Exception {

        String requestBody = objectMapper.writeValueAsString(new Product("Credit Card","2"));;
        mockMvc.perform(post("/product/addProduct").content(requestBody).contentType("application/json"))
                .andDo(print()).andExpect(status().isOk());

        CustomerInfo customerInfo = new CustomerInfo(30000.0, 28, false);
        MvcResult result = mockMvc.perform(get("/product/myProducts").param("income", String.valueOf(30000.0)).
                        param("age", String.valueOf(28)).param("isStudent", String.valueOf(false)).
                        contentType("application/json"))
                .andDo(print()).andExpect(status().isOk()).andReturn();
        Assert.assertNotEquals(result.getResponse().getContentAsString().length(), 0); // no products added
    }
}
