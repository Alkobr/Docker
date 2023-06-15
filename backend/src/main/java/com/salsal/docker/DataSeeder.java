package com.salsal.docker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final NaturalLifeRepository naturalLifeRepository;

    @Autowired
    public DataSeeder(NaturalLifeRepository naturalLifeRepository) {
        this.naturalLifeRepository = naturalLifeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Populate the database with sample data
        NaturalLife naturalLife1 = new NaturalLife();
        naturalLife1.setName("Flower");
        naturalLife1.setDescription("Beautiful and colorful plants");

        NaturalLife naturalLife2 = new NaturalLife();
        naturalLife2.setName("Bird");
        naturalLife2.setDescription("Feathered creatures that fly");

        // Save the data to the database
        naturalLifeRepository.save(naturalLife1);
        naturalLifeRepository.save(naturalLife2);
    }
}
