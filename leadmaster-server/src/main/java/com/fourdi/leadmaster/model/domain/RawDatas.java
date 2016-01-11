package com.fourdi.leadmaster.model.domain;

public class RawDatas {
    private final String firstname;
    private final String lastname;
    private final String postalcode;
    private final String city;
    private final String state;
    private final String country;
    private final String email;
    private final String companyname;
    private final String phone1;
    private final String phone2;
    private final String phone3;
    private final String leadref;
    private final String title;
    private final String companyref;
    private final String activity;
    private final String activity_date;
    private final String activity_result;

    public RawDatas(String firstname, String lastname, String postalcode, String city, String state,
                    String country, String email, String companyname, String phone1, String phone2,
                    String phone3, String leadref, String title, String companyref, String activity,
                    String activity_date, String activity_result) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.postalcode = postalcode;
        this.city = city;
        this.state = state;
        this.country = country;
        this.email = email;
        this.companyname = companyname;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.leadref = leadref;
        this.title = title;
        this.companyref = companyref;
        this.activity = activity;
        this.activity_date = activity_date;
        this.activity_result = activity_result;

    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPostalcode() {
        return postalcode;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyname() {
        return companyname;
    }

    public String getPhone1() {
        return phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public String getLeadref() {
        return leadref;
    }

    public String getTitle() {
        return title;
    }

    public String getCompanyref() {
        return companyref;
    }

    public String getActivity() {
        return activity;
    }

    public String getActivity_date() {
        return activity_date;
    }

    public String getActivity_result() {
        return activity_result;
    }


}
