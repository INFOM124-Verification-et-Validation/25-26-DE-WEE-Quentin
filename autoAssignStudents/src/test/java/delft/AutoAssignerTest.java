package delft;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.within;
import java.time.temporal.ChronoUnit;

import java.util.*;
import java.util.stream.*;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;
import java.time.*;

class AutoAssignerTest {

    private ZonedDateTime date(int year, int month, int day, int hour, int minute) {
        return ZonedDateTime.of(year, month, day, hour, minute, 0, 0, ZoneId.systemDefault());
    }

    private Map<ZonedDateTime, Integer> dates = new HashMap<>();
    private List<Student> students = new ArrayList<>();
    private List<Workshop> workshops = new ArrayList<>();

    private AutoAssigner assigner = new AutoAssigner();

    private Student student1 = new Student(1, "Quentin", "quentin@gmail");
    private Student student2 = new Student(2, "Margaux", "Margaux@gmail");

    private Workshop workshop2 = new Workshop(2, "Condorcet", dates);

    private ZonedDateTime date1 = date(2025, 11, 4, 10, 17);
    private ZonedDateTime date2 = date(2004, 5, 1, 4, 30);


    @Test
    void Test_init (){
        dates.put(date1, 1);
        Workshop workshop1 = new Workshop(1, "Unamur", dates);
        workshops.add(workshop1);
        students.add(student1);

        assertThat(workshops.size()).isEqualTo(1);
        assertThat(workshop1.getId()).isEqualTo(1);
        assertThat(workshop1.getName()).isEqualTo("Unamur");
        assertThat(student1.getId()).isEqualTo(1);
        assertThat(student1.getName()).isEqualTo("Quentin");
    }

    @Test
    void Test_assign (){
        dates.put(date1, 1);
        Workshop workshop1 = new Workshop(1, "Unamur", dates);
        workshops.add(workshop1);
        students.add(student1);
        AssignmentsLogger assin = assigner.assign(students, workshops);

        System.out.println(5);

        System.out.println(assin.getAssignments());

        System.out.println(5);


        assertThat(assin.getAssignments()).containsExactlyInAnyOrder("Unamur,Quentin,04/11/2025 10:17");
    }
}
