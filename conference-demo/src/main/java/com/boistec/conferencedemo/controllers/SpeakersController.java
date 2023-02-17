package com.boistec.conferencedemo.controllers;

import com.boistec.conferencedemo.models.Speaker;
import com.boistec.conferencedemo.repositories.SpeakerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/speakers")
public class SpeakersController {
    @Autowired
    private SpeakerRepository speakerRepository;

    @GetMapping
    public List<Speaker> list() {
        return speakerRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Speaker get(@PathVariable Long id) {
        return  speakerRepository.getReferenceById(id);
    }

    @PostMapping
    public Speaker create(@RequestBody final Speaker speaker) {
        return speakerRepository.saveAndFlush(speaker);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        // JPA doesn't delete in cascade so you have to delete manually in revers.
        speakerRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Speaker update(@PathVariable Long id, @RequestBody Speaker speaker) {
        //now PUT, all attributes to be passed in. PATCH would only need what we expect to update
        //TODO: Add validation that all attributes are passed in, otherwise return a 400
        Speaker existingSession = speakerRepository.getReferenceById(id);
        BeanUtils.copyProperties(speaker, existingSession,"session_id");
        return speakerRepository.saveAndFlush(speaker);
    }
}
