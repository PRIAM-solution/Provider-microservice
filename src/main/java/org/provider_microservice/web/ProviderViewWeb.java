package org.provider_microservice.web;

import org.provider_microservice.dto.GetDataValueDTO;
import org.provider_microservice.services.ProviderViewService;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(path = "/api")
public class ProviderViewWeb {
    private ProviderViewService providerViewService;

    public ProviderViewWeb(ProviderViewService providerViewService) {
        this.providerViewService = providerViewService;
    }

    @GetMapping(path = "/dataAccessRight")
    public List<Map<String, String>> getPersonalDataValues(@RequestParam String idRef, @RequestParam String dataTypeName,
                                                        @RequestParam List<String> attributes) throws SQLException {
        return providerViewService.getPersonalDataValues(idRef, dataTypeName, attributes, null);
    }
    @PostMapping(path = "/dataValue")
    public Map<String, String> getPersonalDataValue(@RequestBody GetDataValueDTO getDataValueDTO) throws SQLException {
        return providerViewService.getDataValue(getDataValueDTO.getReferenceId(), getDataValueDTO.getAttributeName(), getDataValueDTO.getPrimaryKeys());
    }

    @PostMapping(path = "/rectification")
    public void rectification(@RequestBody List<Map<String,String>> parameters) throws SQLException {
        String attribute = null, newValue = null, dsId = null, dataTypeName = null,primaryKeyName = null,primaryKeyValue = null;
        for (Map<String, String> parameter : parameters) {
            attribute = parameter.get("attribute");
            newValue = parameter.get("newValue");
            dsId = parameter.get("dsId");
            dataTypeName = parameter.get("dataTypeName");
            primaryKeyName = parameter.get("primaryKeyName");
            primaryKeyValue = parameter.get("primaryKeyValue");
        }
        providerViewService.Rectification(attribute, newValue, dsId, dataTypeName,
                primaryKeyName, primaryKeyValue);
    }

    @PostMapping(path = "/forgotten")
    public void forgotten(@RequestBody List<Map<String,String>> parameters) throws SQLException {
        String attribute = null, newValue = null, userId = null, dataTypeName = null,primaryKeyName = null,primaryKeyValue = null;
        for (Map<String, String> parameter : parameters) {
            attribute = parameter.get("attribute");
            userId = parameter.get("dsId");
            dataTypeName = parameter.get("dataTypeName");
            primaryKeyName = parameter.get("primaryKeyName");
            primaryKeyValue = parameter.get("primaryKeyValue");
        }
        providerViewService.Erasure(attribute, userId, dataTypeName, primaryKeyName, primaryKeyValue);

    }
}

