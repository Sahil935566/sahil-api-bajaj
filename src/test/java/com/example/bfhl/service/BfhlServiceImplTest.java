package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BfhlServiceImplTest {

    private final BfhlServiceImpl service = new BfhlServiceImpl();

    @Test
    void testProcessData() {
        RequestDto request = new RequestDto();
        request.setData(Arrays.asList("a", "1", "334", "4", "R", "$"));

        ResponseDto response = service.processData(request);

        assertTrue(response.isSuccess());
        assertEquals("sahil_kumar_25112004", response.getUserId());
        assertEquals("sahil1403.be23@chitkara.edu.in", response.getEmail());
        assertEquals("2310991403", response.getRollNumber());
        assertEquals(Arrays.asList("1"), response.getOddNumbers());
        assertEquals(Arrays.asList("334", "4"), response.getEvenNumbers());
        assertEquals(Arrays.asList("A", "R"), response.getAlphabets());
        assertEquals(Arrays.asList("$"), response.getSpecialCharacters());
        assertEquals("339", response.getSum());
        assertEquals("Ra", response.getConcatString());
    }

    @Test
    void testProcessDataExampleB() {
        RequestDto request = new RequestDto();
        request.setData(Arrays.asList("2", "a", "y", "4", "&", "-", "*", "5", "92", "b"));

        ResponseDto response = service.processData(request);

        assertTrue(response.isSuccess());
        assertEquals(Arrays.asList("5"), response.getOddNumbers());
        assertEquals(Arrays.asList("2", "4", "92"), response.getEvenNumbers());
        assertEquals(Arrays.asList("A", "Y", "B"), response.getAlphabets());
        assertEquals(Arrays.asList("&", "-", "*"), response.getSpecialCharacters());
        assertEquals("103", response.getSum());
        assertEquals("ByA", response.getConcatString());
    }

    @Test
    void testProcessDataEmpty() {
        RequestDto request = new RequestDto();
        ResponseDto response = service.processData(request);

        assertFalse(response.isSuccess());
    }
}
