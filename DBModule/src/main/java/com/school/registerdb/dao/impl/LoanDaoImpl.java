package com.school.registerdb.dao.impl;

import com.school.registerdb.dao.LoanDao;
import com.school.registerdb.model.Loan;
import java.util.List;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author jhonny
 */
@Repository
public class LoanDaoImpl extends GenericDaoImpl<Loan, Long> implements LoanDao {
    public LoanDaoImpl() {
        super(Loan.class);
    }
}
