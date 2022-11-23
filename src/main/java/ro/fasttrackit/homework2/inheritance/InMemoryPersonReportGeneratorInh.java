package ro.fasttrackit.homework2.inheritance;

import ro.fasttrackit.homework2.model.CategorizedPerson;
import ro.fasttrackit.homework2.model.Person;

import java.util.List;

public class InMemoryPersonReportGeneratorInh extends PersonReportGeneratorInh {

    public InMemoryPersonReportGeneratorInh(PersonReportWriterInh reportWriter) {
        super(reportWriter);
    }

    @Override
    List<CategorizedPerson> readPersons() {
        return List.of(
                new CategorizedPerson(new Person("Győző", "Gáspár", 38)),
                new CategorizedPerson(new Person("Jimmy", "Zámbó", 44)),
                new CategorizedPerson(new Person("Alejandro", "Lakatos", 29)),
                new CategorizedPerson(new Person("Cadin", "Csics", 17)),
                new CategorizedPerson(new Person("Viktor", "Orbán", 80))
        );
    }
}
