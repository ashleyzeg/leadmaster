package com.fourdi.leadmaster.model.domain;

import java.time.LocalTime;

public class Upload {
    private final Integer   id;
    private final String    description;
    private final LocalTime uploadTimestamp;
    private final Integer   customerId;
    private final String    uploadProcess;
    private final String    fileLocation;
    private final String    fileName;
    private final String    status;
    private final String    message;
    private final LocalTime processTimestamp;

    public Upload(Integer id, String descripion, LocalTime uploadTimestamp, Integer customerId,
                  String uploadProcess, String fileLocation, String fileName,
                  String status, String message,LocalTime processTimestamp) {
        this.id               = id;
        this.description      = descripion;
        this.uploadTimestamp  = uploadTimestamp;
        this.customerId       = customerId;
        this.uploadProcess    = uploadProcess;
        this.fileLocation     = fileLocation;
        this.fileName         = fileName;
        this.status           = status;
        this.message          = message;
        this.processTimestamp = processTimestamp;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public LocalTime getUploadTimestamp() {
        return uploadTimestamp;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public String getUploadProcess() {
        return uploadProcess;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public String getFileName() {
        return fileName;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public LocalTime getProcessTimestamp() {
        return processTimestamp;
    }
}
