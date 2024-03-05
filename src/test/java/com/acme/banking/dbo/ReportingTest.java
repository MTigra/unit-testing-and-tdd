package com.acme.banking.dbo;

import com.acme.banking.dbo.domain.Branch;
import com.acme.banking.dbo.service.Reporting;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ReportingTest {

    @Test
    public void shouldReturnEmptyReportWhenBranchIsNull() {
        var sut = new Reporting();

        String actualReport = sut.getReport(null);
        Assertions.assertEquals("EMPTY REPORT", actualReport);
    }

    @Test
    public void shouldFailWhenBranchIsIncorrect() {
        var sut = new Reporting();
        var incorrectBranch = mock(Branch.class);
        when(incorrectBranch.getAccounts()).thenReturn(null);

        Assertions.assertThrows(IllegalArgumentException.class, () -> sut.getReport(incorrectBranch));
    }

    @Test
    public void shouldPrintReportWhenNoAccountAndNoChildren(){
        var sut = new Reporting();
        var branchStub = mock(Branch.class);
        when(branchStub.getId()).thenReturn(1);
        when(branchStub.getAccountSum()).thenReturn(0.0);

        Assertions.assertEquals("# BRANCH 1 (0.0)", sut.getReport(branchStub));
    }

    @Test
    public void shouldPrintReportWhenBranchHasOneAccountAndNoChildren(){
        var sut = new Reporting();
        var branchStub = mock(Branch.class);
        when(branchStub.getId()).thenReturn(1);
        when(branchStub.getAccountSum()).thenReturn(0.0);



    }

//    - проверить что придет Empty Report когда нет бранчей
//    - должен сфорироваться отчет когда есть 1 счет

    @Disabled
    @Test
    public void shouldReturnCorrectMarkdownWhenCorrectBranch() {

    }


}
