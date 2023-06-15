package com.salsal.docker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.IanaLinkRelations;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
// import org.springframework.hateoas.EntityModel;
// import org.springframework.hateoas.server.RepresentationModelAssembler;
// import org.springframework.stereotype.Component;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/natural-life")
public class NaturalLifeController {

    private final NaturalLifeRepository naturalLifeRepository;
    private final NaturalLifeModelAssembler assembler;

    @Autowired
    public NaturalLifeController(NaturalLifeRepository naturalLifeRepository, NaturalLifeModelAssembler assembler) {
        this.naturalLifeRepository = naturalLifeRepository;
        this.assembler = assembler;
    }

    @GetMapping
    public CollectionModel<EntityModel<NaturalLife>> getAllNaturalLife() {
        List<EntityModel<NaturalLife>> naturalLife = naturalLifeRepository.findAll().stream()
                .map(assembler::toModel)
                .collect(Collectors.toList());

        return CollectionModel.of(naturalLife,
                linkTo(methodOn(NaturalLifeController.class).getAllNaturalLife()).withSelfRel());
    }

    @PostMapping
    public ResponseEntity<Object> addNaturalLife(@Validated @RequestBody NaturalLife newNaturalLife, BindingResult result) {
        if (result.hasErrors()) {
            List<String> errorMessages = new ArrayList<>();
            for (FieldError error : result.getFieldErrors()) {
                errorMessages.add(error.getDefaultMessage());
            }
            return ResponseEntity.badRequest().body(errorMessages);
        } else {
            NaturalLife savedNaturalLife = naturalLifeRepository.save(newNaturalLife);
            EntityModel<NaturalLife> naturalLifeModel = assembler.toModel(savedNaturalLife);
            return ResponseEntity.created(naturalLifeModel.getRequiredLink(IanaLinkRelations.SELF).toUri())
                    .body(naturalLifeModel);
        }
    }

    @GetMapping("/{id}")
    public EntityModel<NaturalLife> getNaturalLifeById(@PathVariable String id) {
        NaturalLife naturalLife = naturalLifeRepository.findById(id)
                .orElseThrow(() -> new NaturalLifeNotFoundException(id));
        return assembler.toModel(naturalLife);
    }

    @PutMapping("/{id}")
    public NaturalLife updateNaturalLife(@Validated @RequestBody NaturalLife updatedNaturalLife, @PathVariable String id) {
        return naturalLifeRepository.findById(id)
                .map(naturalLife -> {
                    naturalLife.setName(updatedNaturalLife.getName());
                    naturalLife.setDescription(updatedNaturalLife.getDescription());
                    return naturalLifeRepository.save(naturalLife);
                })
                .orElseThrow(() -> new NaturalLifeNotFoundException(id));
    }

    @DeleteMapping("/{id}")
    public void deleteNaturalLife(@PathVariable String id) {
        naturalLifeRepository.deleteById(id);
    }
}
