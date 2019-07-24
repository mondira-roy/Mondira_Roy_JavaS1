package com.example.dao;

import com.example.model.ProcessingFee;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ProcessingFeeDaoJdbcTemplateImplTest {

    @Autowired
    ProcessingFeeDao processingFeeDao;

    @Before
    public void setUp() throws Exception {
        List<ProcessingFee> fees = processingFeeDao.getAllProcessingFees();
        for (ProcessingFee i : fees) {

            processingFeeDao.deleteProcessingFee(i.getProductType());
        }
    }

//    @Test
//    public void addGetDeleteProcessingFee() {
//        ProcessingFee fee = new ProcessingFee();
//
//
//    }

    @Test
    public void getProcessingFeeByProductType() {

        ProcessingFee fee = processingFeeDao.getProcessingFeeByProductType("");
    }

    @Test
    public void getAllProcessingFees() {

        List<ProcessingFee> fees = processingFeeDao.getAllProcessingFees();
    }

    @Test
    public void updateProcessingFee() {
    }


}