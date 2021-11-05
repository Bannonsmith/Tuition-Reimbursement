package dev.smith.models;

import dev.smith.repositories.ApprovalRepoHBImpl;
import org.junit.jupiter.api.Test;

public class ApprovalTest {

    @Test
    public void shouldGetApproval() {
        ApprovalRepoHBImpl ar = new ApprovalRepoHBImpl();

        Approval a1 = new Approval(1);
        Approval a2 = new Approval();
        a2.setApprovalId((a1.getApprovalId()));
        Approval expected = ar.getApproval(1);
        Approval actual = a2;




    }





}
