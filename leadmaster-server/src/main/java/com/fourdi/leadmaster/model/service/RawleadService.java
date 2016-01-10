package com.fourdi.leadmaster.model.service;

import com.fourdi.leadmaster.model.domain.Rawlead;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.Reader;
import java.util.stream.Stream;

@Service
public class RawleadService {

    public Stream<Rawlead> mapAndXform(final Reader reader) {
        Stream.Builder<Rawlead> stream = Stream.builder();

        try
        {
            CSVParser parser = CSVFormat.DEFAULT.parse(reader);
            parser.forEach((record) ->
            {
                if( parser.getCurrentLineNumber() != 1) {
                    final String firstname = (record.size() >= 1) ? record.get(0) : null;
                    final String lastname = (record.size() >= 2) ? record.get(1) : null;
                    final String postalcode = (record.size() >= 3) ? record.get(2) : null;
                    final String city = (record.size() >= 4) ? record.get(3) : null;
                    final String state = (record.size() >= 5) ? record.get(4) : null;
                    final String country = (record.size() >= 6) ? record.get(5) : null;
                    final String email = (record.size() >= 7) ? record.get(6) : null;
                    final String companyname = (record.size() >= 8) ? record.get(7) : null;
                    final String phone1 = (record.size() >= 9) ? record.get(8) : null;
                    final String phone2 = (record.size() >= 10) ? record.get(9) : null;
                    final String phone3 = (record.size() >= 11) ? record.get(10) : null;
                    final String leadref = (record.size() >= 12) ? record.get(11) : null;
                    final String title = (record.size() >= 13) ? record.get(12) : null;
                    final String companyref = (record.size() >= 14) ? record.get(13) : null;
                    final String activity = (record.size() >= 15) ? record.get(14) : null;
                    final String activity_date = (record.size() >= 16) ? record.get(15) : null;
                    final String activity_result = (record.size() >= 17) ? record.get(16) : null;
                    stream.add(new Rawlead(firstname, lastname, postalcode, city, state, country,
                                           email, companyname, phone1, phone2, phone3, leadref, title, companyref,
                                           activity, activity_date, activity_result));
                }
            });
        } catch (IOException e)
        {

        }
        return stream.build();
    }
}
