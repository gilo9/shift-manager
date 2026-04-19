    package mwa.giles.shiftmanager.config;
    import org.springframework.security.authentication.AuthenticationManager;
    import org.springframework.security.authentication.ProviderManager;
    import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
    import org.springframework.context.annotation.Bean;
    import org.springframework.context.annotation.Configuration;
    import org.springframework.security.config.annotation.web.builders.HttpSecurity;
    import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
    import org.springframework.security.core.userdetails.UserDetailsService;
    import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
    import org.springframework.security.crypto.password.PasswordEncoder;
    import org.springframework.security.web.SecurityFilterChain;

    @Configuration
    @EnableWebSecurity
    public class SecurityConfig {

        private final UserDetailsService userDetailsService;
        public SecurityConfig(final UserDetailsService userDetailsService) {
            this.userDetailsService = userDetailsService;
        }
        @Bean
        public PasswordEncoder passwordEncoder() {
            return  new BCryptPasswordEncoder();
        }
        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            http
                    .authorizeHttpRequests(auth -> auth
                            .requestMatchers("/login/**", "/css/**", "/js/**","/register").permitAll()
                            .anyRequest().authenticated()
                    )
                    .formLogin(form -> form
                            .loginPage("/login")
                            .usernameParameter("username")// Your custom login page
                            .defaultSuccessUrl("/dashboard", true)
                            .failureUrl("/login?error")
                            .permitAll()
                    )
                    .logout(logout -> logout
                            .logoutSuccessUrl("/login?logout=true")
                    );

            return http.build();
        }

        @Bean
        public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
            DaoAuthenticationProvider provider = new DaoAuthenticationProvider(userDetailsService);
            provider.setPasswordEncoder(passwordEncoder());
            return new ProviderManager(provider);
        }

    }
