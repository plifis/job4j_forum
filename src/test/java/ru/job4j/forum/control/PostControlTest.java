package ru.job4j.forum.control;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import ru.job4j.forum.Main;
import ru.job4j.forum.model.Comment;
import ru.job4j.forum.model.Post;
import ru.job4j.forum.service.PostService;

import java.util.List;

@SpringBootTest(classes = Main.class)
@AutoConfigureMockMvc
public class PostControlTest {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private PostService service;

    @Test
    @WithMockUser
    public void shouldReturnEditMessageWithPostById() throws Exception {
        Post target = Post.of(1, "Продаю ладу Калину");
        Comment comment = new Comment();
        comment.setComment("сколько?");
        target.addComment(comment);
        List<Post> list = List.of(target, Post.of(2, "Ищу работу"));
        Mockito.when(service.findPostById(1)).thenReturn(list.get(0));
        Mockito.when(service.getAllCommentsById(1)).thenReturn(list.get(0).getComments());
        this.mockMvc.perform(get("/edit").param("id", "1"))
               .andDo(print())
               .andExpect(status().isOk())
               .andExpect(view().name("/edit"))
                .andExpect(MockMvcResultMatchers.model().attribute("post", target));
    }

    @Test
    @WithMockUser
    public void shouldReturnViewPostById() throws Exception {
        Post target = Post.of(1, "Продаю ладу Калину");
        List<Post> list = List.of(target, Post.of(2, "Ищу работу"));
        Mockito.when(service.findPostById(1)).thenReturn(list.get(0));
        this.mockMvc.perform(get("/post").param("id", "1"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("/post"))
                .andExpect(MockMvcResultMatchers.model().attribute("post", target));
    }

    @Test
    @WithMockUser
    public void shouldReturnViewCreate() throws Exception {
            this.mockMvc.perform(get("/create"))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andExpect(view().name("/create"));
    }

    @Test
    @WithMockUser
    public void shouldReturnRedirect() throws Exception {
        this.mockMvc.perform(post("/save")
             .param("id", "1")
                .param("name", "Продаю ладу Калину"))
                .andDo(print())
                .andExpect(status().is3xxRedirection());
        ArgumentCaptor<Post> captor = ArgumentCaptor.forClass(Post.class);
        verify(service).savePost(captor.capture());
        assertThat(captor.getValue().getName(), is("Продаю ладу Калину"));
    }
}
