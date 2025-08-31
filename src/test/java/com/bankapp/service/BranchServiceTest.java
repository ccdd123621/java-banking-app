package com.bankapp.service;

import com.bankapp.model.Branch;
import com.bankapp.repository.BranchRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class BranchServiceTest {

    @Mock
    private BranchRepository branchRepository;

    @InjectMocks
    private BranchServiceImpl branchService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindById() {
        Branch branch = new Branch();
        branch.setBranchName("Downtown");
        when(branchRepository.findById(1L)).thenReturn(Optional.of(branch));

        Optional<Branch> found = branchService.findById(1L);
        assertEquals("Downtown", found.get().getBranchName());
    }
}
