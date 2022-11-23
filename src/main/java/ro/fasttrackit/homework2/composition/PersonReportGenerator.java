package ro.fasttrackit.homework2.composition;

import ro.fasttrackit.homework2.model.CategorizedPerson;
import ro.fasttrackit.homework2.model.Person;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import static java.util.stream.Collectors.*;

public record PersonReportGenerator(PersonReader personProvider,
                                    PersonReportWriter reportWriter) {

    public void generateReport() throws IOException {
        reportWriter.writeReport(new TreeMap<>(groupPeopleByAgeGroup()));
    }

    private Map<String, List<Person>> groupPeopleByAgeGroup() {
        return personProvider.readPersons()
                .stream()
                .collect(groupingBy(CategorizedPerson::getAgeRange,
                        mapping(CategorizedPerson::getPerson, toList())));
    }
}
