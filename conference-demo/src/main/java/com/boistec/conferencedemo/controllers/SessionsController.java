package com.boistec.conferencedemo.controllers;

import com.boistec.conferencedemo.models.Session;
import com.boistec.conferencedemo.repositories.SessionRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sessions")
public class SessionsController {
    @Autowired
    private SessionRepository sessionRepository;

    @GetMapping
    public List<Session> list() {
        return  sessionRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Session get(@PathVariable Long id) {
        //Maybe we just need to use getOne(id)
        return sessionRepository.getReferenceById(id);
    }

    @PostMapping
    public Session create(@RequestBody final Session session) {
        return sessionRepository.saveAndFlush(session);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        //Also need to check for children records before deleting.
        // JPA doesn't delete in cascade so you have to delete manually in revers.
        sessionRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Session update(@PathVariable Long id, @RequestBody Session session) {
        //now PUT, all attributes to be passed in. PATCH would only need what we expect to update
        //TODO: Add validation that all attributes are passed in, otherwise return a 400
        Session existingSession = sessionRepository.getReferenceById(id);
        BeanUtils.copyProperties(session, existingSession,"session_id");
        return sessionRepository.saveAndFlush(session);
    }
}
