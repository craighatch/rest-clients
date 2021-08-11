package com.credera.examples.serialization;

import com.credera.examples.serialization.dto.person.Person;
import com.credera.examples.serialization.dto.developer.Developer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/serialization")
public class SerializationController {

    @PostMapping("/person")
    public Person serializePerson(@RequestBody Person person) {
        return person;
    }

    @PostMapping("/developer")
    public Developer serializeApplicant(@RequestBody Developer developer) {
        return developer;
    }
}
