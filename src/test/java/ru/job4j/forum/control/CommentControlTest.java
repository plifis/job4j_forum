package ru.job4j.forum.control;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class CommentControlTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PostService service;

    @Test
    @WithMockUser
    public void shouldReturn() throws Exception {
        when(service.findPostById(1)).thenReturn(Post.of(1, "Post"));
        this.mockMvc.perform(post("/comment")
                .param("id", "1")
                .param("comment", "123435")
              )
        .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Comment> captor = ArgumentCaptor.forClass(Comment.class);
        verify(service).saveComment(captor.capture());
        assertThat(captor.getValue().getComment(), is("123435"));
    }

}
