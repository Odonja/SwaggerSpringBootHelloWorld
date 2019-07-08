package com.anneke.SpringBootHelloWorld.Resources;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HelloWorldResource.class)
public class HelloWorldResourceTest {

    @Autowired
    private MockMvc mockMvc;

    // als dependency injection  dan een @MockBean

    @Test
    public void getHelloWorldString() throws Exception {
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/rest/helloworld")
                .accept(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();

        System.out.println("----\n" + result.getResponse().getContentAsString() + "\n----");
        String expected = "Hello World";
        assertEquals(expected, result.getResponse().getContentAsString());
      //  JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
    }

    @Test
    public void personalizedHello() throws Exception{
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/hello/tester")
                .accept(MediaType.APPLICATION_JSON)
                .content("have a good day")
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(response);
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

}
