package ru.job4j.forum.control;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import ru.job4j.forum.Main;
import ru.job4j.forum.model.Authority;
import ru.job4j.forum.model.User;
import ru.job4j.forum.service.PostService;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;



@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class RegControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    @Test
    @WithMockUser
    public void shouldReturnRegView() throws Exception {
        this.mockMvc.perform(get("/reg"))
                .andExpect(status().isOk())
                .andExpect(view().name("/reg"));
    }

    @Test
    @WithMockUser
    public void shouldReturnLoginView() throws Exception {
        Authority authority = new Authority();
        authority.setAuthority("USER");
        Mockito.when(service.findUserByName("name")).thenReturn(null);
        Mockito.when(service.encode("123")).thenReturn("123");
        Mockito.when(service.findAuthorityByRole("ROLE_USER")).thenReturn(authority);
        this.mockMvc.perform(post("/reg")
                            .param("enabled", "true")
                            .param("email", "email")
                            .param("username", "username"))
                    .andExpect(status().is3xxRedirection());
        ArgumentCaptor<User> captor = ArgumentCaptor.forClass(User.class);
        verify(service).saveUser(captor.capture());
        assertThat(captor.getValue().getUsername(), is("username"));
    }
}
