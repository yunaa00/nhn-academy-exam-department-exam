/*
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * + Copyright 2024. NHN Academy Corp. All rights reserved.
 * + * While every precaution has been taken in the preparation of this resource,  assumes no
 * + responsibility for errors or omissions, or for damages resulting from the use of the information
 * + contained herein
 * + No part of this resource may be reproduced, stored in a retrieval system, or transmitted, in any
 * + form or by any means, electronic, mechanical, photocopying, recording, or otherwise, without the
 * + prior written permission.
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 */

package com.nhnacademy.exam.parser.impl;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nhnacademy.exam.parser.DepartmentParser;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.*;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Component
@Slf4j
public class JsonDepartmentParser implements DepartmentParser {

    private final ObjectMapper objectMapper;
    @Override
    public String getFileType() {
        return "json";
    }

    @Override
    public List parsing(File file) throws IOException {
        if(file == null || !file.exists() || !file.isFile()){
            throw new FileNotFoundException("json not found"+file);
        }
        JsonNode root;
        try(var is = new FileInputStream(file)){
            root = objectMapper.readTree(is);
        }

        if (root.isArray()) {
            return (List) objectMapper.convertValue(root, LIST_OF_MAP);
        }

        if(root.isObject()){
            for(var key : new String[]{"department","data"}){
                JsonNode n = root.get(key);
                if(n!=null && n.isArray()){
                    return (List) objectMapper.convertValue(n, LIST_OF_MAP);
                }
            }

            Map<String,Object> one = objectMapper.convertValue(root, MAP_OF_TYPE);
            return List.of(one);
        }

        return List.of();
    }

    private static final TypeReference<List<Map<String, Object>>> LIST_OF_MAP=new TypeReference<>(){};
    private static final TypeReference<Map<String,Object>> MAP_OF_TYPE=new TypeReference<>(){};

}
