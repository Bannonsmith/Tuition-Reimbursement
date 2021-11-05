package dev.smith.models;

import dev.smith.repositories.FormRepoHBImpl;
import org.junit.jupiter.api.Test;

public class FormTest {


    @Test
    public void shouldGetAForm() {

        FormRepoHBImpl fr = new FormRepoHBImpl();

        Form f1 = new Form(7);
        Form f2 = new Form();
        f2.setFormId((f1.getFormId()));
        Form expected = fr.getForm(1);
        Form actual = f2;
    }

}
