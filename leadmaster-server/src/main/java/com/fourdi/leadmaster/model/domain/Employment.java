package com.fourdi.leadmaster.model.domain;

public class Employment {
    private Integer lead_id;
    private Integer company_id;
    private Integer title_classification_id;
    private String  title;

    public Employment(Integer lead_id, Integer company_id, Integer title_classification_id, String title) {
        this.lead_id = lead_id;
        this.company_id = company_id;
        this.title_classification_id = title_classification_id;
        this.title = title;
    }

    public Integer getLead_id() {
        return lead_id;
    }

    public Integer getCompany_id() {
        return company_id;
    }

    public Integer getTitle_classification_id() {
        return title_classification_id;
    }

    public String getTitle() {
        return title;
    }
}

