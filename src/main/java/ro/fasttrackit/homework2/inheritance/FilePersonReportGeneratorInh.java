package ro.fasttrackit.homework2.inheritance;

import ro.fasttrackit.homework2.exceptions.FileReadException;
import ro.fasttrackit.homework2.model.CategorizedPerson;
import ro.fasttrackit.homework2.model.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FilePersonReportGeneratorInh extends PersonReportGeneratorInh {
    private final String sourceFile;

    public FilePersonReportGeneratorInh(String sourceFile, PersonReportWriterInh reportWriter) {
        super(reportWriter);
        this.sourceFile = sourceFile;
    }

    @Override
    public List<CategorizedPerson> readPersons() {
        try (var lines = Files.lines(Path.of(sourceFile))) {
            return lines.map(this::readPerson)
                    .map(CategorizedPerson::new)
                    .toList();
        } catch (IOException e) {
            throw new FileReadException("Could not read from file: " + sourceFile);
        }
    }

    private Person readPerson(String line) {
        var personInfo = line.split(",");
        return new Person(
                personInfo[0],
                personInfo[1],
                Integer.parseInt(personInfo[2]));
    }
}
