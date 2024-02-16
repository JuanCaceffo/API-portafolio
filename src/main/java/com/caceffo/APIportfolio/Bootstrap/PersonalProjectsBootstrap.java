package com.caceffo.APIportfolio.Bootstrap;

import com.caceffo.APIportfolio.Domain.PersonalProjects;
import com.caceffo.APIportfolio.Domain.helpers.Langs;
import com.caceffo.APIportfolio.Reposiroty.PersonalProjectRepo;
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
                            "https://worldcapp-2023.onrender.com/"
                    )
            )
    );

    @Override
    public void afterPropertiesSet() throws Exception {
        personalProjectsList.forEach(project -> {personalProjectRepo.addElement(project);});
    }
}
