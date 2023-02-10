	package com.ruanazevedo.workshopmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.ruanazevedo.workshopmongodb.domain.Post;
import com.ruanazevedo.workshopmongodb.domain.User;
import com.ruanazevedo.workshopmongodb.dto.AuthorDTO;
import com.ruanazevedo.workshopmongodb.dto.CommentDTO;
import com.ruanazevedo.workshopmongodb.repositories.PostRepository;
import com.ruanazevedo.workshopmongodb.repositories.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private PostRepository postRepo;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		
		userRepo.deleteAll();
		postRepo.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		User jon = new User(null, "Jon Travolta", "jon@yahoo.com");
		User manu = new User(null, "Manuel Gomes", "bluepen@outlook.com");
		User tog = new User(null, "Toguro", "toguro@outlook.com");
		
		userRepo.saveAll(Arrays.asList(maria, alex, bob, jon, manu, tog));
		
		Post post1 = new Post(null, sdf.parse("21/03/2022"), "Partiu Viagem", "Vou viajar. Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2022"), "Bom dia", "Acordei feliz hoje", new AuthorDTO(maria));
		Post post3 = new Post(null, sdf.parse("01/08/2022"), "Olá pessuall", "Caneta azuuull azull canetaaaa", new AuthorDTO(manu));
		Post post4 = new Post(null, sdf.parse("13/08/2022"), "Olá pessuall", "Seio que você é linda demaiize eu fiquei apaixonaaaa pelo beij que ela me deu", new AuthorDTO(manu));
		Post post5 = new Post(null, sdf.parse("15/08/2022"), "Olá pessuall", "Olha se voce nao me ama então nao me ligue nao fique me fazendo queixa", new AuthorDTO(manu));
		Post post6 = new Post(null, sdf.parse("01/10/2022"), "Sheipaaaaaaaado", "Em pleno 2022, ano da copa", new AuthorDTO(manu));
		
		CommentDTO c1 = new CommentDTO("Boa viagem mano!", sdf.parse("21/03/2018"), new AuthorDTO(alex));
		CommentDTO c2 = new CommentDTO("Aproveita", sdf.parse("22/03/2018"), new AuthorDTO(bob));
		CommentDTO c3 = new CommentDTO("Tenha um ótimo dia", sdf.parse("23/03/2018"), new AuthorDTO(alex));
		CommentDTO c4 = new CommentDTO("O homi é brabo demais", sdf.parse("01/08/2022"), new AuthorDTO(tog));
		CommentDTO c5 = new CommentDTO("Canta muito", sdf.parse("13/08/2022"), new AuthorDTO(bob));
		
		post1.getComments().addAll(Arrays.asList(c1, c2));
		post2.getComments().add(c3);
		post3.getComments().add(c4);
		post4.getComments().add(c5);
		
		postRepo.saveAll(Arrays.asList(post1, post2, post3, post4, post5, post6));
		
		maria.getPosts().add(post1);
		maria.getPosts().add(post2);
		userRepo.save(maria);
	}
}