package services;

import java.util.ArrayList;
import java.util.List;
import models.*;


public class WithdrawalService {
    private List<WithdrawalRequest> requests = new ArrayList<>();


    public void submit(WithdrawalRequest r) { requests.add(r); }
    public List<WithdrawalRequest> getAll() { return requests; }
}