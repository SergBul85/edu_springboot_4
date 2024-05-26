package com.hstn.rest.my_controller;

import com.hstn.rest.entity.Pupil;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PupilRestController {

    private List<Pupil> pupils;

    @PostConstruct
    public void createListOfPupils() {
        pupils = new ArrayList<>();

        Pupil pupil1 = new Pupil("Serg", "Bul");
        Pupil pupil2 = new Pupil("Oleg", "Petrov");
        Pupil pupil3 = new Pupil("Ivan", "Ivanov");

        pupils.add(pupil1);
        pupils.add(pupil2);
        pupils.add(pupil3);
    }

    @GetMapping("/pupils")
    public List<Pupil> getPupil() {

        return pupils;
    }

    @GetMapping("/pupils/{pupilIndex}")
    public Pupil getPupilByIndexOfArrayList(@PathVariable int pupilIndex) {

        if (pupilIndex < 0 || pupilIndex >= pupils.size()) {
            throw new PupilNotFoundException("Pupil id " + pupilIndex + " not found.");
        }

        return pupils.get(pupilIndex);
    }

    @ExceptionHandler
    public ResponseEntity<PupilErrorResponse>  handlerException(PupilNotFoundException exception){
        PupilErrorResponse error = new PupilErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exception.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<PupilErrorResponse>  handlerException(Exception exception){
        PupilErrorResponse error = new PupilErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage("User enter invalid data. You must enter only INTEGER value.");
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
