package com.template.states;

import com.template.contracts.TemplateContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.Party;

import java.util.Arrays;
import java.util.List;

// *********
// * State *
// *********
@BelongsToContract(TemplateContract.class)
// Replace TemplateState's definition with:
public class IOUState implements ContractState {
    private final int valuee;
    private final Party lender;
    private final Party borrower;

    public IOUState(int valuee, Party lender, Party borrower) {
        this.valuee = valuee;
        this.lender = lender;
        this.borrower = borrower;
    }

    public int getValuee() {
        return valuee;
    }

    public Party getLender() {
        return lender;
    }

    public Party getBorrower() {
        return borrower;
    }

    @Override
    public List<AbstractParty> getParticipants() {
        return Arrays.asList(lender, borrower);
    }
}