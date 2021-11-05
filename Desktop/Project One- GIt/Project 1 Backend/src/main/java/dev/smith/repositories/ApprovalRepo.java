package dev.smith.repositories;

import dev.smith.models.Approval;

import java.util.List;

public interface ApprovalRepo {

    public Approval addApproval(Approval a);
    public List<Approval> getAllApprovals();
    public Approval getApproval(int id);
    public Approval updateApproval(Approval change);
    public Approval deleteApproval(int id);
    public List<Approval> getAllApprovalsByEmployeeId(int id);

}
