package com.school.web.controller;

import com.school.web.common.payload.OperationResult;
import com.school.web.dto.LoanPeriodDto;
import com.school.web.dto.LoanResultDto;
import com.school.web.handler.LoanHandler;
import com.school.web.util.ResponseUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author jhonny
 */
@RestController
@RequestMapping("/loan")
@Api(value="finance", description="Operations to create Loans in finance")
public class LoanController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private LoanHandler loanHandler;

    /**
     * The request param are optional.
     */
    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    @ApiOperation(value = "View a list of available Loans", response = LoanResultDto.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error: Application exception. Please contact your administrative personnel for technical support")
    })
    public LoanResultDto calculteEMI(
            @RequestParam(required=false, value = "amount") Long amount,
            @RequestParam(required=false, value = "period") Long period) {
        logger.info("[LoanController.calculateEMI] amount: {}", amount);
        logger.info("[LoanController.calculateEMI] period: {}", period);
        return loanHandler.getEMI(amount, period);
    }
    
    @ResponseBody
    @RequestMapping(method = RequestMethod.POST)
    @ApiOperation(value = "Create Loans", response = OperationResult.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success"),
            @ApiResponse(code = 400, message = "Bad Request"),
            @ApiResponse(code = 500, message = "Server Error: Application exception. Please contact your administrative personnel for technical support")
    })
    public OperationResult createLoan(@RequestBody final LoanPeriodDto payload) {
        logger.info("[LoanController.create] json data: {}", payload);
        logger.info("[LoanController.create] Handler: {}", loanHandler);
        loanHandler.create(payload);
        return ResponseUtil.ok();
    }
}
