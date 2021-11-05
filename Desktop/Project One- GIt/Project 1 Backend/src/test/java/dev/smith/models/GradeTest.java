package dev.smith.models;

import dev.smith.repositories.GradeRepoHBImpl;
import org.junit.jupiter.api.Test;

class GradeTest {

    @Test
    public void shouldGetGrade() {

        GradeRepoHBImpl gr = new GradeRepoHBImpl();

        Grade g1 = new Grade (1, "fast");
        Grade g2 = new Grade();
            g2.setGradeId(g1.getGradeId());
        Grade expected = gr.getGrade(1);
        Grade actual = g2;

    }

}