package com.caceffo.APIportfolio.Bootstrap;

import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Repository.PersonalProjectRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonalProjectsBootstrap implements InitializingBean {
    @Autowired
    private PersonalProjectRepo personalProjectRepo;
    ArrayList<PersonalProjects> personalProjectsList = new ArrayList(
            List.of(
                    new PersonalProjects(
                            new Langs("Aplicacion web", "App web"),
                            new Langs("WorldCapp 2023", "WorldCapp 2023"),
                            new Langs("worldcapp-2023 es una app de album de figuritas desrrollada con el framework Angular 16 y typescrip. Realizada con muy buenas practicas utilizando el patron de diseño arquitecutral MVC permitiendo una gran escalabilidad del proyecto", "worldcapp-2023 is a sticker album app developed with the Angular 16 framework and TypeScript. It has been implemented with excellent practices using the MVC architectural design pattern, allowing for great scalability of the project."),
                            "https://github.com/JuanCaceffo/worldcapp-2023",
                            "https://worldcapp-2023.onrender.com/",
                            new ArrayList(List.of("/assets/mocks-imgs/pjt/wordlCapp.jpeg"))
                    ),
                    new PersonalProjects(
                            new Langs("Aplicacion web", "App web"),
                            new Langs("WorldCapp admin 2023", "WorldCapp admin 2023"),
                            new Langs("worldcapp admin 2023 es una app web para administrar, eliminar, registrar entidades de la app worldCapp2023 esta fue desarrollada con React y javascript. Creando componentes reutilizables permitiendo una gran escalabilidad del proyecto", "WorldCapp Admin 2023 is a web application for managing, deleting, and registering entities within the WorldCapp2023 app. It was developed using React and JavaScript, creating reusable components to enable significant scalability of the project."),
                            "https://github.com/JuanCaceffo/worldcapp-2023-admin",
                            "https://worldcapp-2023-admin.onrender.com/",
                            new ArrayList(List.of("/assets/mocks-imgs/pjt/worldCappAdmin.png"))
                    ),
                    new PersonalProjects(
                            new Langs("API full rest", "API full rest"),
                            new Langs("WorldCapp API", "WorldCapp API"),
                            new Langs("API Rest realizada con springboot y kt con la logica de negocio del proyecto WorldCapp.", "RESTful API built with Spring Boot and Kotlin containing the business logic of the WorldCapp project." ),
                            "https://github.com/JuanCaceffo/worldcapp-2023-backend",
                            "",
                            new ArrayList(List.of("/assets/mocks-imgs/pjt/worldCappAPI.png"))
                    ),
                    new PersonalProjects(
                            new Langs("App de escritorio", "Desktop app"),
                            new Langs("Pokemon UNSAM", "Pokemon UNSAM"),
                            new Langs("Proyecto realizado con el lenguaje Wollok, donde aprendi las bases de OOP el uso de versionado de git y como modelar con buenas practicas en objetos.","Project carried out using the Wollok language, where I learned the basics of OOP, the use of git versioning, and how to model with good object-oriented practices."),
                            "https://github.com/algo1unsam/tpgame-undefine",
                            "",
                            new ArrayList(List.of("/assets/mocks-imgs/pjt/pokemon.png"))
                    )
            )
    );

    @Override
    public void afterPropertiesSet(){
        personalProjectsList.forEach(project -> {personalProjectRepo.addElement(project);});
    }
}
