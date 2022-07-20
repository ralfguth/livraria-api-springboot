package dev.ralfguth.livraria.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class LivroControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@Test
	void naoDeveCadastrarUmLivroSemDados() throws Exception {
		String json = "{}";
		mvc.perform(post("/livro").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isBadRequest());
	}
	
	@Test
	void NaoDeveCadastrarUmLivroSemAutor() throws Exception {
		String json = "{ " 
				
				+ "}";
		mvc.perform(post("/autor").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isBadRequest());
	}

}
