package ro.fasttrackit.homework2.composition;

import ro.fasttrackit.homework2.model.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public record PersonReportWriter(String outputFile) {

    public void writeReport(Map<String, List<Person>> categorizedPeople) throws IOException {
        try (var writer = new BufferedWriter(new FileWriter(outputFile))) {
            if (!categorizedPeople.isEmpty()) {
                writeReport(writer, categorizedPeople);
            }
        }
    }

    private void writeReport(BufferedWriter writer, Map<String, List<Person>> categorizedPeople) {
        categorizedPeople.forEach((key, value) ->
                writeLine(writer, key + ": " + getNames(value)));
    }

    private String getNames(List<Person> value) {
        return value.stream()
                .map(Person::getFullName)
                .collect(Collectors.joining(", "));
    }

    private void writeLine(BufferedWriter writer, String line) {
        try {
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
