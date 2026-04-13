    package mwa.giles.shiftmanager.model;
    import org.springframework.security.core.userdetails.User;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.core.userdetails.UserDetails;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.provisioning.InMemoryUserDetailsManager;
    import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {
        @Bean
        public PasswordEncoder passwordEncoder() {
            return  new BCryptPasswordEncoder();
        }
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/login", "/css/**", "/js/**", "/h2-console").permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin(form -> form
                            .loginPage("/login")          // Your custom login page
                            .defaultSuccessUrl("/dashboard", true)
                            .failureUrl("/login?error=true")
                            .permitAll()
                    )
                    .logout(logout -> logout
                            .logoutSuccessUrl("/login?logout=true")
                    )
                    .csrf(csrf -> csrf
                            .ignoringRequestMatchers("/h2-console/**")
                    )
                    .headers(headers->headers
                            .frameOptions(frame -> frame.sameOrigin())
                    );

            return http.build();
        }
        @Bean
        public InMemoryUserDetailsManager userDetailsService() {
            UserDetails user = User.builder()
                    .username("admin")
                    .password(passwordEncoder().encode("password"))
                    .roles("USER")
                    .build();

            return new InMemoryUserDetailsManager(user);
        }

    }
