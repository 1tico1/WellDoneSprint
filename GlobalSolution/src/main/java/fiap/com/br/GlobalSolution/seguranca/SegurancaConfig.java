package fiap.com.br.GlobalSolution.seguranca;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import fiap.com.br.GlobalSolution.servico.UsuarioDetailsService;

@Configuration
public class SegurancaConfig {

    private final UsuarioDetailsService usuarioDetailsService;

    public SegurancaConfig(UsuarioDetailsService usuarioDetailsService) {
        this.usuarioDetailsService = usuarioDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests((requests) -> requests
                .requestMatchers("/login", "/logout", "/access-denied").permitAll() // Permitir acesso à página de login e acesso negado
                .requestMatchers("/admin/**").hasRole("ADMIN") // Necessário ter role ADMIN para acessar
                .requestMatchers("/user/**").hasRole("USER") // Necessário ter role USER para acessar
                .anyRequest().authenticated() // Qualquer outra solicitação requer autenticação
            )
            .formLogin((form) -> form
                .loginPage("/login") // Página de login personalizada
                .defaultSuccessUrl("/index", true) // Redirecionamento após login bem-sucedido
                .failureUrl("/login?error=true") // Redirecionamento em caso de falha no login
                .permitAll()
            )
            .logout((logout) -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .permitAll()
            )
            .exceptionHandling((exception) -> exception.accessDeniedPage("/access-denied")); // Página de acesso negado

        return http.build();
    }

    @Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
