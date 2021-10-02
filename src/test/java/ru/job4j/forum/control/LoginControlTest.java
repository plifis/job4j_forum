package ru.job4j.forum.control;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.job4j.forum.Main;
import ru.job4j.forum.service.PostService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class LoginControlTest {
    @Autowired
    MockMvc mockMvc;

    @Test
    @WithMockUser
    public void shouldReturnErrorLogin() throws Exception {
        this.mockMvc.perform(get("/login").param("error", "login_error"))
                .andExpect(MockMvcResultMatchers.model()
                                        .attribute("errorMessage", "Username or Password is incorrect !!"));
    }


}
