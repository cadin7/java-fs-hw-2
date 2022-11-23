package ro.fasttrackit.homework2;

import ro.fasttrackit.homework2.composition.FilePersonReportGenerator;
import ro.fasttrackit.homework2.composition.InMemoryPersonReportGenerator;
import ro.fasttrackit.homework2.composition.PersonReportGenerator;
import ro.fasttrackit.homework2.composition.PersonReportWriter;
import ro.fasttrackit.homework2.inheritance.FilePersonReportGeneratorInh;
import ro.fasttrackit.homework2.inheritance.InMemoryPersonReportGeneratorInh;
import ro.fasttrackit.homework2.inheritance.PersonReportWriterInh;

import java.io.IOException;

public class Main {
    private static final String INPUT_PEOPLE_TXT = "src/main/resources/people.txt";
    private static final String OUTPUT_COMP_FILE_PEOPLE_TXT = "src/main/resources/people-file-comp.txt";
    private static final String OUTPUT_COMP_MEM_PEOPLE_TXT = "src/main/resources/people-mem-comp.txt";
    private static final String OUTPUT_INH_FILE_PEOPLE_TXT = "src/main/resources/people-file-inh.txt";
    private static final String OUTPUT_INH_MEM_PEOPLE_TXT = "src/main/resources/people-mem-inh.txt";

    public static void main(String[] args) throws IOException {
        generateCompositionReports();
        generateInheritanceReports();
    }

    private static void generateCompositionReports() throws IOException {
        generateCompositionFilePersonReport();
        generateCompositionInMemoryPersonReport();
    }

    private static void generateCompositionFilePersonReport() throws IOException {
        var filePersonReportGenerator = new FilePersonReportGenerator(INPUT_PEOPLE_TXT);
        var filePersonReportWriter = new PersonReportWriter(OUTPUT_COMP_FILE_PEOPLE_TXT);

        new PersonReportGenerator(filePersonReportGenerator, filePersonReportWriter).generateReport();
    }

    private static void generateCompositionInMemoryPersonReport() throws IOException {
        var memoryPersonReportWriter = new PersonReportWriter(OUTPUT_COMP_MEM_PEOPLE_TXT);

        new PersonReportGenerator(new InMemoryPersonReportGenerator(), memoryPersonReportWriter).generateReport();
    }

    private static void generateInheritanceReports() throws IOException {
        generateInheritanceFilePersonReport();
        generateInheritanceInMemoryPersonReport();
    }

    private static void generateInheritanceFilePersonReport() throws IOException {
        var filePersonReportGenerator = new FilePersonReportGeneratorInh(
                INPUT_PEOPLE_TXT,
                new PersonReportWriterInh(OUTPUT_INH_FILE_PEOPLE_TXT));

        filePersonReportGenerator.generateReport();
    }

    private static void generateInheritanceInMemoryPersonReport() throws IOException {
        var memoryPersonReportGenerator = new InMemoryPersonReportGeneratorInh(
                new PersonReportWriterInh(OUTPUT_INH_MEM_PEOPLE_TXT));

        memoryPersonReportGenerator.generateReport();
    }

}
