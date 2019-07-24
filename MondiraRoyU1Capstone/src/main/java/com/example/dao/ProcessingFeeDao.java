package com.example.dao;

import com.example.model.ProcessingFee;

import java.util.List;

public interface ProcessingFeeDao {
   ProcessingFee addProcessingFee(ProcessingFee processingFee);

   List<ProcessingFee> getAllProcessingFees();

   void updateProcessingFee(ProcessingFee processingFee);

    void deleteProcessingFee(String productType);

    //Defining the additional operations to be performed on Processing_Fee table

    ProcessingFee getProcessingFeeByProductType(String productType);
}
