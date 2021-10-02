package ru.job4j.forum.control;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.hibernate.hql.internal.ast.ParseErrorHandler;
import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.job4j.forum.Main;
import ru.job4j.forum.Repository.PostRepository;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.List;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class IndexControlTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService service;

    @Test
    @WithMockUser
    public void shouldReturnDefaultMessage() throws Exception {
        this.mockMvc.perform(get("/index"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    @WithMockUser
    public void shouldReturnAllPosts() throws Exception {
        List<Post> list = List.of(Post.of(1, "Продаю ладу Калину"), Post.of(2, "Ищу работу"));
        Mockito.when(service.getAllPosts()).thenReturn(list);
        mockMvc.perform(get("/index"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"))
                .andExpect(MockMvcResultMatchers.model().attribute("posts", list));

    }


}