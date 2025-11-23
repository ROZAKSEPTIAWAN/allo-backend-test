package com.finance.idr_rate_agregrator.service.implement;


import org.springframework.stereotype.Service;
import org.springframework.validation.ObjectError;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@Service
public class FinanceDataStore {


    private final Map<String, Object> store = new ConcurrentHashMap<>();
    public void put (String Key, Object data)
    {
        store.put(Key, data);
    }
    public Object get (String Key)
    {
        return store.get(Key);
    }

    public  Object   makeImmutable (Object  data)
    {
        if (data instanceof Map<?,?> map)
            return Collections.unmodifiableMap(map);

        if (data instanceof java.util.List<?> listData)
            return Collections.unmodifiableList(listData);

        return data;
    }

}
