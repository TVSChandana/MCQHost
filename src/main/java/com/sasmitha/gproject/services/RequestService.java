package com.sasmitha.gproject.services;

import com.sasmitha.gproject.additionalClasses.StudentRequestData;
import com.sasmitha.gproject.model.Request;

import java.util.List;

public interface RequestService {
    void saveRequest(Request request);

    List<Request> getRequestData();

    void cancelRequest(Integer request_id);


    Request getOldStudentRequestData(Integer request_id);

    void acceptRequest(Request str);
}
