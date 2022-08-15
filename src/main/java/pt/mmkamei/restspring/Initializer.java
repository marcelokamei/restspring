package pt.mmkamei.restspring;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import pt.mmkamei.restspring.auth.entity.Role;
import pt.mmkamei.restspring.auth.entity.User;
import pt.mmkamei.restspring.auth.service.RoleService;
import pt.mmkamei.restspring.auth.service.UserService;

@Service
public class Initializer {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@PostConstruct
	public void criaUsuariosEPermissoes() {
		Role roleAdmin = new Role();

		roleAdmin.setName("USER");

		roleService.save(roleAdmin);

		User user = new User();
		user.setAtivo(true);
		user.setEmail("kamei@kamei.pt");
		user.setNome("Marcelo Kamei");
		user.setSenha(new BCryptPasswordEncoder().encode("123"));
		user.setUsername("kamei");
		user.setRoles(Arrays.asList(roleAdmin));

		userService.save(user);

	}
}
