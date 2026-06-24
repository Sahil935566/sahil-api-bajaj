package com.example.bfhl.service;

import com.example.bfhl.dto.RequestDto;
import com.example.bfhl.dto.ResponseDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BfhlServiceImpl implements BfhlService {

        private static final String USER_ID = "sahil_kumar_25112004";
    private static final String EMAIL = "sahil1403.be23@chitkara.edu.in";
    private static final String ROLL_NUMBER = "2310991403";

    @Override
    public ResponseDto processData(RequestDto requestDto) {
        ResponseDto response = new ResponseDto();
        response.setUserId(USER_ID);
        response.setEmail(EMAIL);
        response.setRollNumber(ROLL_NUMBER);

        if (requestDto == null || requestDto.getData() == null) {
            response.setSuccess(false);
            return response;
        }

        response.setSuccess(true);

        List<String> oddNumbers = new ArrayList<>();
        List<String> evenNumbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        List<String> specialCharacters = new ArrayList<>();
        long sum = 0;

        List<Character> allAlphabets = new ArrayList<>();

        for (String item : requestDto.getData()) {
            if (item == null || item.isEmpty()) continue;
            
            if (item.matches("^-?\\d+$")) {
                try {
                    long num = Long.parseLong(item);
                    sum += num;
                    if (num % 2 == 0) {
                        evenNumbers.add(item);
                    } else {
                        oddNumbers.add(item);
                    }
                } catch (NumberFormatException e) {
                    // if number is too large, just treat as string
                    specialCharacters.add(item);
                }
            } else if (item.length() == 1 && Character.isLetter(item.charAt(0))) {
                alphabets.add(item.toUpperCase());
                allAlphabets.add(item.charAt(0));
            } else {
                specialCharacters.add(item);
            }
        }

        response.setOddNumbers(oddNumbers);
        response.setEvenNumbers(evenNumbers);
        response.setAlphabets(alphabets);
        response.setSpecialCharacters(specialCharacters);
        response.setSum(String.valueOf(sum));

        StringBuilder concatBuilder = new StringBuilder();
        boolean isUpper = true;
        
        for (int i = allAlphabets.size() - 1; i >= 0; i--) {
            char c = allAlphabets.get(i);
            if (isUpper) {
                concatBuilder.append(Character.toUpperCase(c));
            } else {
                concatBuilder.append(Character.toLowerCase(c));
            }
            isUpper = !isUpper;
        }
        
        response.setConcatString(concatBuilder.toString());
        return response;
    }
}
