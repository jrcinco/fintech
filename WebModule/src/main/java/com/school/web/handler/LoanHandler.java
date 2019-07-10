package com.school.web.handler;

import com.school.registerdb.model.Loan;
import com.school.registerdb.model.Period;
import com.school.registerdb.service.LoanManager;
import com.school.web.dto.LoanPeriodDto;
import com.school.web.dto.LoanResultDto;
import com.school.web.validation.annotation.FieldValidation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author jhonny
 */
@Service
@Transactional
public class LoanHandler {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private static final String FLAT_RATE = "FLAT";
    private static final String DECLINING_RATE = "DECLINING";
    @Autowired
    private LoanManager loanManager;
    
    public LoanResultDto getEMI(Long amount, Long period) {
        List<Loan> loans = loanManager.getAll();

        if (loans.isEmpty()) {
            return new LoanResultDto();
        } else {
            Iterator<Loan> iter = loans.iterator();
            boolean loanFlag = true;
            boolean periodFlag = true;
            Loan loan = null;
            Period loanPeriod = null;
            while (loanFlag && iter.hasNext()) {
                loan = iter.next();
                logger.info("[LoanHandler.getEMI] Loan size: {}", loan.getPeriods().size());
                if (amount >= loan.getLoanAmountMin() && amount <= loan.getLoanAmountMax()) {
                    loanFlag = false;
                    Iterator<Period> iterPeriod = loan.getPeriods().iterator();
                    while (periodFlag && iterPeriod.hasNext()) {
                        loanPeriod = iterPeriod.next();
                        if (period >= loanPeriod.getPeriodMin() && period <= loanPeriod.getPeriodMax()) {
                            loanFlag = false;
                        }
                    }
                }
            }

            logger.info("[LoanHandler.getEMI] Loan: {}", loan);
            logger.info("[LoanHandler.getEMI] Period: {}", loanPeriod);
            Double interest = (double) loan.getLoanInterest();
            Double emi;
            if (loanPeriod.getInterestRate().equalsIgnoreCase(FLAT_RATE)) {
                emi = (amount + amount*(period/12)*(interest/100))/period;
            } else { // declining rate.
                emi = ((1 + (interest/100)/12)*amount*(interest/100)*period)/(12*period*(1 + (interest/100)) - 1);
            }

            return new LoanResultDto(emi, interest);
        }
    }

    @FieldValidation
    public void create(@Validated LoanPeriodDto dto) {
        Set<Period> periods = new HashSet<>();
        Period period;
        Loan loan = new Loan(dto.getLoanAmountMin(), dto.getLoanAmountMax(), dto.getLoanInterest(), periods);
        for (LoanPeriodDto.PeriodDto periodDto : dto.getPeriods()) {
            period = new Period(loan, periodDto.getPeriodMin(), periodDto.getPeriodMax(), periodDto.getInterestRate());
            periods.add(period);
        }

        logger.info("[LoanHandler.create] Loan: {}", loan);
        loanManager.saveOrUpdate(loan);
    }
}
