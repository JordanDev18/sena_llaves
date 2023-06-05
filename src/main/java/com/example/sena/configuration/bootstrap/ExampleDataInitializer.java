package com.example.sena.configuration.bootstrap;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.sena.model.entity.LlavesPrestramo;
import com.example.sena.model.entity.Usuario;
import com.example.sena.model.enums.AuthorityEnum;
import com.example.sena.repository.LlavesRepositoy;
import com.example.sena.service.LlavesService;
import com.example.sena.service.UsuariosService;

import lombok.RequiredArgsConstructor;


@Component
@RequiredArgsConstructor
public class ExampleDataInitializer implements CommandLineRunner {

    private final UsuariosService usuariosService;
    private final LlavesService llavesService;
    private final PasswordEncoder passwordEncoder;
    private final LlavesRepositoy llavesRepositoy;
    
    @Override
    public void run(String... args) throws Exception {
        loadAdministrator();
        loadSampleLlaves();
    }

    private void loadAdministrator(){
        if (usuariosService.emailDisponible("admininistrador@sena.eda.co")) {
            Usuario admininistrador = Usuario.builder()
                                            .nombre("administrador")
                                            .email("admininistrador@sena.eda.co")
                                            .apellido("principal")
                                            .telefono("3012116105")
                                            .password(passwordEncoder.encode("administrador"))
                                            .authority(AuthorityEnum.ROLE_ADMINISTRADOR)
                                            .enabled(true)
                                            .estado(true)
                                            .build();
            usuariosService.registerUser(admininistrador);
        }
    }

    private void loadSampleLlaves(){
        if (llavesRepositoy.count() == 0) {
            
            List<LlavesPrestramo> llaves = List.of(
                LlavesPrestramo.builder()
                .codigo("ABC123").nombre("Llave 1")
                .nombre("adso-1")
                .cantidad(new BigDecimal("15"))
                .disponible(true)
                .build(), 
                LlavesPrestramo.builder()
                .codigo("DEF123").nombre("Llave 2")
                .nombre("fabrica tic")
                .cantidad(new BigDecimal("10"))
                .disponible(true)
                .build(),
                LlavesPrestramo.builder()
                .codigo("GHI123").nombre("Llave 3")
                .nombre("desarrolo software 2")
                .cantidad(new BigDecimal("20"))
                .disponible(true)
                .build(),
                LlavesPrestramo.builder()
                .codigo("JKL123").nombre("Llave 4")
                .nombre("innovacion")
                .cantidad(new BigDecimal("2"))
                .disponible(true)
                .build(),
                LlavesPrestramo.builder()
                .codigo("MNO123").nombre("Llave 5")
                .nombre("proyectos especiales")
                .cantidad(new BigDecimal("10.5"))
                .disponible(true)
                .build(),
                LlavesPrestramo.builder()
                .codigo("PQR123").nombre("Llave 6")
                .cantidad(new BigDecimal("10.5"))
                .nombre("tecno parque")
                .disponible(true)
                .build()
            );
    
            llavesService.saveAll(llaves);
        }

    }
    
}
