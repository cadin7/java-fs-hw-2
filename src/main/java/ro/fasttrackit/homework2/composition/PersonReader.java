package ro.fasttrackit.homework2.composition;

import ro.fasttrackit.homework2.model.CategorizedPerson;

import java.util.List;

public interface PersonReader {
    List<CategorizedPerson> readPersons();
}
