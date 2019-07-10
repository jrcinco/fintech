package com.school.testcases.apitesting;

import com.school.automation.common.DataPath;
import com.school.automation.common.EndpointPath;
import com.school.automation.payload.LoanPeriodPayload;
import com.school.automation.util.DataBaseUtil;
import com.school.automation.util.MapperUtil;
import com.school.automation.util.RequestUtil;
import com.school.registerdb.util.Constants;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@RunWith(JUnitParamsRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoanPeriodPositiveTest {
    private final static Logger logger = LoggerFactory.getLogger(LoanPeriodPositiveTest.class);
    private static List<LoanPeriodPayload> expectedResults = new ArrayList<>();

    /**
     * This test method is invoked once before any test method found from this class
     * or from the inner classes is invoked.
     */
    @BeforeClass
    public static void setUpClass() {
        logger.info("Invoked once before all test methods");        
        DataBaseUtil.cleanup(); // Clean Database.
        
        MapperUtil<LoanPeriodPayload> mapper = new MapperUtil<>();
        expectedResults = mapper.getJsonListFunctionality(LoanPeriodPayload.class, DataPath.LOAN_PERIOD_LIST_PATH);
        logger.info("[LoanPositiveTest][setUpClass] Json List: " + expectedResults);
    }
    
    /**
     * This test method is invoked once after all test methods found from this class
     * or from the inner classes have been invoked.
     */
    @AfterClass
    public static void tearDownClass() {
        logger.info("Invoked once after all test methods");        
    }

    @Test
    @Parameters({
            "0",
            "1"
    })
    public void test1PostLoanPeriod(int index) {
        logger.info("LoanPositiveTest: API Testing: POST {}", index);

        Response response = RequestUtil.postRequest(EndpointPath.LOAN_PATH, expectedResults.get(index));

        logger.info("Status Code: {}", response.getStatus());
        if (response.getStatus() == Constants.OK_STATUS_CODE) {
            assertTrue(true);  // Check that a condition is true.
        } else {
            assertTrue(false); // Check that a condition is false.
        }
    }

    @Test
    @Parameters({
            "500, 6",
            "50000, 15"
    })
    public void test2CalculateEMI(Long amount, Long period) {
        logger.info("LoanPositiveTest: API Testing: GET");
        logger.info("LoanPositiveTest: API Testing: GET--------- {}", amount);

        Map<String, Object> pathParams = new HashMap<>();
        pathParams.put("amount", amount);
        pathParams.put("period", period);
        Response response = RequestUtil.getRequest(EndpointPath.LOAN_AMOUNT_PERIOD_PATH, pathParams);

        logger.info("LoanPositiveTest: API Testing: GET Status {}", response.getStatus());

        if (response.getStatus() == Constants.OK_STATUS_CODE) {
            assertTrue(true);  // Check that a condition is true.
        } else {
            logger.error("Status Code: " + response.getStatus());
            assertTrue(false); // Check that a condition is false.
        }
    }
}
