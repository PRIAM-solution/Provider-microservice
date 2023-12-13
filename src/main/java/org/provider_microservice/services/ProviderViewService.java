package org.provider_microservice.services;

import org.springframework.data.jpa.repository.Query;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ProviderViewService {
    public void Rectification(String attribute, String newValue, int patientId, String dataTypeName, String primaryKeyName, String primaryKeyValue) throws SQLException;
    public void Erasure(String attribute, int idDS, String dataTypeName, String primaryKeyName, String primaryKeyValue) throws SQLException;

    List<Map<String,String>> getValeursPersonalData(String idRef, String dataTypeName, List<String> attributes) throws SQLException;



}
