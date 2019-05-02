package com.sasmitha.gproject.services.impl;


import com.sasmitha.gproject.additionalClasses.StudentRequestData;
import com.sasmitha.gproject.model.Request;
import com.sasmitha.gproject.repositories.RequestRepository;
import com.sasmitha.gproject.services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RequestServiceImpl implements RequestService {

    @Autowired
private RequestRepository requestRepository;

    @Override
    public void saveRequest(Request request) {
       requestRepository.save(request);
    }

    @Override
    public List<Request> getRequestData() {
        return requestRepository.findAll();
    }

    @Override
    public void cancelRequest(Integer request_id) {
        requestRepository.deleteById(request_id);
    }



    @Override
    public Request getOldStudentRequestData(Integer request_id) {
        return requestRepository.getOne(request_id);
    }

    @Override
    public void acceptRequest(Request str) {
        requestRepository.save(str);
    }


}
