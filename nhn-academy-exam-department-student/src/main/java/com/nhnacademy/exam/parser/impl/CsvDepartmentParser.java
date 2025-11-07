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

import com.nhnacademy.exam.model.DepartmentRow;
import com.nhnacademy.exam.parser.DepartmentParser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Slf4j
@Component
public class CsvDepartmentParser implements DepartmentParser {


    @Override
    public String getFileType() {
        return "csv";
    }

    @Override
    public List parsing(File file) throws IOException {
        List<DepartmentRow> rows = new ArrayList<>();

        if(file == null || !file.exists() || !file.isFile()){
            throw new FileNotFoundException("CSV not found"+(file==null ? "null": file.getAbsolutePath()));
        }

        try(BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8))){
            String line;
            boolean headerChecked = false;

            while((line=br.readLine()) != null){
                String trimmed = line.trim();
                if(trimmed.isEmpty() || trimmed.startsWith("#")){
                    continue;
                }

                if(!headerChecked){
                    headerChecked=true;
                    if(isHeaderLine(trimmed)){
                        continue;
                    }
                }

                String[] tokens = trimmed.split(",",-1);
                if(tokens.length<4){
                    log.info("not enough");
                    continue;
                }

                String employeeNo = tokens[0].trim();
                String name = tokens[1].trim();
                String deployeement = tokens[2].trim();
                String departmentCode = tokens[3].trim();

                rows.add(new DepartmentRow(employeeNo,name,deployeement,departmentCode));
            }
        }
        return rows;
    }

    private boolean isHeaderLine(String line){
        String lower = line.toLowerCase();
        return lower.contains("사번") || lower.contains("employee") ||lower.contains("id");

    }
}