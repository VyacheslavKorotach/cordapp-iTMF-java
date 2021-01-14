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
    private final int value1;
    private final Party lender;
    private final Party borrower;

    public IOUState(int value1, Party lender, Party borrower) {
        this.value1 = value1;
        this.lender = lender;
        this.borrower = borrower;
    }

    public int getValue1() {
        return value1;
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