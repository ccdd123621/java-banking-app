package com.bankapp.controller;

import com.bankapp.entity.Branch;
import com.bankapp.repository.BranchRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BranchControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private BranchRepository branchRepository;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        branchRepository.deleteAll();
        Branch branch = new Branch();
        branch.setBranchName("Main Branch");
        branch.setBranchCode("MB001");
        branchRepository.save(branch);
    }

    @Test
    void testGetAllBranches() throws Exception {
        mockMvc.perform(get("/branches"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].branchName").value("Main Branch"));
    }

    @Test
    void testCreateBranch() throws Exception {
        Branch branch = new Branch();
        branch.setBranchName("City Branch");
        branch.setBranchCode("CB002");

        mockMvc.perform(post("/branches")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(branch)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.branchName").value("City Branch"));
    }
}
