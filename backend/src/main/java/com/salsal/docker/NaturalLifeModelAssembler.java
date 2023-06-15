package com.salsal.docker;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

@Component
public class NaturalLifeModelAssembler implements RepresentationModelAssembler<NaturalLife, EntityModel<NaturalLife>> {

    @Override
    public EntityModel<NaturalLife> toModel(NaturalLife naturalLife) {
        return EntityModel.of(naturalLife,
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NaturalLifeController.class).getNaturalLifeById(naturalLife.getId())).withSelfRel(),
                WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(NaturalLifeController.class).getAllNaturalLife()).withRel("natural-life"));
    }
}
