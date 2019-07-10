
package com.school.registerdb.service.impl;

import com.school.registerdb.dao.LoanDao;
import com.school.registerdb.model.Loan;
import com.school.registerdb.service.LoanManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 *
 * @author jhonny
 */
@Service
public class LoanManagerImpl extends GenericManagerImpl<Loan, Long> implements LoanManager {

    private LoanDao loanDao;

    @Autowired
    public LoanManagerImpl(LoanDao loanDao) {
        super(loanDao);
        this.loanDao = loanDao;
    }
}
