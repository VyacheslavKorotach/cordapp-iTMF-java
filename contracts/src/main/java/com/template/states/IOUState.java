package com.template.states;

import com.template.contracts.TemplateContract;
import net.corda.core.contracts.BelongsToContract;
import net.corda.core.contracts.ContractState;
import net.corda.core.contracts.UniqueIdentifier;
import net.corda.core.identity.AbstractParty;
import net.corda.core.identity.AnonymousParty;
import net.corda.core.identity.Party;
import net.corda.core.serialization.ConstructorForDeserialization;
import net.corda.core.serialization.CordaSerializable;

import java.util.Arrays;
import java.util.List;

// *********
// * State */
// *********
@BelongsToContract(TemplateContract.class)
// Replace TemplateState's definition with:..
public class IOUState implements ContractState {
    private final int val;
    private final Party lender;
    private final Party borrower;

    public IOUState(int value, Party lender, Party borrower) {
        this.val = value;
        this.lender = lender;
        this.borrower = borrower;
    }

    public int getValue() {
        return val;
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