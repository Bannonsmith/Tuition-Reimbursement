package dev.smith.repositories;

import dev.smith.models.Form;

import java.util.List;

public interface FormRepo {
    public Form addForm(Form f);
    public List<Form> getAllForms();
    public Form getForm(int id);
    public Form updateForm(Form change);
    public Form deleteForm(int id);
    public List<Form> getAllFormsByEmployeeId(int id);
}
