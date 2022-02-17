package dev.ralfguth.livraria.controller;

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

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest // diz que deverá carregar toda a aplicação no teste
@AutoConfigureMockMvc
@ActiveProfiles("test")
@Transactional
class AutorControllerTest {

	@Autowired
	private MockMvc mvc;

	@Test
	void naoDeveCadastrarUmAutorComSemDados() throws Exception {
		String json = "{}";
		mvc.perform(post("/autor").contentType(MediaType.APPLICATION_JSON).content(json)).andExpect(status().isBadRequest());
	}

	@Test
	void NaoDeveCadastrarUmAutorSemUmDosDados() throws Exception {
		String json = "{ " 
				+ "\"nome\": \"Ralf Guth\", " 
				+ "\"email\": \"rsguth@gmail.com\", " 
				+ "\"nascimento\": \"1989-09-23\" " 
				+ "}";
		mvc.perform(post("/autor").contentType(MediaType.APPLICATION_JSON).content(json))
		.andExpect(status().isBadRequest());
	}

	@Test
	void deveCadastrarUmAutorComOsDadosCompletos() throws Exception {
		String json = "{ " 
				+ "\"nome\": \"Ralf Guth\", " 
				+ "\"email\": \"rsguth@gmail.com\", " 
				+ "\"nascimento\": \"1989-09-23\", " 
				+ "\"biografia\": \"Ralf é um guri bom\" " 
				+ "}";

		String jsonRetorno = "{ " 
				+ "\"nome\": \"Ralf Guth\" " 
				+ "}";
		
		mvc.perform(post("/autor").contentType(MediaType.APPLICATION_JSON).content(json))
			.andExpect(status().isCreated())
			.andExpect(header().exists("Location"))
			.andExpect(content().json(jsonRetorno));
	}


}
