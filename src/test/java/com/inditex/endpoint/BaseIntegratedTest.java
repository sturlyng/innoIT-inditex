package com.inditex.endpoint;

import com.inditex.endpoint.boot.EndpointBoot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@SpringBootTest(webEnvironment = RANDOM_PORT, classes = EndpointBoot.class)
@AutoConfigureMockMvc
public abstract class BaseIntegratedTest extends BaseTest {

    private static final String BASE_URL = "http://localhost:%s%s";

    @LocalServerPort
    private int port;

    @Autowired
    protected TestRestTemplate restTemplate;

    @Autowired
    protected MockMvc mockMvc;

    public final String getServiceUrlFor(String relativePath) {
        return String.format(BASE_URL, port, relativePath);
    }

}
