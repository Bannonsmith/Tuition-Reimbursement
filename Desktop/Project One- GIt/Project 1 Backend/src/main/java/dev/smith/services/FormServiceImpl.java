package dev.smith.services;

import dev.smith.models.Form;
import dev.smith.repositories.FormRepo;

import java.util.List;

public class FormServiceImpl implements FormService {

    FormRepo fr;

    public FormServiceImpl(FormRepo fr) { this.fr = fr; }

    @Override
    public Form addForm(Form f) { return fr.addForm(f); }

    @Override
    public List<Form> getAllForms() {
        return fr.getAllForms();
    }

    @Override
    public Form getForm(int id) {
        return fr.getForm(id);
    }

    @Override
    public Form updateForm(Form change) {
        return fr.updateForm(change);
    }

    @Override
    public Form deleteForm(int id) {
        return fr.deleteForm(id);
    }

    @Override
    public List<Form> getAllFormsByEmployeeId(int id) {
        return fr.getAllFormsByEmployeeId(id);
    }
}
