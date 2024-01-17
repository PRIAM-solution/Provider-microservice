package org.provider_microservice.services;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface ProviderViewService {
    public void Rectification(String attribute, String newValue, String userId, String dataTypeName, String primaryKeyName, String primaryKeyValue) throws SQLException;
    public void Erasure(String attribute, String userId, String dataTypeName, String primaryKeyName, String primaryKeyValue) throws SQLException;

    List<Map<String,String>> getPersonalDataValues(String idRef, String dataTypeName, List<String> attributes, HashMap<String, String> primaryKeys) throws SQLException;
    Map<String, String> getDataValue(String referenceId, String attributeName, Map<String, String> primaryKeys);


}
