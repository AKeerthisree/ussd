package com.example.ussd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ussd.data.UssdSession;
import com.example.ussd.repository.UssdSessionRepository;

@Service
public class SessionService {
    @Autowired
    private UssdSessionRepository ussdSessionRepository;

    public UssdSession createUssdSession(UssdSession session) {
        return ussdSessionRepository.save(session);
    }

    public UssdSession get(String id) {
        return ussdSessionRepository.findById(id).orElse(null);
    }

    public UssdSession update(UssdSession session) {
        if (ussdSessionRepository.existsById(session.getId())) {
            return ussdSessionRepository.save(session);
        }
        throw new IllegalArgumentException("A car must have an id to be updated");
    }

    public void delete(String id) {
        // deleting the session
        ussdSessionRepository.deleteById(id);
    }
    
}
