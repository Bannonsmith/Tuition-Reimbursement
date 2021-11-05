package dev.smith.services;

import dev.smith.models.Approval;
import dev.smith.repositories.ApprovalRepo;

import java.util.List;

public class ApprovalServiceImpl implements ApprovalService{

    ApprovalRepo ar;

    public ApprovalServiceImpl(ApprovalRepo ar) { this.ar = ar; }

    @Override
    public Approval addApproval(Approval a) {
        return ar.addApproval(a);
    }

    @Override
    public List<Approval> getAllApprovals() {
        return ar.getAllApprovals();
    }

    @Override
    public Approval getApproval(int id) {
        return ar.getApproval(id);
    }

    @Override
    public Approval updateApproval(Approval change) {
        return ar.updateApproval(change);
    }

    @Override
    public Approval deleteApproval(int id) {
        return ar.deleteApproval(id);
    }

    @Override
    public List<Approval> getAllApprovalsByEmployeeId(int id) {
        return ar.getAllApprovalsByEmployeeId(id);
    }
}
