package com.project.alertcheker.Service;

import com.project.alertcheker.Entity.AlertData;
import com.project.alertcheker.Repository.AlertDataRepoMongo;
//import com.project.alertcheker.Repository.AlertDataRepositoryPG;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AlertService {
//    @Autowired
//    private AlertDataRepositoryPG alertDataRepositoryPG;
    @Autowired
    private AlertDataRepoMongo alertDataRepoMongo;
    public AlertData getData(String Url){
        return alertDataRepoMongo.findByAlertUrl(Url);
    }
    public List<AlertData> getAlertData(String Url){
        return alertDataRepoMongo.findByAlertUrlContaining(Url);
    }
    public void insertData(AlertData data){
        alertDataRepoMongo.save(data);
    }
    public void deleteData(String Url){
        AlertData data = alertDataRepoMongo.findByAlertUrl(Url);
        alertDataRepoMongo.deleteById(data.getId());
    }
    public void updateData(String Url, AlertData alertData){
        AlertData data = alertDataRepoMongo.findByAlertUrl(Url);
        if (alertData.getAlertUrl() != null && !Objects.equals(alertData.getAlertUrl(), "")){
        data.setAlertUrl(alertData.getAlertUrl());
        }
        data.setCritical(alertData.isCritical());
        if (!Objects.equals(data.getComment(), alertData.getComment()) && alertData.getComment() != null && !Objects.equals(alertData.getAlertUrl(), "")) {
            data.setComment(alertData.getComment());
        }
        alertDataRepoMongo.save(data);
    }
}