package com.hstn.rest.my_controller;

import com.hstn.rest.entity.Pupil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PupilRestController {

    @GetMapping("/pupils")
    public List<Pupil> getPupil() {
        Pupil pupil1 = new Pupil("Serg", "Bul");
        Pupil pupil2 = new Pupil("Oleg", "Petrov");
        Pupil pupil3 = new Pupil("Ivan", "Ivanov");

        List<Pupil> pupils = new ArrayList<Pupil>();
        pupils.add(pupil1);
        pupils.add(pupil2);
        pupils.add(pupil3);

        return pupils;
    }

}
