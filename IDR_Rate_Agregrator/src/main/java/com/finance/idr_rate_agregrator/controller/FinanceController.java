package com.finance.idr_rate_agregrator.controller;


import com.finance.idr_rate_agregrator.service.implement.FinanceDataStore;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/finance")
public class FinanceController

{
    private final FinanceDataStore store;

    public FinanceController(FinanceDataStore store) {
        this.store = store;
    }

    public ResponseEntity<?> getData (@PathVariable String resourceType)
    {
        Object DataValue = store.get(resourceType);
        if(DataValue == null)
        {
            return ResponseEntity.status(404).body("Resource not found"+resourceType);
        }
        return ResponseEntity.ok(DataValue);
    }
}
